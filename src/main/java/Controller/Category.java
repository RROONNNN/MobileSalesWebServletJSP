package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import DAO.DanhMucDAO;

import DAO.SanPhamDAO;
import Model.DanhMuc;

import Model.SanPham;

/**
 * Servlet implementation class Category
 */
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Category() {
        super();
        // TODO Auto-generated constructor stub
    }
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid= Integer.parseInt(request.getParameter("Cid")) ;
		DanhMucDAO dbDao=new DanhMucDAO();
		List<DanhMuc> listPT=dbDao.findAll();
		SanPhamDAO productdao=new SanPhamDAO();
		List<SanPham> listP=productdao.findAllByIdDm(cid);
		request.setAttribute("listPT", listPT);
		request.setAttribute("listP", listP);
		System.out.print(request.getRequestURL());

		RequestDispatcher dispatcher=request.getRequestDispatcher("shoppage.jsp");
		 dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
