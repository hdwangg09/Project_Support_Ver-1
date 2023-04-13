<%-- 
    Document   : index
    Created on : Mar 19, 2023, 7:04:45 PM
    Author     : ROG STRIX
--%>

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
        <link href="../assets/home/index/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Font Awesome -->
        <link href="../assets/home/index/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <!-- Custom CSS -->
        <link href="../assets/home/index/style.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/home/index/css/responsive.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <h1><a href="index"><img src="../assets/home/index/img/logo.png"></a></h1>
                    </div>
                </div>
            </div>

            <div class="mainmenu-area">
                <div class="container">
                    <div class="row">
<!--                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse"
                                    data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>-->
                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="index.html">Home</a></li>
                                <li class="active"><a href="shop.html">Shop page</a></li>
                                <li><a href="single-product.html">Single product</a></li>
                                <li><a href="cart.html">Cart</a></li>
                                <li><a href="checkout.html">Checkout</a></li>
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

            <div class="single-product-area">
                <div class="container">
                    <div class="row">
                        <c:forEach items="${requestScope.listProducts}" var="product">
                            <div class="col-md-3 col-sm-6">
                                <div class="single-shop-product">
                                    <div class="product-upper">
                                        <a href="../home/details?productID=${product.masp}">
                                            <img src="../assets/home/index/img/product-2.jpg" alt="">
                                        </a>
                                    </div>
                                    <h2><a href="../home/details?productID=${product.masp}">${product.tensp}</a></h2>
                                    <div class="product-carousel-price">

                                        <ins><fmt:formatNumber  maxFractionDigits = "3" type = "currency" value = "${product.dongia}"/></ins>

                                    </div>

                                    <div class="product-option-shop">
                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70"
                                           rel="nofollow" href="/canvas/shop/?add-to-cart=70">Add to
                                            cart</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>

        <!-- Latest jQuery form server -->
        <script src="https://code.jquery.com/jquery.min.js"></script>

        <!-- Bootstrap JS form CDN -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <!-- Main Script -->
        <!--<script src="assets/home/index/js/main.js" type="text/javascript"></script>-->
        <script src="../assets/home/index/js/main.js" type="text/javascript"></script>
    </body>

</html>