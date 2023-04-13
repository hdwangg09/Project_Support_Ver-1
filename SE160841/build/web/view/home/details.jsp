<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quang Store</title>

        <!-- Bootstrap -->
        <link href="../assets/home/details/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Font Awesome -->
        <link href="../assets/home/details/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <!-- Custom CSS -->
        <link href="../assets/home/details/style.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/home/details/css/responsive.css" rel="stylesheet" type="text/css"/>
        <link href="../../assets/home/style.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <h1><a href="index"><img src="../assets/home/details/img/logo.png"></a></h1>
                    </div>
                </div>
            </div>

            <div class="mainmenu-area">
                <div class="container">
                    <div class="row">

                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Shop page</a></li>
                                <li><a class="active" href="#">Product Details </a></li>
                                <li><a href="#">Cart</a></li>
                                <li><a href="#">Checkout</a></li>
                                <li><a href="#">Category</a></li>
                                <li><a href="#">Others</a></li>
                                <li><a href="#">Contact</a></li>
                                    <c:if test="${not empty sessionScope.LOGIN_USER.tentk}">
                                    <li class="dropdown dropdown-small">
                                        <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span
                                                class="key">Username :</span><span class="value"> ${sessionScope.LOGIN_USER.tentk}
                                            </span><b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Profile</a></li>
                                            <li><a href="#">Change Password</a></li>
                                            <li><a href="#">Logout</a></li>
                                        </ul>
                                    </li>
                                </c:if>
                                <c:if test="${empty sessionScope.LOGIN_USER.tentk}">
                                    <li><a href="../home/login">Login</a></li>
                                    </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div> <!-- End mainmenu area -->

        </div>
        <c:set var="product" value="${requestScope.product}"></c:set>
        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">               
                    <div class="col-md-12">
                        <div class="product-content-right">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="product-images">
                                        <div class="product-main-img">
                                            <img src="../assets/home/details/img/product-2.jpg" alt="">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="product-inner">
                                        <h2 class="product-name">${product.tensp}</h2>
                                        <div class="product-inner-category">
                                            <p>Category: ${product.danhmuc.tendm}

                                        </div> 
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                <h4>Descriptions</h4>
                                                <p>${product.mota}</p>
                                            </div>
                                        </div>
                                        <div class="product-inner-price">
                                            <ins>${product.dongia}</ins> 
                                        </div>   
                                        <form action="" class="cart">
                                            <div class="quantity">
                                                <input type="number" size="4" class="input-text qty text" title="Qty" value="1" name="quantity" min="1" step="1">
                                            </div>
                                            <button class="add_to_cart_button" type="submit">Add to cart</button>
                                        </form>   
                                    </div>
                                </div>
                            </div>                    
                        </div>
                    </div>
                </div>
            </div>

            <!-- Latest jQuery form server -->
            <script src="https://code.jquery.com/jquery.min.js"></script>

            <!-- Bootstrap JS form CDN -->
            <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

            <!-- Main Script -->
            <script src="../assets/home/details/js/main.js" type="text/javascript"></script>
    </body>

</html>