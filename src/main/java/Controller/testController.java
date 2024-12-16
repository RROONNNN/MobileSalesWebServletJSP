package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

/**
 * Servlet implementation class testController
 */
public class testController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


     //   response.sendRedirect("http://localhost:8080/FirstProjectServlet/TestController2");
		HttpSession session = request.getSession();
		session.setAttribute("Rieng", "rieng");
        request.getSession().setAttribute("RonSession", "ronSessionDeptrai");
        int b=123;
        request.getSession().setAttribute("RonSession", b);
		/*Cookie cookie=new Cookie("username", "RonDepTrai");
        response.addCookie(cookie);*/
        response.sendRedirect("http://localhost:8080/FirstProjectServlet/TestController2");
        /*RequestDispatcher dispatcher=request.getRequestDispatcher("TestController2");
		 dispatcher.forward(request, response);
        
       TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = messageFactory.create(
            new PhoneNumber(phoneNumber),
            new PhoneNumber(FROM_NUMBER),    
            "Your verification code is: " + verificationCode
        );*/
	}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String[] list= req.getParameterValues("numbers");

	resp.getWriter().append("Served at: ").append(list.toString());
}

}
