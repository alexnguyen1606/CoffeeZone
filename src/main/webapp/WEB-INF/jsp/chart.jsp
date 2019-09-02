<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/27/2019
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<c:if test="${USERNAME==null}"><c:redirect url="/login"></c:redirect></c:if>--%>
<c:if test="${cookie.USERNAME.value==null}"><c:redirect url="/login"></c:redirect></c:if>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Zone</title>
    <jsp:include page="/template/bootstrap.jsp"></jsp:include>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</head>
<body>
<jsp:include page="/template/admin/header.jsp"></jsp:include>
<div class="row">
    <jsp:include page="/template/admin/menu-admin.jsp"></jsp:include>
    <div class="col-lg-9">
        <div id="chartContainer" style="height: 300px; width: 100%;"></div>
    </div>
</div>
 <script>
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            animationEnabled: true,
            theme: "light2", // "light1", "light2", "dark1", "dark2"
            title:{
                text: "Top Coffee Reserves"
            },
            axisY: {
                title: "Reserves(MMbbl)"
            },
            data: [{
                type: "column",
                showInLegend: true,
                legendMarkerColor: "grey",
                legendText: "MMbbl = VNĐ",
                dataPoints: [
                    <c:forEach var="item" items="${map}">
                    { y: ${item.value}, label: "${item.key}" },
                    </c:forEach>
                    // { y: 300878, label: "Venezuela" },
                    // { y: 266455,  label: "Saudi" },
                    // { y: 169709,  label: "Canada" },
                    // { y: 158400,  label: "Iran" },
                    // { y: 142503,  label: "Iraq" },
                    // { y: 101500, label: "Kuwait" },
                    // { y: 97800,  label: "UAE" },
                    // { y: 80000,  label: "Russia" }
                ]
            }]
        });
        chart.render();
    }
</script>
<jsp:include page="/template/admin/footer.jsp"></jsp:include>
</body>
</html>
