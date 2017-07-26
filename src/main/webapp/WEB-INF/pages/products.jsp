<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 23/07/2017
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<a href="<c:url value="/"/>">Back to main menu</a>

<br/>
<br/>
<h1>Products list</h1>

<c:if test="${!empty listProducts}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Producer</th>
            <th width="120">Price</th>
            <th width="120">Description</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listProducts}" var="product">
            <tr>
                <td>${product.id}</td>
                <td><a href="/productData/${product.id}" target="_blank">${product.title}</a></td>
                <td>${product.producer}</td>
                <td>${product.price}</td>
                <td><a href="<c:url value="/edit/${product.id}"/>">Edit</a></td>
                <td><a href="<c:url value="/remove/${product.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>

<c:url var="addAction" value="/products/add"/>
<form:form action="${addAction}" commandName="product">
    <table>
        <c:if test="${!empty product.bookTitle}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>

        </c:if>
        <tr>
            <td>
                <form:label path="title">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="title"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="producer">
                    <spring:message text="Author"/>
                </form:label>
            </td>
            <td>
                <form:input path="producer"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr><tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty product.title}">
                    <input type="submit" value="<spring:message text="Edit book"/>"/>
                </c:if>
                <c:if test="${empty product.title}">
                    <input type="submit" value="<spring:message text="Add book"/>"/>
                </c:if>

            </td>
        </tr>

    </table>
</form:form>

</body>
</html>
