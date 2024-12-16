package Model;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;

public class Cart {
private int soluong;
private long TotalPrice;
private List<SanPham> dsSanPham;
private List<Integer> numSanpham;
public Cart() {
	soluong=0;
	dsSanPham=new ArrayList<>();
	numSanpham=new ArrayList<Integer>();
	TotalPrice=0;
}
public List<Integer> getNumSanpham() {
	return numSanpham;
}
public void setNumSanpham(List<Integer> numSanpham) {
	this.numSanpham = numSanpham;
}
public long getTotalPrice() {
	return TotalPrice;
}
public void setTotalPrice(long totalPrice) {
	TotalPrice = totalPrice;
}
public Cart(int soluong, List<SanPham> dsSanPham) {
	super();
	this.soluong = soluong;
	this.dsSanPham = dsSanPham;
}

public int getSoluong() {
	return soluong;
}

public void setSoluong(int soluong) {
	this.soluong = soluong;
}

public List<SanPham> getDsSanPham() {
	return dsSanPham;
}

public void setDsSanPham(List<SanPham> dsSanPham) {
	this.dsSanPham = dsSanPham;
}
public void addSanPham(SanPham p) {
	if(dsSanPham.contains(p)) return;
	dsSanPham.add(p);
	soluong++;
	TotalPrice+=p.getGia_ban()-p.getGia_ban()*p.getGiam_gia()/100;
	System.out.println("aaaaaaa"+soluong);
	System.out.println(p.getTen());
}
public void addnumSanPham(int num) {
	numSanpham.add(num);
}
public void DeleteSanPham(int id) {
	System.out.println(dsSanPham.size());
	for(int i=0;i<dsSanPham.size();i++) {
		if (dsSanPham.get(i).getId()==id) {
		
			soluong--;
			TotalPrice-=dsSanPham.get(i).getGia_ban()-dsSanPham.get(i).getGia_ban()*dsSanPham.get(i).getGiam_gia()/100;
			dsSanPham.remove(i);
			return ;
		}
	}
}
}
