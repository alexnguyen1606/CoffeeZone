<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/25/2019
  Time: 7:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Zone</title>
    <jsp:include page="/template/bootstrap.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="<c:url value="/template/css/loginpage.css"/> ">
</head>
<body>
<c:import url="/template/header.jsp"></c:import>
<div class="container">
    <div class="row">
        <div class="col-lg-9">
            <c:if test="${sessionScope.totalPrice != 0}">
                <h3>Recently added items (<c:out value="${sessionScope.numberOfItem}"/>)</h3>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Number Item</th>
                    <th>Price</th>
                    <th>Tool</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.cartItems}" var="item">
                   <tr>
                       <td>${item.value.product.name}</td>
                       <td>${item.value.quantity}</td>
                       <td>${item.value.product.price} VNĐ</td>
                       <td><a href="/cart/add?id=${item.value.product.id}"><i class="fa fa-plus fa-2x" style="color:#6394F8;"></i></a>
                           <a href="/cart/sub/${item.value.product.id}"><i class="fa fa-minus fa-2x" style="color: #ABB0BE"></i></a>
                           <a href="/cart/remove/${item.value.product.id}"><i class="fa fa-window-close fa-2x" style="color: red"></i></a>
                       </td>
                   </tr>
                </c:forEach>
                </tbody>
            </table>
                <h4 class="">Totol Price:${sessionScope.totalPrice}VNĐ</h4>
                <br>
                <a class="btn btn-success" href="/checkout/formInfo">Checkout</a>
            </c:if>
        </div>
    </div>
</div>
<script>
    function checkout() {
        var user_choice=window.confirm("Have you ever purchased here yet ?");
        if (user_choice==true){
            window.location="/checkout";
        }
        else {
            window.location="/checkout/formInfo";
        }
    }
</script>
<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>
