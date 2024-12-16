package Model;

import java.sql.Date;

public class HoaDon {
private int id ;
private int id_nhan_vien;
private int id_khach_hang;
private long tong_tien_giao_dich;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getId_nhan_vien() {
	return id_nhan_vien;
}
public void setId_nhan_vien(int id_nhan_vien) {
	this.id_nhan_vien = id_nhan_vien;
}
public int getId_khach_hang() {
	return id_khach_hang;
}
public void setId_khach_hang(int id_khach_hang) {
	this.id_khach_hang = id_khach_hang;
}
public long getTong_tien_giao_dich() {
	return tong_tien_giao_dich;
}
public void setTong_tien_giao_dich(long tong_tien_giao_dich) {
	this.tong_tien_giao_dich = tong_tien_giao_dich;
}



public HoaDon(int id_nhan_vien, int id_khach_hang, long tong_tien_giao_dich) {
	super();

	this.id_nhan_vien = id_nhan_vien;
	this.id_khach_hang = id_khach_hang;
	this.tong_tien_giao_dich = tong_tien_giao_dich;

}
@Override
public String toString() {
	return "HoaDon [id=" + id + ", id_nhan_vien=" + id_nhan_vien + ", id_khach_hang=" + id_khach_hang
			+ ", tong_tien_giao_dich=" + tong_tien_giao_dich + "]";
}

}
