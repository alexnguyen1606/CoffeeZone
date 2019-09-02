<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/25/2019
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Zone</title>
    <c:import url="/template/bootstrap.jsp"></c:import>
    <link href="<c:url value="/template/css/loginpage.css"/> " rel="stylesheet" type="text/css">
    <script src='https://www.google.com/recaptcha/api.js?hl=vi'></script>


    <!-- reCAPTCHA with Auto language -->
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>

<body>
<jsp:include page="/template/header.jsp"></jsp:include>
<div class="container">
    <c:if test="${param.message!=null}"><div class="alert alert-danger col-lg-6 shape">${param.message}</div></c:if>
<div class="row" style="margin-top: 30px">
    <div class="form-login col-lg-6" id="formlogin" >
        <form:form action="/login" method="post" modelAttribute="viewmodel" cssClass="form-group">
            <form:label path="username">Username</form:label>
            <form:input path="username"  cssClass="form-control shape"  required="required" ></form:input>
            <form:label path="password">Password</form:label>
            <form:password  path="password"  cssClass="form-control shape"  required="required"></form:password>
            <div class="g-recaptcha shape"
                 data-sitekey="6Le91LUUAAAAABm64Gl9zBlACYZrO9DHudc-kuGT" ></div>
            <button type="submit" class="btn-success btn shape" >login</button>
            <p class="message">Not registered? <a href="#" onclick="openForm()">Create an account</a></p>
        </form:form>
    </div>
    <div class="form-popup col-lg-6" id="formregister">
        <form:form action="/register" method="post" modelAttribute="viewmodel" cssClass="form-group">
            <form:label path="username">Username</form:label>
            <form:input path="username" cssClass="form-control shape"  required="required"></form:input>
            <br>
            <form:label path="password">Password</form:label>
            <form:password path="password" id="password" cssClass="form-control shape"  required="required"></form:password>
            <br>
            <label>Confirm Password</label>
            <input  id="confirm_password" required type="password" class="form-control shape" />
            <span id='message'></span>
            <br>
            <form:label path="email">Email</form:label>
            <form:input path="email" type="email" required="required" oninvalid="alert('Field Must be A Email');"  cssClass="form-control shape" ></form:input>
            <br>
            <button type="submit" class="btn btn-primary">Register</button>
        </form:form>
        <p class="message">Have Account? <a href="#" onclick="closeForm()">Login</a></p>
    </div>
</div>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>
<script>
    //show and close form
    function openForm() {
        document.getElementById("formregister").style.display = "block";
        document.getElementById("formlogin").style.display="none";
    }
    function closeForm() {
        document.getElementById("formregister").style.display = "none";
        document.getElementById("formlogin").style.display="block";
    }
    //confirm password
    $('#password, #confirm_password').on('keyup', function () {
        if ($('#password').val() === $('#confirm_password').val()) {
            $('#message').html('Matching').css('color', 'green');
        } else
            $('#message').html('Not Matching').css('color', 'red');
    });
</script>
</body>
</html>
