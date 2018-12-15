<%--
  Created by IntelliJ IDEA.
  User: Mykola
  Date: 02.12.2018
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style-responsive.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <title>LogIn</title>

</head>
<body>

<form method="POST" action="/exhib/j_security_check">
    <table>
        <tr>
            <td colspan="2">Login to the Tomcat-Demo application:</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="j_username"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="j_password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Go"></td>
        </tr>
    </table>
</form>

</body>
</html>
