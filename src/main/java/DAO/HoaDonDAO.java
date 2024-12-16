package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import Connection2.DBContext;
import Model.Cart;
import Model.CartJsonOnlyIdRef;
import Model.HoaDon;
import Model.KhachHang;
import Model.SanPham;

public class HoaDonDAO {
	private Connection connection=null;

	public HoaDonDAO() {
		connection=new DBContext().getConnection();
	}
public void Excute_Transaction(HoaDon hoadon,KhachHang khachhang,CartJsonOnlyIdRef cartinstance)  {

	KhachHangDAO khachHangDAO=new KhachHangDAO();
	 PreparedStatement ps=null;
	 PreparedStatement ps1=null;
	 String query="INSERT INTO `hoadon` ( `id_nhan_vien`, `id_khach_hang`, `tong_tien_giao_dich`, `phuong_thuc_thanh_toan`, `hinh_thuc_thanh_toan`) VALUES (?, ?, ?,  'chuyển khoản', 'online');";

	 List<String> listquerySp=new ArrayList<String>();
	List<Integer> list_sanPhams=cartinstance.getDsIdSanPham();
List<Integer> list_num=cartinstance.getNumSanpham();
for(int i=0;i<list_sanPhams.size();i++) {
	String qString="UPDATE Sanpham SET so_luong_trong_kho = so_luong_trong_kho - "+list_num.get(i) + " WHERE id ="+list_sanPhams.get(i);
	listquerySp.add(qString);
}		
	try {
		java.sql.Statement  statement= connection.createStatement();
	
		ps=connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
	
		ps.setInt(1, hoadon.getId_nhan_vien());
		ps.setInt(2, hoadon.getId_khach_hang());
		ps.setLong(3, hoadon.getTong_tien_giao_dich());

		connection.setAutoCommit(false);
		
		for (int j=0;j<listquerySp.size();j++) {
			statement.executeUpdate(listquerySp.get(j));
		}
	Integer idhoadon=null;
     ps.executeUpdate();
     ResultSet rs = ps.getGeneratedKeys();
     if (rs.next()) {
          idhoadon = rs.getInt(1);
         System.out.println("Generated ID: " + idhoadon);
     }
     if (idhoadon!=null)
     for (int j=0;j<listquerySp.size();j++) {
    		String query1="INSERT INTO `sanpham_hoadon` (`id_san_pham`, `id_hoa_don`, `so_luong`) VALUES (?, ?, ?);";
    		ps1=connection.prepareStatement(query1);
			  ps1.setInt(1,list_sanPhams.get(j) );
			  ps1.setInt(2, idhoadon);
			  ps1.setInt(3, list_num.get(j));  
			  ps1.executeUpdate();
		}
			connection.commit();
			   System.out.println("Transaction completed successfully!");
	
	} catch (SQLException e) {
		try {
			connection.rollback();
			connection.setAutoCommit(true);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		    System.out.println("Transaction failed: " + e.getMessage());
	
	}
	finally {
	    // Close the resources
	    try {
			ps.close();
			ps1.close();
	
		    connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
public static void main(String[] args) {
	HoaDonDAO dao=new HoaDonDAO();
	SanPhamDAO daosp=new SanPhamDAO();
      Cart cart=new Cart();
      cart.addSanPham(daosp.findById(1));
      cart.addSanPham(daosp.findById(2));
      cart.addnumSanPham(2);
      cart.addnumSanPham(3);
      HoaDon hoaDon=new HoaDon(99, 1, 9999999 );
   //   dao.Excute_Transaction(hoaDon);
}
}
