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


public class Shop extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Shop() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(true);
	    if (session.getAttribute("Cart")==null) {
		    Cart cartInstance= new Cart();
		    session.setAttribute("Cart", cartInstance);	   
	    }

		DanhMucDAO dbDao=new DanhMucDAO();
		List<DanhMuc> listPT=dbDao.findAll();
		SanPhamDAO productdao=new SanPhamDAO();
		
		
		 String searchbox=request.getParameter("searchbox");
		 if (searchbox!=null) {
			 String radioValue = request.getParameter("filterprice");
			 String minprice= request.getParameter("filterpricemin");
			 String maxprice= request.getParameter("filterpricemax");
			 String id_category=request.getParameter("id_category");
		
			 if (searchbox!=null) searchbox=searchbox.trim();
			 else searchbox="";
			 String  query=" ten LIKE '%"+searchbox+"%' ";
			 if (!minprice.trim().equals("")&&maxprice.trim().equals("")) {
				 radioValue=null;
				 query +=" AND gia_ban-gia_ban*giam_gia/100 >= "+minprice.trim()+" AND gia_ban-gia_ban*giam_gia/100 <= 999999999";
			 }
			 else
			 if (minprice.trim().equals("")&&!maxprice.trim().equals("")) {
				 radioValue=null;
				 query +=" AND gia_ban-gia_ban*giam_gia/100 >= 0"+" AND gia_ban-gia_ban*giam_gia/100 <= "+maxprice.trim();
			 }
			 else {
				 if (!minprice.trim().equals("")) {
					 radioValue=null;
					 
					 query +=" AND gia_ban-gia_ban*giam_gia/100 >= "+minprice.trim();
					
				 }
				 if (!maxprice.trim().equals("")) {
					 radioValue=null;
					 query +=" AND gia_ban-gia_ban*giam_gia/100 <= "+maxprice.trim();
					
				 }
			 }
		if (radioValue!=null) {
			if (radioValue.equals("duoi1trieu")) {
				query +=" AND gia_ban-gia_ban*giam_gia/100 <= 1000000";
	       } else if (radioValue.equals("tu1trieuden5")) {
	       	query +=" AND gia_ban-gia_ban*giam_gia/100 <= 5000000 AND gia_ban-gia_ban*giam_gia/100 >= 1000000 ";
	       }
	       else if (radioValue.equals("tu5den10trieu")) {
	       	query +=" AND gia_ban-gia_ban*giam_gia/100 <= 10000000 AND gia_ban-gia_ban*giam_gia/100 >= 5000000 ";
	       }
	       else if (radioValue.equals("tren10trieu")) {
	       	query +=" AND gia_ban-gia_ban*giam_gia/100 >= 1000000";
	       }
		}
		 if (!(id_category.trim().equals("all"))) {
			 
				query +=" AND id_danh_muc = "+id_category.trim() ;
		 }
		response.getWriter().append("Served at: " +query);
		
	  List<SanPham> listP=productdao.SearchQuery(query);
	  request.setAttribute("listP", listP);
		 }
		 else {
				List<SanPham> listP=productdao.findAllBeginEnd(0,3);
				request.setAttribute("listP", listP);
		 }
		
		
	
		request.setAttribute("listPT", listPT);
		
		 RequestDispatcher dispatcher=request.getRequestDispatcher("shoppage.jsp");
		 dispatcher.forward(request, response);
		 //request.getRequestDispatcher("/test.jsp").forward(request, response);
	}

}
