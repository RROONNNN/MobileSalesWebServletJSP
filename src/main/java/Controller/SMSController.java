package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

import SMS.Sender;

/**
 * Servlet implementation class SMSController
 */
public class SMSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	 Sender sender;
    public SMSController() {
        super();
        // TODO Auto-generated constructor stub
        sender=new Sender();
    }
    private static String generateOTP() {
        Random random = new Random();
        int otp = random.nextInt(900000) + 100000;
        return String.valueOf(otp);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phonenum=request.getParameter("phonenumber");
		String otpcode=generateOTP();
		sender.send("+84"+phonenum.substring(1), "Chúng tôi là HBT Store ,Xin cảm ơn đã sử dụng dịch vụ của chúng tôi, Đây là mã OTP của bạn: "+otpcode);
		response.getWriter().print(otpcode);
		System.out.println(otpcode);
	}

}
