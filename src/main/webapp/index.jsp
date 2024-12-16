<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Ministore</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="author" content="">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400;500&family=Lato:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <!-- script
    ================================================== -->
    <script src="js/modernizr.js"></script>
  </head>
  <body data-bs-spy="scroll" data-bs-target="#navbar" data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true" tabindex="0">
 

    <div class="search-popup">
        <div class="search-popup-container">

          <form role="search" method="get" class="search-form" action="">
            <input type="search" id="search-form" class="search-field" placeholder="Type and press enter" value="" name="s" />
            <button type="submit" class="search-submit"><svg class="search"><use xlink:href="#search"></use></svg></button>
          </form>

          <h5 class="cat-list-title">Browse Categories</h5>
          
          <ul class="cat-list">
            <li class="cat-list-item">
              <a href="#" title="Mobile Phones">Mobile Phones</a>
            </li>
            <li class="cat-list-item">
              <a href="#" title="Smart Watches">Smart Watches</a>
            </li>
            <li class="cat-list-item">
              <a href="#" title="Headphones">Headphones</a>
            </li>
            <li class="cat-list-item">
              <a href="#" title="Accessories">Accessories</a>
            </li>
            <li class="cat-list-item">
              <a href="#" title="Monitors">Monitors</a>
            </li>
            <li class="cat-list-item">
              <a href="#" title="Speakers">Speakers</a>
            </li>
            <li class="cat-list-item">
              <a href="#" title="Memory Cards">Memory Cards</a>
            </li>
          </ul>

        </div>
    </div>
    
    <header id="header" class="site-header header-scrolled position-fixed text-black bg-light">
      <nav id="header-nav" class="navbar navbar-expand-lg px-3 mb-3">
        <div class="container-fluid">
          <a class="navbar-brand" href="index.jsp">
            <img src="images/main-logo.png" class="logo">
          </a>
          <button class="navbar-toggler d-flex d-lg-none order-3 p-2" type="button" data-bs-toggle="offcanvas" data-bs-target="#bdNavbar" aria-controls="bdNavbar" aria-expanded="false" aria-label="Toggle navigation">
            <svg class="navbar-icon">
              <use xlink:href="#navbar-icon"></use>
            </svg>
          </button>
          <div class="offcanvas offcanvas-end" tabindex="-1" id="bdNavbar" aria-labelledby="bdNavbarOffcanvasLabel">
            <div class="offcanvas-header px-4 pb-0">
              <a class="navbar-brand" href="index.html">
                <img src="images/main-logo.png" class="logo">
              </a>
              <button type="button" class="btn-close btn-close-black" data-bs-dismiss="offcanvas" aria-label="Close" data-bs-target="#bdNavbar"></button>
            </div>
            <div class="offcanvas-body">
              <ul id="navbar" class="navbar-nav text-uppercase justify-content-end align-items-center flex-grow-1 pe-3">
                <li class="nav-item">
                  <a class="nav-link me-4 active" href="Shop">Mua hàng</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-4" href="#company-services">Dịch vụ</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-4" href="#mobile-products">Sản phẩm</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-4" href="#yearly-sale">Sale khủng</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-4" href="#latest-blog">Bài viết</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link me-4 dropdown-toggle link-dark" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Pages</a>
                  <ul class="dropdown-menu">
                    <li>
                      <a href="about.html" class="dropdown-item">About</a>
                    </li>
                    <li>
                      <a href="#latest-blog" class="dropdown-item">Bài viết</a>
                    </li>
                   
                    <li>
                      <a href="cart.html" class="dropdown-item">Giỏ hàng</a>
                    </li>
                    <li>
                      <a href="contact.html" class="dropdown-item">Liện hệ</a>
                    </li>
                  </ul>
                </li>
                <li class="nav-item">
                  <div class="user-items ps-5">
                    <ul class="d-flex justify-content-end list-unstyled">
                      <li class="search-item pe-3">
                        <a href="#" class="search-button">
                          <svg class="search">
                            <use xlink:href="#search"></use>
                          </svg>
                        </a>
                      </li>
                      <li class="pe-3">
                        <a href="#">
                          <svg class="user">
                            <use xlink:href="#user"></use>
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="cart.html">
                          <svg class="cart">
                            <use xlink:href="#cart"></use>
                          </svg>
                        </a>
                      </li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
    </header>
    <section id="billboard" class="position-relative overflow-hidden bg-light-blue">
      <div id="carouselExampleControls" class="carousel slide " data-ride="carousel">
        <div class="carousel-inner" >
          <div class="carousel-item active w-100 h-50">
            <img src="images/BigimageHome.png" class="d-block " alt="...">
          </div>
          <div class="carousel-item w-100 h-50" >
            <img src="images/image 7 (1).png" class="d-block " alt="...">
          </div>
          <div class="carousel-item w-100 h-50">
            <img src="images/image 8.png" class="d-block " alt="...">
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>


  
    </section>
    <section id="company-services" class="padding-large">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 pb-3">
            <div class="icon-box d-flex">
              <div class="icon-box-icon pe-3 pb-3">
                <svg class="cart-outline">
                  <use xlink:href="#cart-outline" />
                </svg>
              </div>
              <div class="icon-box-content">
                <h3 class="card-title text-uppercase text-dark">Miễn phí vận chuyển</h3>
                <p>Miễn Phí Vận Chuyển cho tất cả các đơn hàng trên toàn quốc.</p>
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 pb-3">
            <div class="icon-box d-flex">
              <div class="icon-box-icon pe-3 pb-3">
                <svg class="quality">
                  <use xlink:href="#quality" />
                </svg>
              </div>
              <div class="icon-box-content">
                <h3 class="card-title text-uppercase text-dark">Đảm bảo chất lượng</h3>
                <p>Cam kết mang đến cho bạn những sản phẩm với chất lượng tốt nhất.</p>
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 pb-3">
            <div class="icon-box d-flex">
              <div class="icon-box-icon pe-3 pb-3">
                <svg class="price-tag">
                  <use xlink:href="#price-tag" />
                </svg>
              </div>
              <div class="icon-box-content">
                <h3 class="card-title text-uppercase text-dark">Ưu đãi mỗi ngày</h3>
                <p>Hãy tận hưởng ưu đãi mỗi ngày với nhiều sản phẩm hấp dẫn.</p>
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 pb-3">
            <div class="icon-box d-flex">
              <div class="icon-box-icon pe-3 pb-3">
                <svg class="shield-plus">
                  <use xlink:href="#shield-plus" />
                </svg>
              </div>
              <div class="icon-box-content">
                <h3 class="card-title text-uppercase text-dark">100% uy tin</h3>
                <p>Cam kết mang đến cho khách hàng những sản phẩm 100% uy tín, đảm bảo chất lượng và dịch vụ tốt nhất.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section id="latest-blog" class="padding-large">
      <div class="container">
        <div class="row">
          <div class="display-header d-flex justify-content-between pb-3">
            <h2 class="display-7 text-dark text-uppercase">Latest Posts</h2>
            <div class="btn-right">
              <a href="blog.html" class="btn btn-medium btn-normal text-uppercase">Read Blog</a>
            </div>
          </div>
          <div class="post-grid d-flex flex-wrap justify-content-between">
            <div class="col-lg-4 col-sm-12">
              <div class="card border-none me-3">
                <div class="card-image">
                  <img src="images/post-item1.jpg" alt="" class="img-fluid">
                </div>
              </div>
              <div class="card-body text-uppercase">
                <div class="card-meta text-muted">
                  <span class="meta-date">feb 22, 2023</span>
                  <span class="meta-category">- Gadgets</span>
                </div>
                <h3 class="card-title">
                  <a href="#">Get some cool gadgets in 2023</a>
                </h3>
              </div>
            </div>
            <div class="col-lg-4 col-sm-12">
              <div class="card border-none me-3">
                <div class="card-image">
                  <img src="images/post-item2.jpg" alt="" class="img-fluid">
                </div>
              </div>
              <div class="card-body text-uppercase">
                <div class="card-meta text-muted">
                  <span class="meta-date">feb 25, 2023</span>
                  <span class="meta-category">- Technology</span>
                </div>
                <h3 class="card-title">
                  <a href="#">Technology Hack You Won't Get</a>
                </h3>
              </div>
            </div>
            <div class="col-lg-4 col-sm-12">
              <div class="card border-none me-3">
                <div class="card-image">
                  <img src="images/post-item3.jpg" alt="" class="img-fluid">
                </div>
              </div>
              <div class="card-body text-uppercase">
                <div class="card-meta text-muted">
                  <span class="meta-date">feb 22, 2023</span>
                  <span class="meta-category">- Camera</span>
                </div>
                <h3 class="card-title">
                  <a href="#">Top 10 Small Camera In The World</a>
                </h3>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section id="testimonials" class="position-relative">
      <div class="container">
        <div class="row">
          <div class="review-content position-relative">
            <div class="swiper-icon swiper-arrow swiper-arrow-prev position-absolute d-flex align-items-center">
              <svg class="chevron-left">
                <use xlink:href="#chevron-left" />
              </svg>
            </div>
            <div class="swiper testimonial-swiper">
              <div class="quotation text-center">
                <svg class="quote">
                  <use xlink:href="#quote" />
                </svg>
              </div>
              <div class="swiper-wrapper">
                <div class="swiper-slide text-center d-flex justify-content-center">
                  <div class="review-item col-md-10">
                    <i class="icon icon-review"></i>
                    <blockquote>“Công nghệ màn hình gập đang mở ra một chương mới cho các thiết bị di động, mang lại trải nghiệm linh hoạt và tiện lợi hơn cho người dùng.”</blockquote>
                    <div class="rating">
                      <svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
                      <svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
                      <svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
                      <svg class="star star-half">
                        <use xlink:href="#star-half"></use>
                      </svg>
                      <svg class="star star-empty">
                        <use xlink:href="#star-empty"></use>
                      </svg>
                    </div>
                    <div class="author-detail">
                      <div class="name text-dark text-uppercase pt-2">John Smith, TechCrunch</div>
                    </div>
                  </div>
                </div>
                <div class="swiper-slide text-center d-flex justify-content-center">
                  <div class="review-item col-md-10">
                    <i class="icon icon-review"></i>
                    <blockquote>“A blog is a digital publication that can complement a website or exist independently. A blog may include articles, short posts, listicles, infographics, videos, and other digital content.”</blockquote>
                    <div class="rating">
                      <svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
                      <svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
                      <svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
                      <svg class="star star-half">
                        <use xlink:href="#star-half"></use>
                      </svg>
                      <svg class="star star-empty">
                        <use xlink:href="#star-empty"></use>
                      </svg>
                    </div>
                    <div class="author-detail">
                      <div class="name text-dark text-uppercase pt-2">Jennie Rose</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="swiper-icon swiper-arrow swiper-arrow-next position-absolute d-flex align-items-center">
              <svg class="chevron-right">
                <use xlink:href="#chevron-right" />
              </svg>
            </div>
          </div>
        </div>
      </div>
      <div class="swiper-pagination"></div>
    </section>
    <section id="subscribe" class="container-grid padding-large position-relative overflow-hidden">
      <div class="container">
        <div class="row">
          <div class="subscribe-content bg-dark d-flex flex-wrap justify-content-center align-items-center padding-medium">
            <div class="col-md-6 col-sm-12">
              <div class="display-header pe-3">
                <h2 class="display-7 text-uppercase text-light">Đăng ký chúng tôi ngay bây giờ</h2>
                <p>Nhận được tin tức mới nhất, cập nhật và ưu đãi sẽ được gửi trực tiếp vào mail của bạn</p>
              </div>
            </div>
            <div class="col-md-5 col-sm-12">
              <form class="subscription-form validate">
                <div class="input-group flex-wrap">
                  <input class="form-control btn-rounded-none" type="email" name="EMAIL" placeholder="Your email address here" required="">
                  <button class="btn btn-medium btn-primary text-uppercase btn-rounded-none" type="submit" name="subscribe">Đăng ký</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>
    <footer id="footer" class="overflow-hidden">
      <div class="container">
        <div class="row">
          <div class="footer-top-area">
            <div class="row d-flex flex-wrap justify-content-between">
              <div class="col-lg-3 col-sm-6 pb-3">
                <div class="footer-menu">
                  <img src="images/main-logo.png" alt="logo">
                  <p>HBT Store là cửa hàng chuyên cung cấp các dòng điện thoại di động chính hãng với đa dạng mẫu mã và thương hiệu nổi tiếng. Chúng tôi cam kết mang đến cho khách hàng sản phẩm chất lượng cao, dịch vụ tư vấn chuyên nghiệp và chính sách hậu mãi uy tín.</p>
                  <div class="social-links">
                    <ul class="d-flex list-unstyled">
                      <li>
                        <a href="#">
                          <svg class="facebook">
                            <use xlink:href="#facebook" />
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <svg class="instagram">
                            <use xlink:href="#instagram" />
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <svg class="twitter">
                            <use xlink:href="#twitter" />
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <svg class="linkedin">
                            <use xlink:href="#linkedin" />
                          </svg>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <svg class="youtube">
                            <use xlink:href="#youtube" />
                          </svg>
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-lg-2 col-sm-6 pb-3">
                <div class="footer-menu text-uppercase">
                  <h5 class="widget-title pb-2">Đường dẫn nhanh</h5>
                  <ul class="menu-list list-unstyled text-uppercase">
                    <li class="menu-item pb-2">
                      <a href="#">Home</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">About</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Cửa hàng</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#latest-blog">Bài viết</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Thông tin liện hệ</a>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="col-lg-3 col-sm-6 pb-3">
                <div class="footer-menu text-uppercase">
                  <h5 class="widget-title pb-2">Hỗ trợ</h5>
                  <ul class="menu-list list-unstyled">
                    <li class="menu-item pb-2">
                      <a href="#">Giao hàng + Vận chuyển hàng</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Liên hệ với chúng tôi</a>
                    </li>
                    <li class="menu-item pb-2">
                      <a href="#">Faqs</a>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="col-lg-3 col-sm-6 pb-3">
                <div class="footer-menu contact-item">
                  <h5 class="widget-title text-uppercase pb-2">Liên hệ chúng tôi</h5>
                  <p>Bạn có vấn đề gì hay ý kiến gi <a href="mailto:">yourinfo@gmail.com</a>
                  </p>
                  <p>Nếu có hãy liên hệ với chúng tôi. Chúng tôi là HBTStore <a href="">+55 111 222 333 44</a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <hr>
    </footer>
    <div id="footer-bottom">
      <div class="container">
        <div class="row d-flex flex-wrap justify-content-between">
          <div class="col-md-4 col-sm-6">
            <div class="Shipping d-flex">
              <p>We ship with:</p>
              <div class="card-wrap ps-2">
                <img src="images/dhl.png" alt="visa">
                <img src="images/shippingcard.png" alt="mastercard">
              </div>
            </div>
          </div>
          <div class="col-md-4 col-sm-6">
            <div class="payment-method d-flex">
              <p>Payment options:</p>
              <div class="card-wrap ps-2">
                <img src="images/visa.jpg" alt="visa">
                <img src="images/mastercard.jpg" alt="mastercard">
                <img src="images/paypal.jpg" alt="paypal">
              </div>
            </div>
          </div>
          <div class="col-md-4 col-sm-6">
            <div class="copyright">
              <p>© Copyright 2023 HBTStore. Design by Ron <a href="https://templatesjungle.com/"></a><a href="https://themewagon.com"></a>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="js/plugins.js"></script>
    <script type="text/javascript" src="js/script.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
  </body>
</html>