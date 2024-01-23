<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <title>Users</title>
</head>
<body>
<section>
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Login</th>
            <th></th>
            <th>Actions</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <!-- example of html injection protection -->
                <td><c:out value="${user.login}"/></td>
                <td>
                    <form action="/users/${user.id}" method="get"><input type="submit" value="View"></form>
                </td>
                <td>
                    <form action="/users/edit/${user.id}" method="get"><input type="submit" value="Edit"></form>
                </td>
                <td>
                    <form action="/users/delete/${user.id}" method="post"><input type="submit" value="Delete"></form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
<form action="/users/create" method="get"><input type="submit" value="Create New"></form>
</body>
</html>
