<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<c:if test="${USERNAME==null}"><c:redirect url="/login"></c:redirect></c:if>--%>
<c:if test="${cookie.USERNAME.value==null}"><c:redirect url="/login"></c:redirect></c:if>
<html>
<head>
    <title>Coffee Zone</title>
    <c:import url="/template/bootstrap.jsp"></c:import>
</head>
<body>
<c:import url="/template/admin/header.jsp"></c:import>

<div >
    <div class="row">
        <jsp:include page="/template/admin/menu-admin.jsp"></jsp:include>
    </div>
</div>
<c:import url="/template/admin/footer.jsp"></c:import>
<c:import url="/template/JQueryLib/jquerylibs.jsp"></c:import>
</body>
</html>
