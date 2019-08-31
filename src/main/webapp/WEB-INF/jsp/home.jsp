<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coffee Zone</title>
 <jsp:include page="/template/bootstrap.jsp"></jsp:include>
</head>
<body>
<c:import url="/template/header.jsp"></c:import>

<div class="container">
 <div class="row">
   <div class="col-lg-3">
      <div class="list-group-flush">
       <a href="#" class="list-group-item">Category 1</a>
       <a href="#" class="list-group-item">Category 2</a>
       <a href="#" class="list-group-item">Category 3</a>
      </div>
   </div>
   <div class="col-lg-9">
     <div class="row">
         <c:if test="${not empty products}">
        <c:forEach var="product" items="${products}">
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card h-100">
                        <a href="#"><img class="card-img-top"  src="${product.image}" alt="image"></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="#">${product.name}</a>
                        </h4>
                        <h5>${product.price} VND</h5>
                        <p class="card-text">${product.flavor}</p>
                    </div>
                    <div class="card-footer">
                        <a href="/cart/add?id=${product.id}" class="btn btn-primary" >Add To Cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
         </c:if>
     </div>
   </div>
 </div>
 <%-- /div row--%>
</div>
<%--./ div container--%>
<c:import url="/template/footer.jsp"></c:import>
</body>
</html>