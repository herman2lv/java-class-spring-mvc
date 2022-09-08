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
<form class="login-form" action="/users/create" method="post">
    <label>Login: <input name="login" type="text"></label>
    <label>Password: <input name="password" type="text"></label>
    <button>Save</button>
</form>
</body>
</html>
