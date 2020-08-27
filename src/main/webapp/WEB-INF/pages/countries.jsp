<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer Manager</title>
</head>
<body>
<div align="center">
    <h2>Countries</h2>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Country</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${countries}" var="country">
            <tr>
                <td>${country.id}</td>
                <td>${country.name}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/countries/delete?id=${country.id}">Delete</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/hotelsByCountry?id=${country.id}">View Hotels</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>