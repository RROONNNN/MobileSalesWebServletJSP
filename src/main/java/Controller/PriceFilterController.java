package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PriceFilterController
 */
public class PriceFilterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceFilterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String radioValue = request.getParameter("locgia");
		 if (radioValue.equals("duoi1trieu")) {
				response.getWriter().append("Served at: duoi1trieu ").append(request.getContextPath());
	        } else if (radioValue.equals("tu1trieuden5")) {
	        	response.getWriter().append("tu1trieuden5").append(request.getContextPath());
	        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String radioValue = request.getParameter("locgia");
		 if (radioValue.equals("duoi1trieu")) {
	         
	        } else if (radioValue.equals("tu1trieuden5")) {
	           
	        }

	        // Chuyển hướng người dùng đến một trang JSP mới với nội dung cập nhật
	       // RequestDispatcher dispatcher = request.getRequestDispatcher("updated-page.jsp");
	       // dispatcher.forward(request, response);
		 
	}

}
