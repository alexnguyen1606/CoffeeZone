<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/27/2019
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${USERNAME==null}"><c:redirect url="/login"></c:redirect></c:if>
<html>
<head>
    <title>Coffee Zone</title>
    <c:import url="/template/bootstrap.jsp"></c:import>
</head>
<body>
<jsp:include page="/template/admin/header.jsp"></jsp:include>
<div >
    <div class="row">
        <jsp:include page="/template/admin/menu-admin.jsp"></jsp:include>
        <div class="col-lg-10">
        <table class="table-hover table table-striped" id="table">
            <thead>
            <tr>
                <th>Code</th>
                <th>Total Price</th>
                <th>Date</th>
                <th>Status</th>
                <th>Tool</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderProcess}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.totalMoney}</td>
                    <td>${order.createdDate}</td>
                    <td><c:if test="${order.status == true}"><div class="alert alert-success">Đã xử lý</div></c:if>
                        <c:if test="${order.status != true}"><div class="alert alert-danger">Chưa xử lý</div></c:if></td>
                    <td><a href="<c:url value="/admin/orderprocessing/detail/${order.id}"/>">Detail</a></td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</div>
<jsp:include page="/template/admin/footer.jsp"></jsp:include>
<jsp:include page="/template/JQueryLib/datatables.jsp"></jsp:include>
<script>
    $(document).ready(function () {
        $('#table').DataTable({
            "ordering": false,
            "bLengthChange": false
        });
    })
</script>
</body>
</html>
