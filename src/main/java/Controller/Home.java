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

import Config.ConfigOfWeb;
import DAO.DanhMucDAO;
import Model.Cart;
import Model.DanhMuc;

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConfigOfWeb.HomePageLink=request.getRequestURL().toString();
		System.out.print(ConfigOfWeb.HomePageLink);
		HttpSession session = request.getSession(true);
	    if (session.getAttribute("Cart")==null) {
		    Cart cartInstance= new Cart();
		    session.setAttribute("Cart", cartInstance);	   
	    }
	    
	    List<DanhMuc> listPT=(List<DanhMuc>)request.getAttribute("listPT"); 
        if (listPT==null) {
        	DanhMucDAO dbDao=new DanhMucDAO();
    		listPT=dbDao.findAll();
    		request.setAttribute("listPT", listPT);
        }
		 RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
		 dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
