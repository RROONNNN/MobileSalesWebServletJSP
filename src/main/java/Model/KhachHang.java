package Model;

public class KhachHang {
private int id;
private String so_dien_thoai;
private String ten;
private String dia_chi;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSo_dien_thoai() {
	return so_dien_thoai;
}
public void setSo_dien_thoai(String so_dien_thoai) {
	this.so_dien_thoai = so_dien_thoai;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getDia_chi() {
	return dia_chi;
}
public void setDia_chi(String dia_chi) {
	this.dia_chi = dia_chi;
}
public KhachHang( String so_dien_thoai, String ten, String dia_chi) {
	super();

	this.so_dien_thoai = so_dien_thoai;
	this.ten = ten;
	this.dia_chi = dia_chi;
}

}
