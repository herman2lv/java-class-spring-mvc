<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <title>Login</title>
</head>
<body>
<ul>
    <li><a href="/">Home</a></li>
</ul>
<h1>Login</h1>
<form class="login-form" action="/login" method="post">
    <label>Login: <input name="login" type="text"></label>
    <label>Password: <input name="password" type="password"></label>
    <button>Login</button>
</form>
</body>
</html>
