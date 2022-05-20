<%--
  Created by IntelliJ IDEA.
  User: chuon
  Date: 5/19/2022
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>danh sách</h1>
<a href="/ProductServlet?action=create">Tạo mới sản phẩm</a>
<c:forEach items="${danhSach}" var="sanPham" >
    <h3>${sanPham.id},${sanPham.name},${sanPham.price} , <a href="/ProductServlet?action=edit&id=${sanPham.id}">Sửa</a>,
        <a href="/ProductServlet?action=delete&id=${sanPham.id}">Xóa</a>,
        <a href="/ProductServlet?action=view&id=${sanPham.id}">Xem</a></h3>
</c:forEach>
</body>
</html>
