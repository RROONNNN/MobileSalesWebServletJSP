package Model;

public class DonHangGiaoDich {
	private String transactionId;
private String SDTKhachHang;
private String tenKhachHang;
private String DiaChiKhachHang;
private CartJsonOnlyIdRef cartJsonOnlyIdRef;
private String transactionStatus;// 00 thanh cong 22 that bai 11 chua xac nhan

public DonHangGiaoDich() {
	
}
public DonHangGiaoDich(String transactionId, String sDTKhachHang, String tenKhachHang, String diaChiKhachHang,
		CartJsonOnlyIdRef cartJsonOnlyIdRef ) {
	super();
	this.transactionId = transactionId;
	SDTKhachHang = sDTKhachHang;
	this.tenKhachHang = tenKhachHang;
	DiaChiKhachHang = diaChiKhachHang;
	this.cartJsonOnlyIdRef = cartJsonOnlyIdRef;
	this.transactionStatus = "11";
}
public String getTransactionId() {
	return transactionId;
}
public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}
public String getSDTKhachHang() {
	return SDTKhachHang;
}
public void setSDTKhachHang(String sDTKhachHang) {
	SDTKhachHang = sDTKhachHang;
}
public String getTenKhachHang() {
	return tenKhachHang;
}
public void setTenKhachHang(String tenKhachHang) {
	this.tenKhachHang = tenKhachHang;
}
public String getDiaChiKhachHang() {
	return DiaChiKhachHang;
}
public void setDiaChiKhachHang(String diaChiKhachHang) {
	DiaChiKhachHang = diaChiKhachHang;
}
public CartJsonOnlyIdRef getCartJsonOnlyIdRef() {
	return cartJsonOnlyIdRef;
}
public void setCartJsonOnlyIdRef(CartJsonOnlyIdRef cartJsonOnlyIdRef) {
	this.cartJsonOnlyIdRef = cartJsonOnlyIdRef;
}
public String getTransactionStatus() {
	return transactionStatus;
}
public void setTransactionStatus(String transactionStatus) {
	this.transactionStatus = transactionStatus;
}

}
