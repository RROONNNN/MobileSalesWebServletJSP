package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Cart;

/**
 * Servlet implementation class changeCartNum
 */
public class changeCartNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeCartNum() {
        super();
        // TODO Auto-generated constructor stub
    }
/* <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill"><%=cartInstance.getQuantity() %></span>*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		  Cart cartInstance=(Cart)request.getSession().getAttribute("Cart");
		out.println("""
				<i class="bi-cart-fill me-1"></i>
                            Giỏ hàng
                            <span class="badge bg-dark text-white ms-1 rounded-pill">"""+ cartInstance.getSoluong()+ "</span>"
				);
		System.out.println(
				"""
				<i class="bi-cart-fill me-1"></i>
                            Giỏ hàng
                            <span class="badge bg-dark text-white ms-1 rounded-pill">"""+ cartInstance.getSoluong()+ "</span>"
				);
		
	}


}
