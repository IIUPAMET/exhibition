

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resouces/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resouces/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resouces/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resouces/css/style-responsive.css" rel="stylesheet" />
    <!-- font icon -->
    <link href="${pageContext.request.contextPath}/resouces/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resouces/css/font-awesome.min.css" rel="stylesheet" />

    <script src="${pageContext.request.contextPath}/resouces/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resouces/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resouces/js/scripts.js"></script>
    <script src="${pageContext.request.contextPath}/resouces/js/jquery.scrollTo.min.js"></script>
    <script src="${pageContext.request.contextPath}/resouces/js/jquery.nicescroll.js" type="text/javascript"></script>

    <meta charset="UTF-8">
    <title>LogIn - Page</title>
</head>
<body>

<div class="container">

    <form class="login-form" method="post" action="/exhib/login">
        <div class="login-wrap">
            <p class="login-img"><i class="icon_lock_alt"></i></p>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_profile"></i></span>
                <input type="text" class="form-control" placeholder="Username" autofocus>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input type="password" class="form-control" placeholder="Password">
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
            <button class="btn btn-info btn-lg btn-block" formaction="${pageContext.request.contextPath}/singup.jsp" type="submit">Signup</button>
            <button class="btn btn-info btn-lg btn-block" formaction="${pageContext.request.contextPath}/exhib/guest" type="submit">Start as Guest</button>
        </div>
    </form>
</div>
</body>
</html>