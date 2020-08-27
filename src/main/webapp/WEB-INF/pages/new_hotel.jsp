<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Hotel</title>
</head>
<body>
<div align="center">
    <h2>New Hotel</h2>
    <form:form action="/saveHotel" method="post" modelAttribute="hotel">
        <table border="0" cellpadding="5">
            <tr>
                <td>Hotel Name: </td>
                <td><form:input path="name" /></td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>