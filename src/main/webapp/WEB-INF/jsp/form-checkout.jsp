<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/25/2019
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Zone</title>
    <jsp:include page="/template/bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/template/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <form:form action="/checkout" modelAttribute="customer" method="POST" cssClass="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" cssClass="form-control"></form:input>
                <br>
                <form:label path="email">Email:</form:label>
                <form:input path="email" cssClass="form-control"></form:input>
                <br>
                <form:label path="phonenumber">Phone Number:</form:label>
                <form:input path="phonenumber" cssClass="form-control"></form:input>
                <br>
                <form:label path="city">City:</form:label>
                <form:input path="city" cssClass="form-control"></form:input>
                <br>
                <form:label path="district">District:</form:label>
                <form:input path="district" cssClass="form-control"></form:input>
                <br>
                <form:label path="ward">Ward</form:label>
                <form:input path="ward" cssClass="form-control"></form:input>
                <br>
                <form:label path="street">Address:</form:label>
                <form:input path="street" cssClass="form-control"></form:input>
                <br>
                <button type="submit" class="btn btn-success">Check out</button>
            </form:form>
        </div>
    </div>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>
