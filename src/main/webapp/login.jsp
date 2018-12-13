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

<form method="post" action="${pageContext.request.contextPath}/exhib/login">

    <input type="text" name="name"><br/>
    <input type="password" name="pass"><br/><br/>
    <input class="button" type="submit" value="Войти">

</form>

</body>
</html>
