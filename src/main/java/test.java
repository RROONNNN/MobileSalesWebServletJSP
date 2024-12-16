

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("list");		
		
		ProductTypeDAO dbDao=new ProductTypeDAO();
		out.println("list.get(1).getName()");
		dbDao=new ProductTypeDAO();
		out.println("list.get(1).getName()");
			List<ProductType> list=dbDao.getListProductTypes();
			out.println("list");
			out.println("list.get(1).getName()");
			out.println(list.get(1).getName());	
		System.out.println(list.get(1).getName());
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	

	}*/

}
