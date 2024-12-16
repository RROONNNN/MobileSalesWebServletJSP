package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import Model.Cart;
import Model.DanhMuc;
import Model.SanPham;

/**
 * Servlet implementation class DetailPageController
 */
public class DetailPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailPageController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    SanPhamDAO dao=new SanPhamDAO();
		String idProduct=request.getParameter("IdProductChossen");
    
        SanPham sPham=dao.findById(Integer.parseInt(idProduct));
        
    	request.setAttribute("ChossenProduct", sPham);
        HttpSession session =request.getSession();
        Cart cartInstance=(Cart)session.getAttribute("Cart");
 
        if (cartInstance==null) {
        	   cartInstance= new Cart();
  		    session.setAttribute("Cart", cartInstance);	 
        }
        
        List<DanhMuc> listPT=(List<DanhMuc>)request.getAttribute("listPT"); 
        if (listPT==null) {
        	DanhMucDAO dbDao=new DanhMucDAO();
    		listPT=dbDao.findAll();
    		request.setAttribute("listPT", listPT);
        }
        List<SanPham> ProductSuggestList =dao.findBeginEndByIdDM(sPham.getDanh_muc().getId(), 0, 3);
        request.setAttribute("ProductSuggestList", ProductSuggestList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("DetailPage.jsp");
		 dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
