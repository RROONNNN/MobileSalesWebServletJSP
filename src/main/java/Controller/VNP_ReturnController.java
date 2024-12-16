package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import com.google.gson.Gson;
import com.mysql.cj.Session;

import Config.ConfigOfWeb;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import Model.Cart;
import Model.HoaDon;
import Model.KhachHang;
import Model.PaymentWrap;

/**
 * Servlet implementation class VNP_ReturnController
 */
public class VNP_ReturnController extends HttpServlet {//Khong sai
	private static final long serialVersionUID = 1L;
       
  
    public VNP_ReturnController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Long vnp_Amount=Long.parseLong(request.getParameter("vnp_Amount"));
		String	vnp_TransactionStatus=request.getParameter("vnp_TransactionStatus");
		String	vnp_BankCode=request.getParameter("vnp_BankCode");
		String	vnp_ResponseCode=request.getParameter("vnp_ResponseCode");
		String	vnp_PayDate=request.getParameter("vnp_PayDate");
		String	vnp_CardType=request.getParameter("vnp_CardType");
	
		HttpSession session=request.getSession();
		
		if (vnp_TransactionStatus.equals("00")&&vnp_ResponseCode.equals("00")) {//thanh cong*/
			
		if (session.getAttribute("Cart")==null) {
				 response.sendRedirect("http://localhost:8080//FirstProjectServlet/");
				 return;
			}
			else 
{
		String SDTKhachHang =(String) request.getSession().getAttribute("SDTKhachHang");
				
				String tenKhachHang=(String) request.getSession().getAttribute("tenKhachHang");				
				String DiaChiKhachHang=(String) request.getSession().getAttribute("DiaChiKhachHang");
	
				
				  Cart cartInstance=(Cart)request.getSession().getAttribute("Cart");
				 if (cartInstance==null||SDTKhachHang==null||DiaChiKhachHang==null) {
					 response.sendRedirect(ConfigOfWeb.HomePageLink);
					 return;
				 }
				 
					  KhachHangDAO khachHangDAO=new KhachHangDAO();
					  KhachHang khachHang=new KhachHang(SDTKhachHang, tenKhachHang, DiaChiKhachHang);
					    int id_khachhang=khachHangDAO.findIdBySDT(khachHang.getSo_dien_thoai());
					     if (id_khachhang==0) {
					    	 id_khachhang=khachHangDAO.InsertKhachHang(khachHang);
					     }	
					  HoaDonDAO hoaDonDAO=new HoaDonDAO();
					  HoaDon hoadon=new HoaDon(99,id_khachhang , vnp_Amount);
					 // hoaDonDAO.Excute_Transaction(hoadon, khachHang,cartInstance);
					  
					session.removeAttribute("Cart");
					
					Cookie[] cookies=request.getCookies();
					if (cookies != null) {
				        for (Cookie cookie : cookies) {
				            String name = cookie.getName();
				            String value = cookie.getValue();
				            System.out.println("Cookie name: " + name + ", Cookie value: " + value);
				        }
					}
					
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("vnpay_ReturnPage.jsp");
					 requestDispatcher.forward(request, response);
			}
		}
		}		
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		System.out.println("Post at: " );
		String SDTKhachHang =(String) request.getSession().getAttribute("SDTKhachHang");
		String tenKhachHang=(String) request.getSession().getAttribute("tenKhachHang");;
		String DiaChiKhachHang=(String) request.getSession().getAttribute("DiaChiKhachHang");;
		response.getWriter().append("Served at: " +SDTKhachHang +tenKhachHang +DiaChiKhachHang);
		Cookie[] cookies=request.getCookies();
		if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            String name = cookie.getName();
	            String value = cookie.getValue();
	            System.out.println("Cookie name: " + name + ", Cookie value: " + value);
	        }
		}
		if (session.getAttribute("RonSession")!=null) {
			System.out.println("Post at: " +session.getAttribute("RonSession"));
			
			}
		if (session.getAttribute("Rieng")!=null) {
			System.out.println("Post at: " +session.getAttribute("Rieng"));
			
			}
		}	
		
	}
/*	private Cart getCartFromCookies(HttpServletRequest request,String CartCookieName) {
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(CartCookieName) ) {
					Gson gson=new Gson();
					return gson.fromJson(cookie.getValue(), Cart.class);
				}
			}
		}
		return null;
	}*/


