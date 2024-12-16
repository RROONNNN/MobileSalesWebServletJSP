<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@page import="Model.Cart" %>  
              <%@page import="Model.DanhMuc"%>      
     <%@page import="Model.SanPham" %>  
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
            <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
               <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
               
               <style type="text/css">
               @media (min-width: 1025px) {
.h-custom {
height: 100vh !important;
}
}
               .number-input input[type="number"] {
-webkit-appearance: textfield;
-moz-appearance: textfield;
appearance: textfield;
}

.number-input input[type=number]::-webkit-inner-spin-button,
.number-input input[type=number]::-webkit-outer-spin-button {
-webkit-appearance: none;
}

.number-input {
  display: flex;
  justify-content: space-around;
  align-items: left;
}

.number-input button {
-webkit-appearance: none;
background-color: transparent;
border: none;
align-items: center;
justify-content: center;
cursor: pointer;
margin: 10px 0;
position: relative;
}

.number-input button:before,
.number-input button:after {
display: inline-block;
position: absolute;
content: '';
height: 2px;
transform: translate(-50%, -50%);
}

.number-input button.plus:after {
transform: translate(-50%, -50%) rotate(90deg);
}

.number-input input[type=number] {
text-align: center;
}

.number-input.number-input {
border: 1px solid #ddd;
width: 9rem;
border-radius: .25rem;
}

.number-input.number-input button {
width: 2rem;
height: .7rem;
}

.number-input.number-input button.minus {
padding-left: 10px;
}

.number-input.number-input button:before,
.number-input.number-input button:after {
width: .9rem;
background-color: #495057;
}

.number-input.number-input input[type=number] {
max-width: 3rem;
padding: .5rem;
border: 1px solid #ddd;
border-width: 0 1px;
font-size: 1rem;
height: 1rem;
color: #495057;
}

@media not all and (min-resolution:.001dpcm) {
@supports (-webkit-appearance: none) and (stroke-color:transparent) {

.number-input.b575-number-input.safari_only button:before,
.number-input.b575-number-input.safari_only button:after {
margin-top: -.2rem;
}
}
}
.height-100 {
    height: 100vh
}

.cardotp {
    width: 400px;
    border: none;
    height: 300px;
    box-shadow: 0px 5px 20px 0px #d2dae3;
    z-index: 1;
    display: flex;
    justify-content: center;
    align-items: center
}

.cardotp h6 {
    color: red;
    font-size: 20px
}

.inputs input {
    width: 40px;
    height: 40px
}

input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    margin: 0
}

.card-2 {
    background-color: #fff;
    padding: 10px;
    width: 350px;
    height: 100px;
    bottom: -50px;
    left: 20px;
    position: absolute;
    border-radius: 5px
}

.card-2 .content {
    margin-top: 50px
}

.card-2 .content a {
    color: red
}

.form-control:focus {
    box-shadow: none;
    border: 2px solid red
}

.validate {
    border-radius: 20px;
    height: 40px;
    background-color: red;
    border: 1px solid red;
    width: 140px
}
</style>
</head>

<body>
<%Cart cartInstance=(Cart)session.getAttribute("Cart"); 
%>
<section class="h-100 h-custom" style="background-color: #eee;">
   <form action="ThanhToanButtonController" method="GET">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card">
          <div class="card-body p-4">

            <div class="row">

              <div class="col-lg-7">
                <h5 class="mb-3"><a href="Shop" class="text-body"><i
                      class="fas fa-long-arrow-alt-left me-2"></i>Tiếp tục mua sắm</a></h5>
                <hr>

                <div class="d-flex justify-content-between align-items-center mb-4">
                  <div>
                    <p class="mb-1">Giỏ hàng</p>
                    <p class="mb-0">Bạn hiện tại có <%=cartInstance.getSoluong()%> sản phẩm trong giỏ hàng</p>
                  </div>
                  <div>
                    <p class="mb-0"><span class="text-muted">Sắp xếp theo:</span> <a href="#!"
                        class="text-body"> giá thành<i class="fas fa-angle-down mt-1"></i></a></p>
                  </div>
                </div>
               
                
                <div id="ProductContainerInCart">      
<%
List<SanPham> list=cartInstance.getDsSanPham();
for (int i=0;i<list.size();i++){
	int price=(int)(list.get(i).getGia_ban()-list.get(i).getGia_ban()*list.get(i).getGiam_gia()/100);
%>
                <div class="card mb-3" name="<%=list.get(i).getId()%>">
                  <div class="card-body">
                    <div class="d-flex justify-content-between">
                      <div class="d-flex flex-row align-items-center">
                        <div>
                          <img
                            src="<%=list.get(i).getHinh_anh()%>"
                            class="img-fluid rounded-3" alt="Shopping item" style="width: 65px;">
                        </div>
                        <div class="ms-3">
                        
                          <h5><%=list.get(i).getTen()%></h5>
                          <p class="small mb-0"></p>
                        </div>
                      </div>


                      <div class="d-flex  flex-row align-items-center">
                     
              <div class="b575-number-input number-input safari_only">
  <button  onclick="this.parentNode.querySelector('input[type=number]').stepDown(); updatePriceMinus('<%=price%>');event.preventDefault();" class="minus">
  
  </button>
  <input class="quantity h-100" min="0" name="quantities" id="myInput<%=list.get(i).getId()%>" value="1" type="number">

  <button onclick="this.parentNode.querySelector('input[type=number]').stepUp();updatePricePlus('<%=price%>');event.preventDefault();" class="plus"></button>
</div>


                  <p>     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <div style="display: flex;flex-wrap: wrap;"  >
                      

                        
                          <h5 class="mb-0"><%=price%></h5>
                        </div >
                                 <p>     &nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <a href="/FirstProjectServlet/DeleteItemInCart?PidDelete=<%=list.get(i).getId()%>" style="color:red;"><i class="fas fa-trash-alt"></i></a>
                        
                      </div>
                    </div>
                  </div>
                  
                </div>
<%} %>


   </div>
   
              </div>
              
              <div class="col-lg-5">

                <div class="card bg-primary text-white rounded-3">
                  <div class="card-body">
                    <div class="d-flex justify-content-between align-items-center mb-4">
                      <h5 class="mb-0">Thông tin đơn hàng</h5>
                      <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp"
                        class="img-fluid rounded-3" style="width: 45px;" alt="Avatar">
                    </div>

                    <p class="small mb-2">Loại ngân hàng</p>
                    <a href="#!" type="submit" class="text-white"><i
                        class="fab fa-cc-mastercard fa-2x me-2"></i></a>
                    <a href="#!" type="submit" class="text-white"><i
                        class="fab fa-cc-visa fa-2x me-2"></i></a>
                    <a href="#!" type="submit" class="text-white"><i	
                        class="fab fa-cc-amex fa-2x me-2"></i></a>
                    <a href="#!" type="submit" class="text-white"><i class="fab fa-cc-paypal fa-2x"></i></a>
                   <a href="#!" type="submit" class="text-white" >
    <img src="assets/Untitled.png" style="border-radius: 5px; margin-bottom: 15px; margin-left: 4px;" alt="Image" width="36" height="32">
</a>

                    <div class="mt-4" >
                          <div data-mdb-input-init class="form-outline form-white mb-4">
                        <input type="text" name="tenKhachHang"  id="tenKhachHang" class="form-control form-control-lg" size="50"
                          placeholder="Tên" />
                        <label class="form-label" for="tenKhachHang">Tên</label>
                      </div>
                      <div data-mdb-input-init class="form-outline form-white mb-4">
                        <input type="text" name="DiaChiKhachHang"  id="DiaChiKhachHang" class="form-control form-control-lg" size="50"
                          placeholder="Địa chỉ" />
                        <label class="form-label" for="DiaChiKhachHang">Địa chỉ</label>
                      </div>

                      <div data-mdb-input-init class="form-outline form-white mb-4">
                        <input type="text" name="SDTKhachHang" id="SDTKhachHang" class="form-control form-control-lg" size="17"
                          placeholder="Số điện thoại" minlength="10" maxlength="11" />
                        <label class="form-label" for="SDTKhachHang">Số điện thoại</label><br>
                        <span class="text-danger" id="phoneError"></span>
                      </div>
    <button class="  btn btn-secondary" data-bs-toggle="collapse" onclick=" event.preventDefault(); PrepareExcOTP()"  href="#collapseExample" id="startButton" role="button" aria-expanded="false" aria-controls="collapseExample">
  Gửi mã OTP
  </button>
  <div class="collapse card bg-primary text-white" id="collapseExample">
  <div class="card card-body">
    <div id="countdownDisplay" style="color: red"></div>
<div class="container d-flex justify-content-center align-items-center">
    <div class="position-relative">
        <div class="card p-2 text-center">
            <h6>Nhập mã OTP <br> để xác thực số điện thoại của bạn</h6>
            <div> <span>Mã đã được gửi đến</span> <small id="smallphonenum"></small> </div>
             <div id="otp" class="inputs d-flex flex-row justify-content-center mt-2"> <input
          class="m-2 text-center form-control rounded" type="text" id="first" maxlength="1" /> <input
          class="m-2 text-center form-control rounded" type="text" id="second" maxlength="1" /> <input
          class="m-2 text-center form-control rounded" type="text" id="third" maxlength="1" /> <input
          class="m-2 text-center form-control rounded" type="text" id="fourth" maxlength="1" /> <input
          class="m-2 text-center form-control rounded" type="text" id="fifth" maxlength="1" /> <input
          class="m-2 text-center form-control rounded" type="text" id="sixth" maxlength="1" /> </div>
            <div class="mt-4"> <button id="CheckOTPButton" onclick="checkOTP(); event.preventDefault();" class="btn bg-primary px-4 validate">Kiểm tra</button> </div>
        </div>
    </div>
</div>
    
      <input type="hidden" id="OTPCode"  value="######" />
      <div class="collapse text-center " id="CollapseOTPState" >  
                    <span id="spanStateOTP" class=""></span>  
                   </div>
  
  </div>
                   
                   
                    </div>

                    <hr class="my-4">

                    <div class="d-flex justify-content-between">
                      <p class="mb-2">Subtotal</p>
                      <p class="mb-2" id="Subtotal"><%=cartInstance.getTotalPrice()%></p>
                    </div>
                      <div class="d-flex justify-content-between">
                      <p class="mb-2">Thuế VAT</p>
                      <p class="mb-2">8%</p>
                    </div>

                    <div class="d-flex justify-content-between">
                      <p class="mb-2">Phí ship</p>
                      <p class="mb-2">30000</p>
                    </div>

                    <div class="d-flex justify-content-between mb-4">
                      <p class="mb-2">Tổng</p>
                      <p class="mb-2" id="Total"><%=(long)(cartInstance.getTotalPrice()*1.08+30000)%></p>
                    </div>
                    
                    
                    <input type="hidden" id="totalPrice" name="totalPrice" value="10000" />
                    <button id="Thanhtoanbutton" type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-info btn-block btn-lg" onclick="ThanhToanButtonFunc(<%=cartInstance.getSoluong()%>)">
                      <div class="d-flex justify-content-between">
                        <span> Thanh toán <i class="fas fa-long-arrow-alt-right ms-2"></i></span>
                      </div>
                    </button>

                  </div>
                </div>

              </div>

            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
  
  </form>
</section>

<script type="text/javascript">

document.addEventListener("DOMContentLoaded", function(event) {

	function OTPInput() {
	const inputs = document.querySelectorAll('#otp > *[id]');
	for (let i = 0; i < inputs.length; i++) { 
		inputs[i].addEventListener('keydown', function(event) { 
			if (event.key==="Backspace" ) 
			{ inputs[i].value='' ; 
			if (i !==0) inputs[i - 1].focus(); }
			else { 
				if (i===inputs.length - 1 && inputs[i].value !=='' ) { return true; } 
				else if (event.keyCode> 47 && event.keyCode < 58) 
				{ inputs[i].value=event.key; 
				if (i !==inputs.length - 1) inputs[i + 1].focus(); event.preventDefault(); } 
				else if (event.keyCode> 64 && event.keyCode < 91) { inputs[i].value=String.fromCharCode(event.keyCode); 
				if (i !==inputs.length - 1) inputs[i + 1].focus(); event.preventDefault(); } } }); } } OTPInput(); });

function sendOTPCode(){
 	 $.ajax({
          url: "SMSController",
          type: "POST", //send it through get method
          data: {
      	    phonenumber: document.getElementById('SDTKhachHang').value,
       

         },
          success: function (responseData) {
     
         	 document.getElementById("OTPCode").value = responseData;          
         	 
          }
      });
 }  
 
function PrepareExcOTP(){
	//gui otp den sdt do
		sendOTPCode();
	//them sdt da nhap vao form otp
	document.getElementById('smallphonenum').innerHTML=document.getElementById('SDTKhachHang').value
	//
}
var phoneInput=document.getElementById('SDTKhachHang');
const phoneErrorSpan = document.getElementById('phoneError');
phoneInput.addEventListener('blur', validatePhoneNumber);
function validatePhoneNumber() {
    const phoneNumber = phoneInput.value.trim();
    const phoneRegex = /^\d+$/;
    if (phoneRegex.test(phoneNumber)) {
      phoneErrorSpan.textContent = '';
    } else {
      phoneErrorSpan.textContent = 'Số điện thoại không hợp lệ. Xin vui lòng nhập một số điện thoại hợp lệ.';
    }
  }

var button =document.getElementById("Thanhtoanbutton");

button.setAttribute("disabled","disabled");

var CheckOTPButton=document.getElementById('CheckOTPButton') ;
const startButton = document.getElementById('startButton');

const countdownDisplay = document.getElementById('countdownDisplay');
startButton.addEventListener('click', startCountdown);
// Initialize the countdown time (in seconds)
var countdownTime = 60;

// Function to update the countdown display
function updateCountdown() {
  countdownDisplay.innerHTML ='Còn thời hạn: '+ countdownTime;
}

// Function to start the countdown
function startCountdown() {
	CheckOTPButton.removeAttribute("disabled");
  // Disable the start button
  startButton.disabled = true;

  // Update the countdown every second
  const countdownInterval = setInterval(() => {
    countdownTime--;

    updateCountdown();

    // Stop the countdown when it reaches 0
    if (countdownTime === 0) {
    	//gan checknum =1 so dai hon 6 so
    	document.getElementById('OTPCode').value='######';
    	CheckOTPButton.setAttribute("disabled","disabled");
    	countdownTime = 60;
      clearInterval(countdownInterval);
      countdownDisplay.textContent = 'Countdown finished!';
      startButton.disabled = false;
    }
  }, 1000);
}

// Add a click event listener to the start button

function checkOTP(){
	var num1=document.getElementById('first').value;
	var num2=document.getElementById('second').value;
	var num3=document.getElementById('third').value;
	var num4=document.getElementById('fourth').value;
	var num5=document.getElementById('fifth').value;
	var num6=document.getElementById('sixth').value;
	var OTP=document.getElementById('OTPCode').value;
	var clientOTP=num1+num2+num3+num4+num5+num6;
	var colapseState=document.getElementById('CollapseOTPState');
	var spancolapseState=document.getElementById('spanStateOTP');
	if (OTP===clientOTP) {
		//CollapseOTPState spanStateOTP

		if (!colapseState.classList.contains('show'))
		colapseState.classList.add('show');
		
		if (!spancolapseState.classList.contains('text-success'))
		spancolapseState.classList.add('text-success');
			if (spancolapseState.classList.contains('text-danger'))
		spancolapseState.classList.remove('text-danger');
		spancolapseState.innerHTML='Thành Công';
		button.removeAttribute("disabled");

	}
	else
	{
		if (!colapseState.classList.contains('show'))
			colapseState.classList.add('show');
		if (spancolapseState.classList.contains('text-success'))
			spancolapseState.classList.remove('text-success');
				if (!spancolapseState.classList.contains('text-danger'))
			spancolapseState.classList.add('text-danger');
			spancolapseState.innerHTML='Thất bại';
	}
}
function ThanhToanButtonFunc(numProductinCart){
	document.getElementById('totalPrice').value=document.getElementById('Total').innerHTML;
	  parentElement =	document.getElementById("ProductContainerInCart");
	  const childElements = parentElement.children;
	  for (let i = 0; i < childElements.length; i++) {
	  console.log(childElements[i].getAttribute('name')); // Output the tag name of each child element
	  
	}
	}
	
  function updatePricePlus( price) {
	
  var SubTotalPrice=parseInt(document.getElementById("Subtotal").innerHTML);
  var TotalPrice=parseInt(document.getElementById("Total").innerHTML);
  document.getElementById("Subtotal").innerHTML=SubTotalPrice+parseInt(price);
  document.getElementById("Total").innerHTML=  TotalPrice+parseInt(price);
  
  }
  function updatePriceMinus(price){
	  var SubTotalPrice=parseInt(document.getElementById("Subtotal").innerHTML);
	  var TotalPrice=parseInt(document.getElementById("Total").innerHTML);
	  document.getElementById("Subtotal").innerHTML=SubTotalPrice-parseInt(price);
	  document.getElementById("Total").innerHTML=  TotalPrice-parseInt(price);
  }
  
  </script>

                 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
                 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
                         <script src="js/scripts.js"></script>
                       
        <script src="test.js"></script>
</body>
</html>