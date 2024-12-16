

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(description="A simple servlet",urlPatterns={"/SimplePath"},
initParams = {@WebInitParam(name="defaultUser",value="Johb")} )
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int a=0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from Get method");
		response.setContentType("text/html");
		String username=request.getParameter("userName");
		HttpSession session=request.getSession();
		if (username!=""&& username!=null) {
			session.setAttribute("savedUserName", username);
		}
		PrintWriter writer =response.getWriter();
		writer.println("Hello parameters"+ username + a++ );
		writer.println("Hello session "+ session.getAttribute("savedUserName") + a++ );
		writer.println("Hello init"+ this.getServletConfig().getInitParameter("defaultUser") + a++ );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from post method");
		response.setContentType("text/html");
		String username=request.getParameter("userName");
		PrintWriter writer =response.getWriter();
		writer.println("Hello from post "+ username + a++);
	}

}

