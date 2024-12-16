package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DAO.SanPhamDAO;
import Model.SanPham;

/**
 * Servlet implementation class LoadMoreControllerForDetailPage
 */
public class LoadMoreControllerForDetailPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadMoreControllerForDetailPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanPhamDAO productdao=new SanPhamDAO();
		int beginnum=Integer.parseInt(request.getParameter("beginnum"));
		int iddm=Integer.parseInt(request.getParameter("IdProductChossen"));
		 List<SanPham> list=productdao.findBeginEndByIdDM(iddm,beginnum,3);
		 PrintWriter writer=response.getWriter();
			list.forEach(it->{
				String s1= it.getGiam_gia()!=0 ?"    <div class=\"badge bg-dark text-white position-absolute\" style=\"top: 0.5rem; right: 0.5rem\">Sale</div>":"";
				String s2=                it.getGiam_gia()!=0 ?  " <small class=\"text-muted text-decoration-line-through\">"+it.getGia_ban()+"đ</small>\r\n"
						+ "                                    <span class=\"h5 mb-0 text-primary\"> "+ (int)(it.getGia_ban()-it.getGiam_gia()*it.getGia_ban()/100)+"đ</span>\r\n"
						:" <span class=\"h5 mb-0 text-primary\">"+it.getGia_ban()+"đ</span>\r\n";
				
				
				String s3=" <span onclick=\"addToCart("+it.getId()+")\" class=\"cart__button\">\r\n"
						+ "      <span class=\"add__to-cart\">Thêm giỏ hàng</span>\r\n"
						+ "      <span class=\"added\">Đã thêm</span>\r\n"
						+ "      <i class=\"fas fa-shopping-cart\"></i>\r\n"
						+ "      <i class=\"fas fa-box\"></i>\r\n"
						+ "    </span>" ;		
				String s4="<span style=\"color: red;\"> Sản phẩm hiện tại chưa sẵn sàng</span>";
				
				writer.println("   <div class=\"col mb-5 productitem\">\r\n"
						+ "                        <div class=\"card h-100\">\r\n"
						+ "                            <!-- Sale badge-->\r\n"
						
				+s1
						+ "                            <!-- Product image-->\r\n"
						
						+"<a href=\"DetailPageController?IdProductChossen="+it.getId()+"\">"
						+ "                            <img class=\"card-img-top\" src="+it.getHinh_anh()+" alt=\"...\" />\r\n"
						+" </a>"
						+ "                            <!-- Product details-->\r\n"
						+ "                            <div class=\"card-body p-4\">\r\n"
						+ "                                <div class=\"text-center\">\r\n"
						+ "                                    <!-- Product name-->\r\n"
						+ "                                    <h5 class=\"fw-bolder\">"+it.getTen()+"</h5>\r\n"
						+ "                                    <!-- Product reviews-->\r\n"
						+ "                               \r\n"
				
		+s2
		+ "                               </div>\r\n"
		+ "                                    <div class=\"card-footer p-4 pt-0 border-top-0 bg-transparent\">\r\n"
		+"    <div class=\"text-center\" style=\"  display: flex;\r\n"
		+ "  justify-content: center;\r\n"
		+ "  align-items: center;\">  "+(it.getDeleted()==0?s3:s4)+"</div>"
		+ "                     </div>\r\n"
		+ "                           </div>\r\n"
		+ "                                  </div>\r\n"
		+ "                                     \r\n"
		+ "                                     </div>");
			
				

			});
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
