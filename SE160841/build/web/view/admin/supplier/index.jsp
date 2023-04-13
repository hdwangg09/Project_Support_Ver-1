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
                        <a class="nav-link text-white " href="../admin/product">
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
                        <a class="nav-link text-white active bg-gradient-primary" href="../admin/supplier">
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
                                    <h6 class="text-white text-capitalize ps-3">Supplier Manager </h6>
                                </div>
                            </div>
                            <div class="card-body px-0 pb-2">
                                <div class="table-responsive p-0">
                                    <table class="table align-items-center mb-0">

                                        <thead>
                                            <tr>
                                                <th
                                                    class="text-uppercase text-secondary text-xxs font-weight-bolder">
                                                    Supplier ID</th>
                                                <th
                                                    class="text-center text-uppercase text-secondary text-xxs font-weight-bolder">
                                                    Supplier Name</th>
                                                <th
                                                    class="text-center text-uppercase text-secondary text-xxs font-weight-bolder">
                                                    Address</th>
                                                <th
                                                    class="text-center text-uppercase text-secondary text-xxs font-weight-bolder">
                                                    Status</th>
                                                <th
                                                    class="text-center text-uppercase text-secondary text-xxs font-weight-bolder">
                                                    Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach items="${requestScope.listSupplier}" var="supplier">

                                                <tr>
                                                    <td>
                                                        <div class="d-flex px-4 py-1">
                                                            <div class="d-flex flex-column justify-content-center">
                                                                <a href="../admin/detailsSupplier?supplierID=${supplier.mancc}"><span class="text-secondary text-xs font-weight-bold">${supplier.mancc}</span></a>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td class="align-middle text-center">
                                                        <span class="text-secondary text-xs font-weight-bold">${supplier.tenncc}</span>
                                                    </td>
                                                    <td class="align-middle text-center">
                                                        <span class="text-secondary text-xs font-weight-bold">${supplier.diachi}</span>
                                                    </td>

                                                    <c:if test="${supplier.trangthai}">
                                                        <td class="align-middle text-center text-sm">
                                                            <span class="badge badge-sm bg-gradient-success">Active</span>
                                                        </td>
                                                    </c:if>
                                                    <c:if test="${!supplier.trangthai}">
                                                        <td class="align-middle text-center text-sm">
                                                            <span class="badge badge-sm bg-danger">Deactive</span>
                                                        </td>
                                                    </c:if>

                                                    <td class="align-middle text-center">
                                                        <a href="../admin/editSupplier?supplierID=${supplier.mancc}" class="text-secondary font-weight-bold text-xs"
                                                           data-toggle="tooltip" data-original-title="Edit user">
                                                            Edit
                                                        </a>
                                                        <a href="../admin/detailsSupplier?supplierID=${supplier.mancc}" class="text-secondary font-weight-bold text-xs"
                                                           data-toggle="tooltip" data-original-title="Edit user">
                                                            Details
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>

</html>