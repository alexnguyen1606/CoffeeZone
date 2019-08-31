<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/template/css/shape_color_admin.css"/>" rel="stylesheet">
<div class="col-lg-2">
    <div class="list-group-flush">
        <a href="/admin/product" class="list-group-item ">Danh sách sản phẩm</a>
        <a href="/admin/brand" class="list-group-item ">Danh sách thương hiệu</a>
        <a href="#" class="list-group-item">Danh sách nhân viên</a>
        <a href="/admin/orderprocessing" class="list-group-item">Xử lý đơn hàng</a>
      <a class="list-group-item" href="<c:url value="/admin/chart"/>">Doanh số sản phẩm</a>
    </div>
</div>