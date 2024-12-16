package Model;

import java.util.Objects;

public class SanPham {
private int id;

private DanhMuc danh_muc;
private String ten;
private float giam_gia;
private int so_thang_bao_hanh;
private int gia_ban;
private int so_luong_trong_kho;
private int gia_nhap;
private String hinh_anh;
private String mo_ta;
private int deleted=0;


public int getDeleted() {
	return deleted;
}
public void setDeleted(int deleted) {
	this.deleted = deleted;
}
@Override
public int hashCode() {
	return Objects.hash(id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	SanPham other = (SanPham) obj;
	return id == other.id;
}
public float getGiam_gia() {
	return giam_gia;
}

public void setGiam_gia(float giam_gia) {
	this.giam_gia = giam_gia;
}


public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public SanPham(int id, DanhMuc danh_muc,  String ten, float giam_gia, int so_thang_bao_hanh, int gia_ban,
		int so_luong_trong_kho, int gia_nhap, String hinh_anh, String mo_ta) {
	super();
	this.id = id;
	this.danh_muc = danh_muc;

	this.ten = ten;
	this.giam_gia = giam_gia;
	this.so_thang_bao_hanh = so_thang_bao_hanh;
	this.gia_ban = gia_ban;
	this.so_luong_trong_kho = so_luong_trong_kho;
	this.gia_nhap = gia_nhap;
	this.hinh_anh = hinh_anh;
	this.mo_ta = mo_ta;
	deleted=0;
}
public SanPham() {
	deleted=0;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public DanhMuc getDanh_muc() {
	return danh_muc;
}
public void setDanh_muc(DanhMuc danh_muc) {
	this.danh_muc = danh_muc;
}
public int getSo_thang_bao_hanh() {
	return so_thang_bao_hanh;
}
public void setSo_thang_bao_hanh(int so_thang_bao_hanh) {
	this.so_thang_bao_hanh = so_thang_bao_hanh;
}
public int getGia_ban() {
	return gia_ban;
}
public void setGia_ban(int gia_ban) {
	this.gia_ban = gia_ban;
}
public int getSo_luong_trong_kho() {
	return so_luong_trong_kho;
}
public void setSo_luong_trong_kho(int so_luong_trong_kho) {
	this.so_luong_trong_kho = so_luong_trong_kho;
}
public int getGia_nhap() {
	return gia_nhap;
}
public void setGia_nhap(int gia_nhap) {
	this.gia_nhap = gia_nhap;
}
public String getHinh_anh() {
	return hinh_anh;
}
public void setHinh_anh(String hinh_anh) {
	this.hinh_anh = hinh_anh;
}
public String getMo_ta() {
	return mo_ta;
}
public void setMo_ta(String mo_ta) {
	this.mo_ta = mo_ta;
}

}
