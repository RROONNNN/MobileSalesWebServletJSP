<%@page import="Config.ConfigOfWeb"%>
<%@page import="javax.swing.text.html.StyleSheet.ListPainter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="DAO.DanhMucDAO"%>
     <%@page import="DAO.SanPhamDAO"%>
    <%@page import="Model.DanhMuc" %>      
     <%@page import="Model.SanPham" %>  
      <%@page import="Model.Cart" %>  
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>HBT Store</title>
        <!-- Favicon-->
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="css\CollectionStyle.css" />
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
            <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
               <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
               <style type="text/css">
               
               
               @import url("https://fonts.googleapis.com/css2?family=Poppins:weight@100;200;300;400;500;600;700;800&display=swap");
       body{
        background-color:#eee;
        font-family: "Poppins", sans-serif;
        font-weight: 300;
       }

       .height{
        height: 100vh;
       }
       
    
       .search{
       position: relative;
       box-shadow: 0 0 40px rgba(51, 51, 51, .1);
         
       }

       .search input{

        height: 60px;
        text-indent: 25px;
        border: 2px solid #d6d4d4;


       }


       .search input:focus{

        box-shadow: none;
        border: 2px solid blue;


       }

       .search .fa-search{

        position: absolute;
        top: 20px;
        left: 16px;

       }

       .search button{

        position: absolute;
        top: 5px;
        right: 5px;
        height: 50px;
        width: 80px;
        background: #153448;
color: white;
       }</style>
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="<%=ConfigOfWeb.HomePageLink%>"> <img src="images/main-logo.png" class="logo"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="<%=ConfigOfWeb.HomePageLink%>">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="https://www.youtube.com/">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="Shop">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>               
 <%	
       List<DanhMuc> listPT=(List<DanhMuc>)request.getAttribute("listPT");  
   Cart cartInstance=(Cart)session.getAttribute("Cart");
	// System.out.print("dit me may + "+cartInstance.getQuantity());
 
for(int i=0;i<listPT.size();i++)
{ 
%>
     <li><a class="dropdown-item" href="Category?Cid=<%=listPT.get(i).getId()%>"><%=listPT.get(i).getTen_danh_muc()%></a></li>
     <%} %>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <a id="buttonchangenum" class="btn btn-outline-dark" type="submit" href="CartPage.jsp" >
                            <i class="bi-cart-fill me-1"></i>
                        Giỏ hàng
                            <span class="badge bg-dark text-whitfe ms-1 rounded-pill"><%=cartInstance.getSoluong()%></span>
                         </a>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Header-->
 
        <!-- Section-->
        <div class="container-fluid">
        <div class="row flex-nowrap">
        <div class="col-auto col-md-3 col-lg-4 px-sm-2 px-0 " style="background: #EAE4E4">
        
        <div class="container flex-column justify-content-start mt-3">

                      <div class="col-md-10">
                        <div class="search">
                          <i class="fa fa-search"></i>
                     
                            <input id="searchbox" type="text" name="searchbox" class="form-control" placeholder="Sản phẩm bạn muốn tìm kiếm">
                        </div>
                      
                    </div>
             <div class="form-check my-3">
  <input class="form-check-input" type="radio" name="filterprice" id="allprice" value="allprice">
  <label class="form-check-label" for="allprice">
  Tất cả
  </label>
</div>    
   <div class="form-check my-3">
  <input class="form-check-input" type="radio" name="filterprice" id="duoi1trieu" value="duoi1trieu">
  <label class="form-check-label" for="duoi1trieu">
  Dưới 1 triệu đồng
  </label>
</div>
<div class="form-check my-3">
  <input class="form-check-input" type="radio" name="filterprice" id="tu1trieuden5" value="tu1trieuden5" >
  <label class="form-check-label" for="tu1trieuden5">
    Từ 1 triệu đến 5 triệu đồng
  </label>
</div>
<div class="form-check my-3">
  <input class="form-check-input" type="radio" name="filterprice" id=tu5den10trieu value="tu5den10trieu"  >
  <label class="form-check-label" for="tu5den10trieu">
    Từ 5 triệu đến 10 triệu đồng
  </label>
</div>
<div class="form-check my-3">
  <input class="form-check-input" type="radio" name="filterprice" id=tren10trieu  value="tren10trieu" >
  <label class="form-check-label" for="tren10trieu"  >
   Trên 10 triệu đồng
  </label>
</div>

 <div class="container d-flex  mt-3 mb-3 ">
        <input class="form-control " type="text" placeholder="Mức giá nhỏ nhất" id="filterpricemin"  name="filterpricemin">
     
        <input class="form-control mx-3" type="text" placeholder="Mức giá lớn nhất" id="filterpricemax" name="filterpricemax"  >
   
       </div>
       
               <label for="dsDanhMuc">Danh mục :</label>
               <div class="container-fluid d-flex justify-content-between my-3">
             
                      <select class="form-control mr-5 " id="dsDanhMuc" name="id_category" >
                            <option  value="all"  >Tất cả</option>
                <%	
for(int i=0;i<listPT.size();i++)
{ 
%>
                   <option  value="<%=listPT.get(i).getId()%>"  ><%=listPT.get(i).getTen_danh_muc()%></option>
                   <%} %>
                 </select>
                <p>     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
              
               </div>    
        <a class="btn btn-light" onclick="SearchFunction()">Tìm kiếm</a>
                </div>
            </div>
            
            <div class="col py-3 ">
                               
        <section class="py-5">
           <div class="container px-4 px-lg-5 mt-5">
              <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-3 justify-content-center" id="containerProduct">
          
      
          
                <%
                List<SanPham> listP=(List<SanPham>)request.getAttribute("listP");
                %>
        <%
        for(int i=0;i<listP.size();i++)
        {
        %>
                    <div class="col mb-5 productitem" >
                        <div class="card h-100">
                            <!-- Sale badge-->
                           <%if(listP.get(i).getGiam_gia()!=0){ %>
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                          <%} %>
                            <!-- Product image-->
                          <a href="DetailPageController?IdProductChossen=<%=listP.get(i).getId()%>">
    <img class="card-img-top" src="<%=listP.get(i).getHinh_anh()%>" alt="..." />
  </a>
                            <!-- Product details-->
                            <div class="card-body p-4"style="display: flex;
            flex-direction: column;
            justify-content: flex-end;">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%=listP.get(i).getTen()%></h5>
                                    <!-- Product reviews-->                   
                                       <%if(listP.get(i).getGiam_gia()!=0){ %>
                                    <small class="text-muted text-decoration-line-through"><%=listP.get(i).getGia_ban()%>đ</small>
                                    <span class="h5 mb-0 text-primary">  <%=(int)(listP.get(i).getGia_ban()-listP.get(i).getGiam_gia()*listP.get(i).getGia_ban()/100)%>đ</span>
                                  
                                  
                              <%} 
                                       else {%>
                                      <span class="h5 mb-0 text-primary"> <%=listP.get(i).getGia_ban() %></span>
                                
                              <%} %>
                               </div>
                               
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">

                                      <div class="text-center" style="  display: flex;
  justify-content: center;
  align-items: center;"> <%if(listP.get(i).getDeleted()==0) {%> <span onclick="addToCart(<%=listP.get(i).getId()%>)" class="cart__button">
      <span class="add__to-cart">Thêm giỏ hàng</span>
            <span class="added">Đã thêm</span>
      <i class="fas fa-shopping-cart"></i>
      <i class="fas fa-box"></i>
    </span>
    <%} else {%>
    <span style="color: red;"> Sản phẩm hiện tại chưa sẵn sàng</span>
    <%} %>
    </div>
                     </div>
                           </div>
                                  </div>
                                     
                                     </div>
                               <%} %>        
               
</div>
     </div>
        </section>
      <div style="display: grid; justify-content: center;">
    <a class="btn btn-light" onclick="LoadmoreFunction();">Xem thêm</a>
    <div class="cart-notification"></div>
</div>
          </div>
            </div>
              </div>
                  <script>
                  const cartButton = document.querySelectorAll(".cart__button");
                  cartButton.forEach((button) => {
                    button.addEventListener("click", cartClick);
                  });             
                  function cartClick() {
                	  let button = this;
                	  button.classList.add("clickeddd");
                	}

                  function getSelectedRadioValue(name) {
                	  let selectedValue = null;
                	  let radioButtons = document.getElementsByName(name);

                	  for (let i = 0; i < radioButtons.length; i++) {
                	    if (radioButtons[i].checked) {
                	      selectedValue = radioButtons[i].value;
                	      break;
                	    }
                	  }
                	  return selectedValue;
                	}
       
                	                               function SearchFunction(){
                	                                $.ajax({
                	                                         url: "SearchController",
                	                                         type: "get", //send it through get method
                	                                         data: {
                	                                        	
                	                                            searchbox: document.getElementById("searchbox").value,
                	                                            radioValue: getSelectedRadioValue("filterprice"),
                	                                            minprice:document.getElementById("filterpricemin").value,
                	                                            maxprice:document.getElementById("filterpricemax").value,
                	                                            id_category:document.getElementById("dsDanhMuc").value,
                	 
                	                                         },
                	                                         success: function (responseData) {
                	                                        	 document.getElementById("containerProduct").innerHTML = responseData;  
                	                                             const cartButton = document.querySelectorAll(".cart__button");
                	                                             cartButton.forEach((button) => {
                	                                               button.addEventListener("click", cartClick);
                	                                             });
                	                                         }
                	                                     });
                	                               }
                    
                               </script>    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script src="js/Myjs.js"></script>
        <script src="test.js"></script>
    </body>
</html>