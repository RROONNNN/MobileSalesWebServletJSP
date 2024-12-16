package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection2.DBContext;
import Model.KhachHang;

public class KhachHangDAO {
	private Connection connection=null;
	public KhachHangDAO() {
		connection=new DBContext().getConnection();
	}
	public int findIdBySDT(String sdt ) {
		String query="select id from KhachHang where so_dien_thoai="+sdt;
		 PreparedStatement ps=null;
		 try {
				ps=connection.prepareStatement(query);
				 ResultSet rs = ps.executeQuery();
				  if (rs.next()) {
			         int id_khachhang = rs.getInt(1);
			    
			      return id_khachhang;
			     }
		 }
		 catch (SQLException e) {
		
		}
		 return 0;
	}
	public int InsertKhachHang(KhachHang khachHang)  {//tra ve id khach hang moi them
		String query="INSERT INTO KhachHang (so_dien_thoai,ten,dia_chi) VALUES (?,?,?); ";
		 
			 PreparedStatement ps=null;
				try {
					ps=connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
					ps.setString(1, khachHang.getSo_dien_thoai());
					ps.setString(2, khachHang.getTen());
					ps.setString(3, khachHang.getDia_chi());
					    ps.executeUpdate();
					     
					     ResultSet rs = ps.getGeneratedKeys();
					     if (rs.next()) {
					         int idkhachhang = rs.getInt(1);
					         System.out.println("Generated ID Khach Hang: " + idkhachhang);
					         return idkhachhang;
					     }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		 
		
			return 0;
	}
	public static void main(String[] args) {
		KhachHangDAO dao=new KhachHangDAO();
		System.out.println("id: "+dao.findIdBySDT("0111111111"));
		KhachHang khachHang=new KhachHang("8888888888","Nguyen Ron","Kim Long Em Oi");
		
			dao.InsertKhachHang(khachHang);
	
		System.out.println("id: "+dao.findIdBySDT("8888888888"));
	}
	
}
