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
 * Servlet implementation class LoadmoreController
 */
public class LoadmoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadmoreController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		SanPhamDAO productdao=new SanPhamDAO();
		int beginnum=Integer.parseInt(request.getParameter("beginnum"));
		System.out.println(beginnum);
		 String radioValue = request.getParameter("radioValue");
		 String minprice= request.getParameter("minprice");
		 String maxprice= request.getParameter("maxprice");
		 String id_category=request.getParameter("id_category");
		 String searchbox=request.getParameter("searchbox");
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
		 
	if (radioValue!=null&&radioValue!="allprice") {
		if (radioValue.equals("duoi1trieu")) {
			query +=" AND gia_ban-gia_ban*giam_gia/100 <= 1000000";
       } else if (radioValue.equals("tu1trieuden5")) {
       	query +=" AND gia_ban-gia_ban*giam_gia/100 <= 5000000 AND gia_ban-gia_ban*giam_gia/100 >= 1000000 ";
       }
       else if (radioValue.equals("tu5den10trieu")) {
       	query +=" AND gia_ban-gia_ban*giam_gia/100 <= 10000000 AND gia_ban-gia_ban*giam_gia/100 >= 5000000 ";
       }
       else if (radioValue.equals("tren10trieu")) {
       	query +=" AND gia_ban-gia_ban*giam_gia/100 >= 10000000";
       }
	}
	 if (!(id_category.trim().equals("all"))) {
		 
			query +=" AND id_danh_muc = "+id_category.trim() ;
	 }
	 
	 List<SanPham> list=productdao.findBeginEndByQuerySearch(query,beginnum,3);
	System.out.println("Served at: " +query);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
