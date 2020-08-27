<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Person</title>
</head>
<body>
<div align="center">
    <h2>New Person</h2>
    <form:form action="save" method="post" modelAttribute="person">
        <table border="0" cellpadding="5">
            <tr>
                <td>First Name: </td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>