
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Coffee Zone</title>
    <link href="<c:url value="/webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/template/css/formshape.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/css/header-homepage.css"/>" rel="stylesheet">
    <script src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>"></script>
</head>
<body>
<%--<c:import url="/template/header.jsp"><c:param name="active" value="active"></c:param> </c:import>--%>
<c:import url="/template/header.jsp"></c:import>
${status}
<div class="container">
    <c:if test="${student.id!=0}"><h2>Update</h2></c:if>
    <c:if test="${student.id==0}"><h2>New</h2></c:if>
<form:form action="/student" method="${method}" modelAttribute="student" cssClass="form-group">
    <form:hidden path="id"/>
    Name:
    <form:input  path="name" cssClass="form-control shape"/>
    <br>
    ID:
    <form:input path="idStudent" cssClass="form-control shape"/>
    <br>
    Address:
    <form:input path="address" cssClass="form-control shape"/>
   <br>
    Phone:
    <form:input path="phoneNumber" cssClass="form-control shape" />
    <br>
    Birth Day:
    <form:input path="birthDay" cssClass="form-control shape" />
    <br>
    <input type="submit" class="btn btn-success" value="Save"/>
</form:form>
</div>
</body>
</html>
