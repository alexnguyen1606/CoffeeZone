<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Zone</title>
<jsp:include page="/template/bootstrap.jsp"></jsp:include>
</head>
<body>
<c:import url="/template/header.jsp"><c:param name="active" value="active"/></c:import>
<div class="container">
    <a class="btn btn-success"  href="<c:url value="/student/new"/>">New</a>
</div>
${status}
<c:if test="${empty listStudent}"><h2 class="alert-danger">Chưa có sinh viên</h2></c:if>
<c:if test="${not empty listStudent}" >
<div class="container">
    <div class="col-sm-10">
<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <td>Phone Number</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listStudent}" var="student">
        <tr>
            <td>${student.idStudent}</td>
            <td>${student.name}</td>
            <td><a  class="btn btn-danger" href="/student/delete?id=${student.id}">Delete</a>
            <a class="btn btn-info" href="/student/detail?id=${student.id}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    </div>
</div>
</c:if>
<jsp:include page="/template/bootstrap.jsp"></jsp:include>
</body>

</html>
