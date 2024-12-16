package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.SanPhamDAO;
import Model.Cart;
import Model.SanPham;

/**
 * Servlet implementation class AddToCartController
 */
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  idproduct=Integer.parseInt(request.getParameter("Pid"));
		System.out.print(idproduct);
		   Cart cartInstance=(Cart)request.getSession().getAttribute("Cart");
		if(cartInstance==null) System.out.print("kh co session ");	
		else  {
			SanPhamDAO dao=new SanPhamDAO();
			SanPham product=dao.findById(idproduct);
			 System.out.print("product"+ product.getTen());
			cartInstance.addSanPham(product);
		}
		
	
	}

}
