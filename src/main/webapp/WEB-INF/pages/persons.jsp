<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer Manager</title>
</head>
<body>
<div align="center">
    <h2>Persons</h2>
  
    <h3><a href="/new_person">New Person</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>E-mail</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${persons}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>${person.email}</td>
                <td>${person.role}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/persons/delete?id=${person.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>