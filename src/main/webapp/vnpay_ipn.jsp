<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.nio.charset.StandardCharsets"%>

<%@page import="java.net.URLEncoder"%>
<%@page import="Config.Config"%>
<%@page import="Model.*"%>
<%@page import="DAO.*"%>
<%@page import="com.google.gson.Gson"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<% 



System.out.print("Zoo");

    Map fields = new HashMap();
             for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }
    String vnp_SecureHash = request.getParameter("vnp_SecureHash");
    if (fields.containsKey("vnp_SecureHashType")) {
        fields.remove("vnp_SecureHashType");
    }
    if (fields.containsKey("vnp_SecureHash")) {
        fields.remove("vnp_SecureHash");
    }
    String signValue = Config.hashAllFields(fields);
    if (signValue.equals(vnp_SecureHash)) {
    	String vnp_TxnRef=request.getParameter("vnp_TxnRef");
    	DonHangGiaoDichJedisDAO jedisDAO =new DonHangGiaoDichJedisDAO();
     	DonHangGiaoDich donHangGiaoDich=jedisDAO.GetElement(vnp_TxnRef);
     	
     	CartJsonOnlyIdRef cartInstance=donHangGiaoDich.getCartJsonOnlyIdRef();
        boolean checkOrderId = true; // Giá trị của vnp_TxnRef tồn tại trong CSDL của merchant
        boolean checkAmount = true; //Kiểm tra số tiền thanh toán do VNPAY phản hồi(vnp_Amount/100) với số tiền của đơn hàng merchant tạo thanh toán: giả sử số tiền kiểm tra là đúng.
        boolean checkOrderStatus = true; // Giả sử PaymnentStatus = 0 (pending) là trạng thái thanh toán của giao dịch khởi tạo chưa có IPN.
        if (checkOrderId) {
            if (checkAmount) {
                if (checkOrderStatus) {
                    if ("00".equals(request.getParameter("vnp_ResponseCode"))) {
                    	Long vnp_Amount=Long.parseLong(request.getParameter("vnp_Amount"))/100;
                    
              		String SDTKhachHang =donHangGiaoDich.getSDTKhachHang();
    				String tenKhachHang=donHangGiaoDich.getTenKhachHang();
    				String DiaChiKhachHang=donHangGiaoDich.getDiaChiKhachHang();
    				CartJsonOnlyIdRef cartJsonOnlyIdRef=donHangGiaoDich.getCartJsonOnlyIdRef();
    	
    				System.out.print("GD Thanh cong"+SDTKhachHang);
    				  KhachHangDAO khachHangDAO=new KhachHangDAO();
					  KhachHang khachHang=new KhachHang(SDTKhachHang, tenKhachHang, DiaChiKhachHang);
					    int id_khachhang=khachHangDAO.findIdBySDT(khachHang.getSo_dien_thoai());
					     if (id_khachhang==0) {
					    	 id_khachhang=khachHangDAO.InsertKhachHang(khachHang);
					     }	
					  HoaDonDAO hoaDonDAO=new HoaDonDAO();
					  HoaDon hoadon=new HoaDon(99,id_khachhang , vnp_Amount);
					  hoaDonDAO.Excute_Transaction(hoadon, khachHang,cartJsonOnlyIdRef);
                        System.out.print("GD Thanh cong"+SDTKhachHang+cartInstance.getNumSanpham());
                    } else {
                        //Xử lý/Cập nhật tình trạng giao dịch thanh toán "Không thành công"
                         System.out.print("GD k Thanh cong");
                        //  out.print("GD Khong thanh cong");
                    }
                    out.print("{\"RspCode\":\"00\",\"Message\":\"Confirm Success\"}");
                } else {
                    //Trạng thái giao dịch đã được cập nhật trước đó
                         System.out.print("Trạng thái giao dịch đã được cập nhật trước đó");
                    out.print("{\"RspCode\":\"02\",\"Message\":\"Order already confirmed\"}");
                }
            } else {
                //Số tiền không trùng khớp
                  System.out.print("Số tiền không trùng khớp");
                out.print("{\"RspCode\":\"04\",\"Message\":\"Invalid Amount\"}");
            }
        } else {
            //Mã giao dịch không tồn tại
                System.out.print("Mã giao dịch không tồn tại");
            out.print("{\"RspCode\":\"01\",\"Message\":\"Order not Found\"}");
        }

    } else {
        // Sai checksum
         System.out.print("Mã giao dịch không tồn tại");
        out.print("{\"RspCode\":\"97\",\"Message\":\"Invalid Checksum\"}");
    }
%>
</body>
</html>