<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<h1>Welcome to Demo App</h1>
<c:if test="${sessionScope.user != null}">
    <h2>Glad to see you again, ${sessionScope.user.login}</h2>
</c:if>
<div>This is a demo application for Java Professional Training Course</div>
<ul>
    <li><a href="/users/getAll">All Users</a></li>
    <c:if test="${sessionScope.user != null}">
        <li><a href="/logout">Logout</a></li>
    </c:if>
    <c:if test="${sessionScope.user == null}">
        <li><a href="/users/create">Register</a></li>
        <li><a href="/login">Login</a></li>
    </c:if>
</ul>
</body>
</html>
