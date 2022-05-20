<%--
  Created by IntelliJ IDEA.
  User: chuon
  Date: 5/20/2022
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<form method="post">
        <h1>${requestScope["product"].getId()}</h1>
       <h1>${requestScope["product"].getName()}</h1>
        <h1>${requestScope["Product"].getPrice}</h1>
</form>
</body>
</html>
