<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/27/2019
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<c:if test="${USERNAME==null}"><c:redirect url="/login"></c:redirect></c:if>--%>
<c:if test="${cookie.USERNAME.value==null}"><c:redirect url="/login"></c:redirect></c:if>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Zone</title>
    <jsp:include page="/template/bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/template/admin/header.jsp"></jsp:include>
<div >
    <div class="row">
        <jsp:include page="/template/admin/menu-admin.jsp"></jsp:include>
        <div class="col-lg-9">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Code Product</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price Unit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orderDetails}" var="item">
                <tr>
                    <td>${item.product.id}</td>
                    <td>${item.product.name}</td>
                    <td>${item.quantity}</td>
                    <td>${item.product.price}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <h3>Total Price: ${order.totalMoney}</h3>
            <br>
            <c:if test="${order.status == false}">
                <a class="btn btn-success" href="<c:url value="/admin/orderprocessing/confirm/${order.id}"/>">Confirm</a>
                <a class="btn btn-danger" onclick="return confirm('Are You Sure')" href="<c:url value="/admin/orderprocessing/cancel/${order.id}"/>">Cancel</a>
            </c:if>
        </div>
    </div>
</div>
<jsp:include page="/template/admin/footer.jsp"></jsp:include>
</body>
</html>
