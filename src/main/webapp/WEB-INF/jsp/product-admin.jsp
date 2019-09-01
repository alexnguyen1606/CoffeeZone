<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/23/2019
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${USERNAME==null}"><c:redirect url="/login"></c:redirect></c:if>
<html>
<head>
    <title>Coffee Zone</title>
    <jsp:include page="/template/bootstrap.jsp"></jsp:include>
</head>
<body>
<c:import url="/template/admin/header.jsp"></c:import>
<div >
    <div class="row">
        <c:import url="/template/admin/menu-admin.jsp"></c:import>
        <div class="col-lg-10" style="padding-top: 10px">
            <a  href="/admin/product/new"><i class="fa fa-plus-circle fa-3x"></i></a>
            <a href="/admin/download/listProduct"><i class="fa fa-download fa-3x" style="margin-left:auto " ></i></a>
            <c:if test="${not empty param.message}"><div class="alert alert-${param.alert}">${param.message}</div></c:if>
            <c:if test="${not empty products}">
            <table class="table table-hover table-striped" id="products" >
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Quantity</th>
                    <th>Flavor</th>
                    <th>Weight</th>
                    <th>Price</th>
                    <th>Status</th>
                    <th>Tool</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.quantity}</td>
                    <td>${product.flavor}</td>
                    <td>${product.weight}</td>
                    <td>${product.price}</td>
                    <td><c:if test="${product.status == 0}">Disable</c:if><c:if test="${product.status == 1}">Enable</c:if></td>
                    <td><a href="/admin/product/update?id=${product.id}" ><i class="fa fa-edit fa-1x" style="color: darkcyan;"></i></a>
                        <a href="/admin/product/${product.id}"  onclick="return confirm('Are you sure?')" ><i class="fa fa-trash fa-1x" style="color: red;"></i></a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
                </c:if>
        </div>
    </div>
</div>
<c:import url="/template/admin/footer.jsp"></c:import>
<c:import url="/template/JQueryLib/datatables.jsp"></c:import>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

<script>
    $(document).ready(function () {
        $('#products').DataTable({
            "bLengthChange":false
        });
    })
</script>
</body>
</html>
