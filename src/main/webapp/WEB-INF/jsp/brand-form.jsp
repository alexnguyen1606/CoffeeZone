<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/28/2019
  Time: 10:10 AM
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
<jsp:include page="/template/admin/header.jsp"></jsp:include>
<div class="row">
    <jsp:include page="/template/admin/menu-admin.jsp"></jsp:include>
    <div class="col-lg-10">
        <form:form action="/admin/brand/new" modelAttribute="viewmodel" method="post"  cssClass="form-group">
            <form:label path="name">Name:</form:label>
            <form:input path="name" cssClass="form-control"></form:input>
            <form:label path="description">Description:</form:label>
            <form:input path="description" cssClass="form-control"></form:input>
            <br>
            <form:label path="establieshed">Establieshed</form:label>
            <form:input path="establieshed" cssClass="form-control"></form:input>
            <br>
            <form:label path="status">Status:</form:label>
            <form:select path="status" cssClass="form-control">
                <form:option value="false">Disable</form:option>
                <form:option value="true">Enable</form:option>
            </form:select>
            <br>
            <button type="submit" class="btn btn-success">Add</button>
        </form:form>
    </div>
</div>
<jsp:include page="/template/admin/footer.jsp"></jsp:include>
</body>
</html>
