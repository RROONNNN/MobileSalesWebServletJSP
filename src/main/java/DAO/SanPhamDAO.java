
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import Connection2.DBContext;
import Model.DanhMuc;
import Model.SanPham;
public class SanPhamDAO {
	private Connection connection=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
/*	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ProductDAO dao=new ProductDAO();
		SanPham product=dao.getProductById(5);
		System.out.print(product.getName());
	}*/
	public SanPhamDAO() {
		
		connection=new DBContext().getConnection();
		
	}

	public List<SanPham> findAll(){
		String query="select * from sanpham ";
		try {
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<SanPham> list=new ArrayList<>();
		try {
			while(rs.next()) {
				
				String query2="select * from danhmuc where id= ?";
				
				ps=connection.prepareStatement(query2);
		
				ps.setInt(1, rs.getInt(2));
				
				ResultSet rs2=ps.executeQuery();
		
				System.out.print("OK!!");
				DanhMuc dm=null;
				if (rs2.next())
					dm=new DanhMuc(rs2.getInt(1),rs2.getString(2));
				SanPham e=new SanPham(rs.getInt(1),dm ,rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10));
				if (rs.getInt(11)==1) e.setDeleted(1);
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SanPham> findAllBeginEnd(int begin,int num){
		String query="SELECT * FROM sanpham  ORDER BY id LIMIT ? OFFSET ?";
		try {
			System.out.println("findAllBeginEnd: "+query);
			ps=connection.prepareStatement(query);
			ps.setInt(1, num);
			ps.setInt(2, begin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SanPham> list=new ArrayList<>();
		try {
			while(rs.next()) {
			//	if (rs.getInt(11)==1) continue;
String query2="select * from danhmuc where id= ?";
				
				ps=connection.prepareStatement(query2);
		
				ps.setInt(1, rs.getInt(2));
				
				ResultSet rs2=ps.executeQuery();
		
				System.out.print("OK!!");
				DanhMuc dm=null;
				if (rs2.next())
					dm=new DanhMuc(rs2.getInt(1),rs2.getString(2));
				SanPham e=new SanPham(rs.getInt(1),dm ,rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10));
				if (rs.getInt(11)==1) e.setDeleted(1);
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SanPham> findAllByIdDm(int idt){
		String query="select * from sanpham where id_danh_muc=? ";
		try {
			ps=connection.prepareStatement(query);
	ps.setInt(1, idt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SanPham> list=new ArrayList<>();
		try {
			while(rs.next()) {
			//	if (rs.getInt(11)==1) continue;
				String query2="select * from danhmuc where id= ?";
				
				ps=connection.prepareStatement(query2);
		
				ps.setInt(1, rs.getInt(2));
				
				ResultSet rs2=ps.executeQuery();
		
				System.out.print("OK!!");
				DanhMuc dm=null;
				if (rs2.next())
					dm=new DanhMuc(rs2.getInt(1),rs2.getString(2));
				SanPham e=new SanPham(rs.getInt(1),dm ,rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10));
				if (rs.getInt(11)==1) e.setDeleted(1);
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public SanPham findById(int id) {
		String query="select * from sanpham where id=? ";
		try {
			ps=connection.prepareStatement(query);
	ps.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SanPham e=new SanPham();
		try {
			while(rs.next()) {
				//if (rs.getInt(11)==1) continue;
				String query2="select * from danhmuc where id=?";
				ps=connection.prepareStatement(query2);
				ps.setInt(1, rs.getInt(2));
				ResultSet rs2=ps.executeQuery();
				DanhMuc dm=null;
				if (rs2.next())
					dm=new DanhMuc(rs2.getInt(1),rs2.getString(2));
				 e=new SanPham(rs.getInt(1),dm ,rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10));
					if (rs.getInt(11)==1) e.setDeleted(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
			return e;
	}
	
	public List<SanPham> SearchQuery(String condition){
		String query="select * from sanpham where  "+condition;
		try {
			ps=connection.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SanPham> list=new ArrayList<>();
		try {
			while(rs.next()) {
				//if (rs.getInt(11)==1) continue;
				String query2="select * from danhmuc where id= ?";
				
				ps=connection.prepareStatement(query2);
		
				ps.setInt(1, rs.getInt(2));
				
				ResultSet rs2=ps.executeQuery();
		
				System.out.print("OK!!");
				DanhMuc dm=null;
				if (rs2.next())
					dm=new DanhMuc(rs2.getInt(1),rs2.getString(2));
				SanPham e=new SanPham(rs.getInt(1),dm ,rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10));
				if (rs.getInt(11)==1) e.setDeleted(1);
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public List<SanPham> findBeginEndByIdDM(int idDM,int begin,int num){
		String query="select * from sanpham where id_danh_muc=? "+" LIMIT ? OFFSET ? ";
		try {
			ps=connection.prepareStatement(query);
			ps.setInt(1, idDM);
			ps.setInt(2, num);
			ps.setInt(3, begin);
			System.out.print("OK!!"+idDM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<SanPham> list=new ArrayList<>();
		try {
			rs=ps.executeQuery();
			while(rs.next()) {
				
				String query2="select * from danhmuc where id= ?";
				
				ps=connection.prepareStatement(query2);
		
				ps.setInt(1, rs.getInt(2));
				
				ResultSet rs2=ps.executeQuery();
		
				System.out.print("OK!!");
				DanhMuc dm=null;
				if (rs2.next())
					dm=new DanhMuc(rs2.getInt(1),rs2.getString(2));
				SanPham e=new SanPham(rs.getInt(1),dm ,rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10));
				if (rs.getInt(11)==1) e.setDeleted(1);
				list.add(e);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	public List<SanPham> findBeginEndByQuerySearch(String condition,int begin,int num) {
		
		String query="select * from sanpham where "+condition + " LIMIT ? OFFSET ? ";
		try {
			ps=connection.prepareStatement(query);
			ps.setInt(1, num);
			ps.setInt(2, begin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SanPham> list=new ArrayList<>();
		try {
			while(rs.next()) {
				//if (rs.getInt(11)==1) continue;
				String query2="select * from danhmuc where id= ?";
				
				ps=connection.prepareStatement(query2);
		
				ps.setInt(1, rs.getInt(2));
				
				ResultSet rs2=ps.executeQuery();
		
				System.out.print("OK!!");
				DanhMuc dm=null;
				if (rs2.next())
					dm=new DanhMuc(rs2.getInt(1),rs2.getString(2));
				SanPham e=new SanPham(rs.getInt(1),dm ,rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10));
				if (rs.getInt(11)==1) e.setDeleted(1);
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void Giam_SoLuongTrongKho_transaction(String id,int num) {
String query="UPDATE Sanpham SET so_luong_trong_kho = so_luong_trong_kho - "+num+ " WHERE id ="+id;
try {
	java.sql.Statement  statement= connection.createStatement();
connection.setAutoCommit(false);
int numm= statement.executeUpdate(query);
if (numm>0) connection.commit();
else connection.rollback();
connection.setAutoCommit(true);

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	public static void main(String[] args) {
		SanPhamDAO dao=new SanPhamDAO();

	}
			
}