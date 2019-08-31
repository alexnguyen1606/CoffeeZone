<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/template/bootstrap.jsp"></jsp:include>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
<div class="container">
<a class="navbar-brand " href="/">Coffee Zone</a>
<div class="collapse navbar-collapse">
<ul class="navbar-nav ml-auto" >
    <li class="nav-item"><a href="<c:url value="/cart"/>" class="nav-link"><i class="fa fa-shopping-cart fa-2x" style="color: cadetblue">
    </i><span class="badge">${sessionScope.totalItem}</span></a></li>
    <li class="nav-item "><a class="nav-link ${param.active}" href="/">Service</a></li>
    <li class="nav-item "><a class="nav-link ${param.active}" href="/">About</a></li>
    <c:choose>
        <c:when test="${not empty USERNAME}">
            <li class="nav-item"><a class="nav-link" href="<c:url value="/admin"/>" >Quản lý</a> </li>
            <li class="nav-item"><a class="nav-link">${FULLNAME}</a></li>
            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
        </c:when>
        <c:otherwise>
            <li class="nav-item"><a href="/login" class="nav-link">Login</a></li>
        </c:otherwise>
    </c:choose>
</ul>
</div>
</div>
</nav>