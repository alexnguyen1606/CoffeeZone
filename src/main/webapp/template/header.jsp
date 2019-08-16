<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/16/2019
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/template/common.jsp"></jsp:include>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
<div class="container">
<a class="navbar-brand " href="/">Coffee Zone</a>
<div class="collapse navbar-collapse">
<ul class="navbar-nav ml-auto" >
    <li class="nav-item "><a class="nav-link ${param.active}" href="<c:url value="/student"/>">Student</a></li>
    <li class="nav-item "><a class="nav-link ${param.active}" href="/">Service</a></li>
    <li class="nav-item "><a class="nav-link ${param.active}" href="/">About</a></li>
</ul>
</div>

</button>
</div>
</nav>