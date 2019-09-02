<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/28/2019
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:if test="${USERNAME==null}"><c:redirect url="/login"></c:redirect></c:if>--%>
<c:if test="${cookie.USERNAME.value==null}"><c:redirect url="/login"></c:redirect></c:if>
<html>
<head>
    <title>Coffee Zone</title>
    <jsp:include page="/template/bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/template/admin/header.jsp"></jsp:include>
<div class="row">
    <jsp:include page="/template/admin/menu-admin.jsp"></jsp:include>
    <div class="col-lg-10" style="padding-top: 10px">
        <a  href="/admin/brand/new"><i class="fa fa-plus-circle fa-3x"></i></a>
        <a href="/admin/download/listBrand"><i class="fa fa-download fa-3x" style="margin-right:auto " ></i></a>
        <c:if test="${not empty param.message}"><div class="alert alert-${param.alert}">${param.message}</div></c:if>
        <c:if test="${not empty brands}">
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Establieshed</th>
                <th>Status</th>
                <th>Tool</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${brands}" var="brand">
                <tr>
                    <td>${brand.name}</td>
                    <td>${brand.description}</td>
                    <td>${brand.establieshed}</td>
                    <td><c:if test="${brand.status == false}">Disable</c:if><c:if test="${brand.status == true}">Enable</c:if></td>
                    <td><a href="/admin/brand/update/${brand.id}" ><i class="fa fa-edit fa-1x" style="color: darkcyan;"></i></a>
                        <a href="/admin/brand/${brand.id}"  onclick="return confirm('Are you sure?')" ><i class="fa fa-trash fa-1x" style="color: red;"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </c:if>
    </div>
</div>
<jsp:include page="/template/admin/footer.jsp"></jsp:include>
</body>
</html>
