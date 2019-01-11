<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>


<head>

    <link href="${pageContext.request.contextPath}/resouces/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resouces/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resouces/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resouces/css/style-responsive.css" rel="stylesheet"/>

    <!-- font icon -->
    <link href="${pageContext.request.contextPath}/resouces/css/elegant-icons-style.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resouces/css/font-awesome.min.css" rel="stylesheet"/>

    <script src="${pageContext.request.contextPath}/resouces/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resouces/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resouces/js/jquery.scrollTo.min.js"></script>
    <script src="${pageContext.request.contextPath}/resouces/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resouces/js/scripts.js"></script>


</head>
<!--header start-->

<header class="header dark-bg">

    <!--logo start-->
    <a href="${pageContext.request.contextPath}/exhib/home" class="logo">Ex <span class="lite">hibition</span></a>
    <!--logo end-->

    <div class="nav search-row" id="top_menu">
        <!--  search form start -->
        <ul class="nav top-menu">
            <li>
                <form class="navbar-form">
                    <input class="form-control" placeholder="Search" type="text">
                </form>
            </li>
        </ul>
        <!--  search form end -->
    </div>

    <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <span class="username"><fmt:message key="input.login"/></span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu extended notification">

                    <div class="log-arrow-up"></div>
                    <li>
                        <a href="?sessionLocale=en"><fmt:message key="lang.en"/></a></li>
                    <li>
                        <a href="?sessionLocale=ua"><fmt:message key="lang.ua"/></a></li>
                </ul>
            </li>
            <!-- user login dropdown start-->
            <c:if test="${not empty sessionScope.user}">
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" src="img/avatar1_small.jpg">
                            </span>
                        <span class="username">${user.nameUA}</span>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li class="eborder-top">
                            <c:if test="${sessionScope.user.role == ('USER')}">
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/exhib/user/user"><fmt:message key="input.wish.list"/></a></td>
                            </c:if>
                            <c:if test="${sessionScope.user.role == 'ADMIN'}">
                                <a class="btn btn-primary"
                                   href="${pageContext.request.contextPath}/exhib/admin/createexhibition"><fmt:message key="input.create.exhibition"/></a></td>
                            </c:if>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/exhib/logout"><fmt:message key="input.logout"/></a></li>
                    </ul>
                </li>
            </c:if>
        </ul>
    </div>
</header>
<!--header end-->