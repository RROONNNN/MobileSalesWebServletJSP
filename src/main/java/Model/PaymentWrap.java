package Model;

public class PaymentWrap {
private Long gvnp_Amount;
private String	vnp_TransactionStatus;//00 thanh cong
private String	vnp_BankCode;
private String		vnp_ResponseCode;//00 thanh cong
private String	vnp_PayDate;//Thời gian thanh toán. Định dạng: yyyyMMddHHmmss
private String		vnp_CardType; //Loại tài khoản/thẻ khách hàng sử dụng:ATM,QRCODE
public PaymentWrap() {
	// TODO Auto-generated constructor stub
}
public Long getGvnp_Amount() {
	return gvnp_Amount;
}
public void setGvnp_Amount(Long gvnp_Amount) {
	this.gvnp_Amount = gvnp_Amount;
}
public String getVnp_TransactionStatus() {
	return vnp_TransactionStatus;
}
public void setVnp_TransactionStatus(String vnp_TransactionStatus) {
	this.vnp_TransactionStatus = vnp_TransactionStatus;
}
public String getVnp_BankCode() {
	return vnp_BankCode;
}
public void setVnp_BankCode(String vnp_BankCode) {
	this.vnp_BankCode = vnp_BankCode;
}
public String getVnp_ResponseCode() {
	return vnp_ResponseCode;
}
public void setVnp_ResponseCode(String vnp_ResponseCode) {
	this.vnp_ResponseCode = vnp_ResponseCode;
}
public String getVnp_PayDate() {
	return vnp_PayDate;
}
public void setVnp_PayDate(String vnp_PayDate) {
	this.vnp_PayDate = vnp_PayDate;
}
public String getVnp_CardType() {
	return vnp_CardType;
}
public void setVnp_CardType(String vnp_CardType) {
	this.vnp_CardType = vnp_CardType;
}
public PaymentWrap(Long gvnp_Amount, String vnp_TransactionStatus, String vnp_BankCode, String vnp_ResponseCode,
		String vnp_PayDate, String vnp_CardType) {
	super();
	this.gvnp_Amount = gvnp_Amount;
	this.vnp_TransactionStatus = vnp_TransactionStatus;
	this.vnp_BankCode = vnp_BankCode;
	this.vnp_ResponseCode = vnp_ResponseCode;
	this.vnp_PayDate = vnp_PayDate;
	this.vnp_CardType = vnp_CardType;
}

}
