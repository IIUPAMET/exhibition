<%--
  Created by IntelliJ IDEA.
  User: Mykola
  Date: 08.12.2018
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="${pageContext.request.contextPath}/resouces/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resouces/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resouces/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resouces/css/style-responsive.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/resouces/js/bootstrap.min.js"></script>


    <meta charset="UTF-8">
    <title>Customer Sign Up</title>
</head>
<body class="login-img3-body">


<div class="container">

    <form class="login-form" action="${pageContext.request.contextPath}/exhib/singup" method="post">
        <div class="login-wrap">
            <p class="login-img"><i class="icon_lock_alt"></i></p>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_profile"></i></span>
                <input type="text" class="form-control" placeholder="Login" name="login" value="${login}" autofocus>
                <br/><b><c:out value='${incorrectMap["login"]}'/></b>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input type="password" class="form-control" placeholder="Password" name="pass" value="${pass}">
                <br/><b><c:out value='${incorrectMap["pass"]}'/></b>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input type="password" class="form-control" placeholder="Repeat password" name="repeatpass" value="${repeatpass}">
                <br/><b><c:out value='${incorrectMap["repeatpass"]}'/></b>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_profile"></i></span>
                <input type="text" class="form-control" placeholder="Ukrainian name" name="ukrname" value="${ukrname}" autofocus>
                <br/><b><c:out value='${incorrectMap["ukrname"]}'/></b>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_profile"></i></span>
                <input type="text" class="form-control" placeholder="English name" name="engname" value="${engname}" autofocus>
                <br/><b><c:out value='${incorrectMap["engname"]}'/></b>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_profile"></i></span>
                <input type="text" class="form-control" placeholder="E-mail" name="email" value="${email}" autofocus>
                <br/><b><c:out value='${incorrectMap["email"]}'/></b>
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="submit">Sing Up</button>
        </div>
    </form>
</div>
</body>
</html>