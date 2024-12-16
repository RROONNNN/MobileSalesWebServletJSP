package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection2.DBContext;
import Model.DanhMuc;


public class DanhMucDAO {
	private Connection connection=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public DanhMucDAO() {
		connection=new DBContext().getConnection();
	}
	public List<DanhMuc> findAll() {
		String query="select * from danhmuc";
		try {
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<DanhMuc> list=new ArrayList<DanhMuc>();
		try {
			while(rs.next()) {
				//if (rs.getInt(3)==1) continue;
				DanhMuc e=new DanhMuc(rs.getInt(1), rs.getString(2));
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.get(2).getId());
		return list;
	}
	
	public static void main(String[] args) {
		DanhMucDAO dao=new DanhMucDAO();
		List<DanhMuc> list=dao.findAll();
		list.forEach(it->{
			System.out.println(it.getTen_danh_muc());
		});
	}
}
