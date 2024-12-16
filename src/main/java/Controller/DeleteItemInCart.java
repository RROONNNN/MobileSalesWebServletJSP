package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Model.Cart;

/**
 * Servlet implementation class DeleteItemInCart
 */
public class DeleteItemInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItemInCart() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  PidDelete=Integer.parseInt(request.getParameter("PidDelete"));
    
		Cart cart=(Cart) request.getSession().getAttribute("Cart");
		if (cart==null) {
			response.sendRedirect("http://localhost:8080/FirstProjectServlet");
		}
		else {
			cart.DeleteSanPham(PidDelete);
			 RequestDispatcher dispatcher=request.getRequestDispatcher("CartPage.jsp");
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

}
