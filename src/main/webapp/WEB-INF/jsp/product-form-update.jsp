<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/23/2019
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<c:if test="${USERNAME==null}"><c:redirect url="/login"></c:redirect></c:if>--%>
<c:if test="${cookie.USERNAME.value==null}"><c:redirect url="/login"></c:redirect></c:if>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Zone</title>
    <c:import url="/template/bootstrap.jsp"></c:import>
</head>
<body>
<c:import url="/template/admin/header.jsp"></c:import>
<div >
    <div class="row">
        <c:import url="/template/admin/menu-admin.jsp"></c:import>
        <div class="col-lg-9">
            <form:form modelAttribute="viewmodel" method="POST" action="/admin/product/update" cssClass="form-group" enctype="multipart/form-data">
                <form:hidden path="id"></form:hidden>
                <form:label path="name">Name:</form:label>
                <form:input path="name" cssClass="form-control"></form:input>
                <form:label path="description">Description:</form:label>
                <form:input path="description" cssClass="form-control"></form:input>
                <br>
                <form:label path="quantity">Quantity:</form:label>
                <form:input path="quantity" cssClass="form-control"></form:input>
                <br>
                <form:label path="flavor">Flavor:</form:label>
                <form:input path="flavor" cssClass="form-control"></form:input>
                <br>
                <form:label path="weight" >Weight:</form:label>
                <form:input path="weight" cssClass="form-control"></form:input>
                <br>
                <form:label path="price">Prices:</form:label>
                <form:input path="price" cssClass="form-control"></form:input>
                <br>
                <form:label path="brandEntity">Brand:</form:label>
                <form:select path="brandEntity" cssClass="form-control">
                    <form:option value="0">Null</form:option>
                    <c:forEach items="${brands}" var="brand">
                        <form:option value="${brand.id}">${brand.name}</form:option>
                    </c:forEach>
                </form:select>
                <br>
                <form:label path="status">Status:</form:label>
                <form:select path="status" cssClass="form-control">
                    <form:option value="0">Disable</form:option>
                    <form:option value="1">Enable</form:option>
                </form:select>
                <br>
                <form:input path="multipartFile" type="file" ></form:input>
                <br>
                <form:hidden path="image"></form:hidden>
                <button type="submit" class="btn btn-success">Save</button>
            </form:form>
        </div>
    </div>
</div>
<c:import url="/template/admin/footer.jsp"></c:import>
</body>
</html>
