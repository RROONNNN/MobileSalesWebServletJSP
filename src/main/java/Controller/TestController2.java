package Controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

import Model.Cart;

/**
 * Servlet implementation class TestController2
 */
public class TestController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {

			response.getWriter().append("Served at: ").append(c.getName()+" : "+c.getValue());
		}
		
		HttpSession session=request.getSession();
		if (session.getAttribute("RonSession")!=null) {
		response.getWriter().append("Served at: " +session.getAttribute("RonSession"));
		
		}
		if (session.getAttribute("Rieng")!=null) {
			response.getWriter().append("Served at: " +session.getAttribute("Rieng"));
			
			}
		if (session.getAttribute("Cart")!=null) {
			Cart cart=(Cart)session.getAttribute("Cart");
			response.getWriter().append("Served at: " +cart.getSoluong());

			}
		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		    	System.out.print("Ngu")	;
		    	   cookie.setValue("");
		            cookie.setPath("/");
		            cookie.setMaxAge(0);
		        response.addCookie(cookie);
		    }
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
