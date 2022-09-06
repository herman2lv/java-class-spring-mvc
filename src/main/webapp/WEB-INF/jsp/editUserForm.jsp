<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <title>Edit User</title>
</head>
<body>
<ul>
    <li><a href="${pageContext.request.contextPath}">Home</a></li>
</ul>
<h1>Edit User</h1>
<form class="login-form" action="${pageContext.request.contextPath}/users/edit/${user.id}" method="post">
    <label>Login: <input name="login" type="text" value="${user.login}"></label>
    <label>Password: <input name="password" type="text" value="${user.password}"></label>
    <button>Save</button>
</form>
</body>
</html>
