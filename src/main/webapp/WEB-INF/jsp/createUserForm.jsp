<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <title>Create User</title>
</head>
<body>
<ul>
    <li><a href="/">Home</a></li>
</ul>
<h1>Create New User</h1>
<%--Plain JSP way (simplified example):--%>
<%--<c:if test="${requestScope.errors != null}">
    <p style="color: red">Not Valid!</p>
</c:if>
<form class="login-form" action="/users/create" method="post">
    <label>Login: <input name="login" type="text"></label>
    <label>Password: <input name="password" type="text"></label>
    <button>Save</button>
</form>--%>
<%--Using custom Spring tags:--%>
<form:form class="login-form" action="/users/create" method="post" modelAttribute="userDto">
    <form:errors cssClass="error-message" path="login"/>
    <label>Login: <form:input path="login" type="text"/></label>
    <form:errors cssClass="error-message" path="password"/>
    <label>Password: <form:input path="password" type="text"/></label>
    <button>Save</button>
</form:form>
</body>
</html>
