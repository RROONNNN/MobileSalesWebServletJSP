<%@page import="Config.ConfigOfWeb"%>
<%@page import="Config.Config"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page import="Model.SanPham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="Model.*" %> 
        <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</style>
</head>
  <body>
        <!-- Navigation-->
        <%
       SanPham sPham=(SanPham)request.getAttribute("ChossenProduct");
        %>
       <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="<%=ConfigOfWeb.HomePageLink%>"></a>
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
   Cart cartInstance=(Cart)session.getAttribute("Cart");
	// System.out.print("dit me may + "+cartInstance.getQuantity());
%>

     <li><a class="dropdown-item" href="#">4533</a></li>
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
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="<%=sPham.getHinh_anh()%>" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">SKU: BST-498</div>
                        <h1 class="display-5 fw-bolder"><%=sPham.getTen()%></h1>
                        <div class="fs-5 mb-5">
                          <%if(sPham.getGiam_gia()!=0){ %>  <small class="text-decoration-line-through"><%=sPham.getGia_ban()%></small><%}%>
                            <span class="h5 mb-0 text-primary"><%= (int)(sPham.getGia_ban()-sPham.getGiam_gia()*sPham.getGia_ban()/100)%></span>
                        </div>
                        <p class="lead"><%=sPham.getMo_ta() %></p>
                        <div class="d-flex">
                            <div class="text-center" style="  display: flex;
  justify-content: center;
  align-items: center;">  <%if(sPham.getDeleted()==0) {%> <span onclick="addToCart(<%=sPham.getId()%>)" class="cart__button">
      <span class="add__to-cart">Thêm giỏ hàng</span>
            <span class="added">Đã thêm</span>
      <i class="fas fa-shopping-cart"></i>
      <i class="fas fa-box"></i>
    </span>
    <%} else {%>
    <span style="color: red;"> Sản phẩm hiện tại chưa sẵn sàng</span>
    <%} %></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">Sản Phẩm Liên Quan</h2>
                <div class=" containerProduct row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
       <%
       List<SanPham> ProductSuggestList=(List<SanPham>)request.getAttribute("ProductSuggestList");
        for (int i=0;i<ProductSuggestList.size();i++){
       %>
                  
          <div class="col mb-5 productitem" >
                        <div class="card h-100">
                            <!-- Sale badge-->
                           <%if(ProductSuggestList.get(i).getGiam_gia()!=0){ %>
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                          <%} %>
                            <!-- Product image-->
                                                   <a href="DetailPageController?IdProductChossen=<%=ProductSuggestList.get(i).getId()%>">
                            <img class="card-img-top" src="<%=ProductSuggestList.get(i).getHinh_anh()%>" alt="..." />
                              </a>
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%=ProductSuggestList.get(i).getTen()%></h5>
                                    <!-- Product reviews-->                   
                                       <%if(ProductSuggestList.get(i).getGiam_gia()!=0){ %>
                                    <small class="text-muted text-decoration-line-through"><%=ProductSuggestList.get(i).getGia_ban()%>đ</small>
                                    <span class="h5 mb-0 text-primary">  <%=(int)(ProductSuggestList.get(i).getGia_ban()-ProductSuggestList.get(i).getGiam_gia()*ProductSuggestList.get(i).getGia_ban()/100)%>đ</span>
                              <%} 
                                       else {%>
                                    <%=ProductSuggestList.get(i).getGia_ban() %>
                                
                              <%} %>
                               </div>
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">

                                      <div class="text-center" style="  display: flex;
  justify-content: center;
  align-items: center;">  <%if(ProductSuggestList.get(i).getDeleted()==0) {%> <span onclick="addToCart(<%=ProductSuggestList.get(i).getId()%>)" class="cart__button">
      <span class="add__to-cart">Thêm giỏ hàng</span>
            <span class="added">Đã thêm</span>
      <i class="fas fa-shopping-cart"></i>
      <i class="fas fa-box"></i>
    </span>
    <%} else {%>
    <span style="color: red;"> Sản phẩm hiện tại chưa sẵn sàng</span>
    <%} %></div>
                     </div>
                           </div>
                                  </div>
                                     
                                     </div>
                    
     <%} %>               
                </div>
            </div>
        </section>
           <div style="display: grid; justify-content: center;">
    <a class="btn btn-light" onclick="LoadmoreFunction2();">Xem thêm</a>
    <div class="cart-notification"></div>
</div>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white"></p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script type="text/javascript">
        const cartButton = document.querySelectorAll(".cart__button");
        cartButton.forEach((button) => {
          button.addEventListener("click", cartClick);
        });             
        function cartClick() {
      	  let button = this;
      	  button.classList.add("clickeddd");
      	}
        function LoadmoreFunction2(){
            $.ajax({
                     url: "LoadMoreControllerForDetailPage",
                     type: "get", //send it through get method
                     data: {
                  	    beginnum:document.getElementsByClassName("productitem").length,
                  	  IdProductChossen:4

                     },
                     success: function (responseData) {
                    	 document.getElementById("containerProduct").innerHTML+=responseData
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
        <!-- Core theme JS-->

    </body>
</html>