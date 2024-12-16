package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


import com.google.gson.Gson;

import Config.ConfigOfWeb;
import Model.Cart;

/**
 * Servlet implementation class ThanhToanButtonController
 */
public class ThanhToanButtonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanButtonController() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// them so luong san pham o trang cart
HttpSession session=request.getSession();
if (session.getAttribute("Cart")==null) {
	 RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
	 dispatcher.forward(request, response);
}
else {
	String SDTKhachHang=request.getParameter("SDTKhachHang");
	String tenKhachHang=request.getParameter("tenKhachHang");
	String DiaChiKhachHang=request.getParameter("DiaChiKhachHang");
	//Cookie cookie=new Cookie("ngu", "Ngunay");
	
session.setAttribute("tenKhachHang", tenKhachHang);
session.setAttribute("SDTKhachHang", SDTKhachHang);
session.setAttribute("DiaChiKhachHang", DiaChiKhachHang);
	Cart cartinstance=(Cart) session.getAttribute("Cart");
	if (cartinstance==null) {
		response.sendRedirect(ConfigOfWeb.HomePageLink);
		return;
	}
	

	String[] list= request.getParameterValues("quantities");

	//response.getWriter().append("Served at: ").append(list.toString());
	
    for(int i=0;i<list.length;i++) {
    	try {
    		
    		int num=Integer.parseInt(list[i]);
    		cartinstance.addnumSanPham(num);
    		 if (cartinstance.getDsSanPham().get(i).getSo_luong_trong_kho()-num<0) {
    			 RequestDispatcher dispatcher=request.getRequestDispatcher("CartPage.jsp?soluongkdu=1");//vnpay_pay.jsp
    			 dispatcher.forward(request, response);
    			 return ;
    		 }
		} catch (NumberFormatException e) {
			System.err.println("ERROR Convert Integer to String");
		}    	
    }
  	System.out.println("---------");
    for(int i=0;i<list.length;i++) {
     cartinstance.getDsSanPham().get(i).getSo_luong_trong_kho();
    }
   
    
	//goi controller PaymentForm.jsp


	 RequestDispatcher dispatcher=request.getRequestDispatcher("vnpay_pay.jsp");//vnpay_pay.jsp
	 dispatcher.forward(request, response);
}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void saveCartToCookies(HttpServletResponse response,Cart cart,String path) {
		Gson gson=new Gson();
		String cartJson=gson.toJson(cart);
		System.out.println(cart);
		Cookie cartCookie=new Cookie("CartCookie", cartJson);
		cartCookie.setMaxAge(ConfigOfWeb.timeToLifeOfSessionAndCookie);
		cartCookie.setPath(path);
		response.addCookie(cartCookie);
	}	
	private Cart getCartFromCookies(HttpServletRequest request,String cookieString) {
		Gson gson=new Gson();
		return gson.fromJson(cookieString, Cart.class);}
}
