<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/16/2019
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Zone</title>
    <jsp:include page="/template/bootstrap.jsp"/>
</head>
<body>
<c:import url="/template/header.jsp"><c:param name="active" value="active"/></c:import>
<c:if test="${student==null}">ID is exits</c:if>
<c:if test="${student!=null}">
<div class="container-fluid">
    Name:${student.name}
    <br>
    ID:${student.idStudent}
    <br>
    Address:${student.address}
    <br>
    Birth Day: ${student.birthDay}
    <br>
    Phone Number:${student.phoneNumber}
    <br>
    <a class="btn btn-info" href="/student/update?id=${student.id}">Update</a>
</div>
</c:if>
</body>
</html>
