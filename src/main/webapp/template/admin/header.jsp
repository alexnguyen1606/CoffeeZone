<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/template/common.jsp"/>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand " href="/">Coffee Zone</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto" >
                <li class="nav-item"><a class="nav-link" href="<c:url value="/admin"/>" >Quản lý</a> </li>
                <c:if test="${FULLNAME != null}"><li class="nav-item"><a class="nav-link">${FULLNAME}</a></li>
                    <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>