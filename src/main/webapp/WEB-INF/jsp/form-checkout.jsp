<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="<c:url value="/template/css/form-import.css"/>" rel="stylesheet">
</head>
<body>
<jsp:include page="/template/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-lg-6 form-block" id="formblock">
            <form:form action="/checkout" modelAttribute="customer" method="POST" cssClass="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" cssClass="form-control"></form:input>
                <br>
                <form:label path="email">Email:</form:label>
                <form:input path="email" type="email" oninvalid="alert('Field Must be A Email');"  cssClass="form-control"></form:input>
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
            <p class="message">Have ever Checkout? <a href="#" onclick="openForm()">Use Email</a></p>
        </div>
        <div class="col-lg-6 form-popup" id="formpopup">
            <form:form action="/checkout" method="post" modelAttribute="customer" cssClass="form-group">
                <form:label path="email">Email:</form:label>
                <form:input path="email" type="email" oninvalid="alert('Field Must be A Email');"  cssClass="form-control"></form:input>
                <button type="submit" class="btn btn-success">Check out</button>
            </form:form>
            <button class="btn btn-danger" onclick="closeForm()">Cancel</button>
        </div>
    </div>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>
<script>
    function openForm() {
        document.getElementById("formblock").style.display="none";
        document.getElementById("formpopup").style.display="block";
    }
    function closeForm() {
        document.getElementById("formblock").style.display="block";
        document.getElementById("formpopup").style.display="none";
    }
</script>
</body>
</html>
