<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<ul>
    <li><a href="/">Home</a></li>
</ul>
<h1>Error!</h1>
<div>${message != null ? message : 'Something went wrong...'}</div>
</body>
</html>
