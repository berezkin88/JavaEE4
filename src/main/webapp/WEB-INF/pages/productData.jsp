<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 23/07/2017
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Data</title>
</head>
<body>
<h1>Product Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Author</th>
        <th width="120">Price</th>
    </tr>
    <tr>
        <td>${product.id}</td>
        <td>${product.bookTitle}</td>
        <td>${product.bookAuthor}</td>
        <td>${product.price}}</td>
    </tr>
</table>
</body>
</html>
