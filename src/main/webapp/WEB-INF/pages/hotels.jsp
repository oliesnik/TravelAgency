<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer Manager</title>
</head>
<body>
<div align="center">
    <h2>Hotels</h2>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Hotel Name</th>
            <th>Country</th>
        </tr>
        <c:forEach items="${hotels}" var="hotel">
            <tr>
                <td>${hotel.id}</td>
                <td>${hotel.name}</td>
                <td>${hotel.country}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>