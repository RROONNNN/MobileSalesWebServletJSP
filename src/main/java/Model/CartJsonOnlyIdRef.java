package Model;

import java.awt.print.PrinterGraphics;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import DAO.SanPhamDAO;

public class CartJsonOnlyIdRef {
	private int soluong;
	private long TotalPrice;
	private List<Integer> dsIdSanPham;
	private List<Integer> numSanpham;
	
	public CartJsonOnlyIdRef() {
		dsIdSanPham=new ArrayList<Integer>();
		numSanpham=new ArrayList<Integer>();
	}

	public CartJsonOnlyIdRef(int soluong, long totalPrice) {
		super();
		dsIdSanPham=new ArrayList<Integer>();
		numSanpham=new ArrayList<Integer>();
		this.soluong = soluong;
		TotalPrice = totalPrice;

	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public long getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		TotalPrice = totalPrice;
	}

	public List<Integer> getDsIdSanPham() {
		return dsIdSanPham;
	}

	public void setDsIdSanPham(List<Integer> dsIdSanPham) {
		this.dsIdSanPham = dsIdSanPham;
	}

	public List<Integer> getNumSanpham() {
		return numSanpham;
	}

	public void setNumSanpham(List<Integer> numSanpham) {
		this.numSanpham = numSanpham;
	}
	public void addListIdByListProduct(List<SanPham> list) {
		
		list.forEach(it->{
			dsIdSanPham.add(it.getId());
		});
	}
	public void addListNumByListNum(List<Integer> list) {
		list.forEach(it->{
			numSanpham.add(it);
		});
	}
	public static void main(String[] args) {
		SanPhamDAO daosp=new SanPhamDAO();
	      Cart cart=new Cart();
	      cart.addSanPham(daosp.findById(1));
	      cart.addSanPham(daosp.findById(2));
	 
	      cart.addnumSanPham(2);
	 
	      cart.addnumSanPham(3);
	      
	      CartJsonOnlyIdRef cartJsonOnlyIdRef=new CartJsonOnlyIdRef();
	      cartJsonOnlyIdRef.addListIdByListProduct(cart.getDsSanPham());
	      cartJsonOnlyIdRef.addListNumByListNum(cart.getNumSanpham());
	      Gson gson=new Gson();
	  	String cartJson=gson.toJson(cartJsonOnlyIdRef);
	  	System.out.print(cartJson);
	      
	}
	
}
