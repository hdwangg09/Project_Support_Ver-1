<%-- 
    Document   : index
    Created on : Feb 17, 2023, 3:16:06 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>
            Admin Page
        </title>

        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- Material Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
        <!-- CSS Files -->
        <link href="../assets/admin/product/css/material-dashboard.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>

    <body class="g-sidenav-show  bg-gray-200">
        <aside
            class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3   bg-gradient-dark"
            id="sidenav-main">
            <div class="sidenav-header">
                <i class="fas fa-times p-3 cursor-pointer text-white opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
                   aria-hidden="true" id="iconSidenav"></i>
                <a class="navbar-brand m-0" href="#" target="_blank">
                    <img src="../assets/admin/product/img/logo-ct.png" class="navbar-brand-img h-100" alt="main_logo">
                    <span class="ms-1 font-weight-bold text-white">Quang Store</span>
                </a>
            </div>
            <hr class="horizontal light mt-0 mb-2">
            <div class="collapse navbar-collapse  w-auto  max-height-vh-100" id="sidenav-collapse-main">
                <ul class="navbar-nav">

                    <li class="nav-item">
                        <a class="nav-link text-white" href="../admin/account">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">person</i>
                            </div>
                            <span class="nav-link-text ms-1">Account</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link text-white active bg-gradient-primary" href="../admin/product">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">sell</i>
                            </div>
                            <span class="nav-link-text ms-1">Product</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link text-white " href="../admin/category">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">category</i>
                            </div>
                            <span class="nav-link-text ms-1">Category</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link text-white" href="../admin/supplier">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">supervisor_account</i>
                            </div>
                            <span class="nav-link-text ms-1">Supplier</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link text-white " href="#">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">money</i>
                            </div>
                            <span class="nav-link-text ms-1">Bill</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white " href="#">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="material-icons opacity-10">logout</i>
                            </div>
                            <span class="nav-link-text ms-1">Logout</span>
                        </a>
                    </li>
                </ul>
            </div>

        </aside>
        <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
            <div class="container-fluid py-4" style="margin-top: 100px;">
                <div class="row">
                    <div class="col-12">
                        <div class="card my-4">
                            <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                                <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                                    <h6 class="text-white text-capitalize ps-3">Edit Product</h6>
                                </div>
                            </div>
                            <div class="card-body px-0 pb-2">
                                <div class="form-responsive p-4 " style="margin-left: 2%;">
                                    <!-- <table class="table align-items-center mb-0"> -->
                                    <form class=" form align-items-center mb-4 " action="../admin/editProduct" method="post">
                                        <c:set var="product" value="${requestScope.product}"></c:set>
                                            <div class="form-group row">
                                                <label for="productID" class="col-sm-8 col-form-label"> ID</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" id="productID" name="productID"
                                                           value="${product.masp}" readonly>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="productName" class="col-sm-8 col-form-label"> Name</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="productName" name="productName" value="${product.tensp}"
                                                       placeholder="Enter Product Name">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="productQuantity" class="col-sm-8 col-form-label"> Quantity</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="productQuantity" name="productQuantity" value="${product.soluong}"
                                                       placeholder="Enter Product Quantity">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="productPrice" class="col-sm-8 col-form-label"> Price</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="productPrice" name="productPrice" value="${product.dongia}"
                                                       placeholder="Enter Product Price">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="productDescriptions" class="col-sm-8 col-form-label"> Descriptions</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="productDescriptions"  
                                                       name="productDescriptions" value="${product.mota}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="accountStatus" class="col-sm-8 col-form-label">
                                                Supplier</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="productSupplier" name="productSupplier">
                                                    <c:forEach var="supplier" items="${requestScope.listSupplier}">
                                                        <option ${product.nhacungcap.mancc == supplier.mancc ? "selected = 'selected'" : ""} 
                                                            value="${supplier.mancc}">${supplier.tenncc}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="accountStatus" class="col-sm-8 col-form-label">
                                                Category</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="productCategory" name="productCategory">
                                                    <c:forEach var="category" items="${requestScope.listCategory}">
                                                        <option ${product.danhmuc.madm == category.madm ? "selected = 'selected'" : ""} 
                                                            value="${category.madm}">${category.tendm}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="accountStatus" class="col-sm-8 col-form-label">
                                                Status</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" id="productStatus" name="productStatus">
                                                    <option ${product.trangthai ? "selected = 'selected'" : ""} value="active">Active</option>
                                                    <option ${!product.trangthai ? "selected = 'selected'" : ""} value="deactive">Deactive</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row ">
                                            <div class="col-sm-4 text-center">
                                                
                                                    <button type="submit" class="btn btn-primary">Save</button>
                                               
                                                <a href="../admin/product">
                                                    <button type="submit" class="btn btn-danger">Back</button>
                                                </a>
                                            </div>

                                        </div>
                                    </form>
                                    <!-- </table> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>


    </body>

</html>