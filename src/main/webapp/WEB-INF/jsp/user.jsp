<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<ul>
    <li><a href="/">Home</a></li>
</ul>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${user.id}</td>
        <td>${user.login}</td>
        <td>${user.password}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
