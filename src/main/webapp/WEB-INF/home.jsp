<%--
  Created by IntelliJ IDEA.
  User: Mykola
  Date: 02.12.2018
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html lang="${sessionScope.lang}">
<head>
    <title>User</title>
</head>
<!-- container section start -->
<section id="container" class="">
    <%@include file="/WEB-INF/header.jsp" %>

    <section id="main-content">
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Advanced Table
                        </header>

                        <table class="table table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th><i class="icon_profile"></i> id</th>
                                <th><i class="icon_calendar"></i> Start Date</th>
                                <th><i class="icon_mail_alt"></i> End Date</th>
                                <th><i class="icon_pin_alt"></i> Name</th>
                                <th><i class="icon_mobile"></i> Theme</th>
                                <th><i class="icon_cogs"></i> Author</th>
                                <c:if test="${sessionScope.user.role == ('USER')}">
                                    <th><i class="icon_cogs"></i> Action</th>
                                </c:if>
                            </tr>
                            <c:forEach items="${requestScope.exhibitions}" var="exhibition">
                                <tr>
                                    <form method="post" action="${pageContext.request.contextPath}/exhib/user/addwish">
                                        <td><c:out value="${exhibition.id}"/></td>
                                        <td><c:out value="${exhibition.startDate}"/></td>
                                        <td><c:out value="${exhibition.endDate}"/></td>
                                        <td><c:out value="${exhibition.name}"/></td>
                                        <td><c:out value="${exhibition.thema}"/></td>
                                        <td><c:out value="${exhibition.author}"/></td>

                                        <c:if test="${sessionScope.user.role == ('USER')}">
                                            <c:choose>
                                                <c:when test="${exhibition.id eq wishlist[exhibition.id]}">
                                                    <td>
                                                        buying
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>
                                                        <button type="submit" name="addwish" value="${exhibition.id}">
                                                            add
                                                        </button>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>

                                        <c:if test="${sessionScope.user.role == 'ADMIN'}">
                                            <td>
                                                <div class="btn-group">
                                                    <a class="btn btn-primary" href="#"><i
                                                            class="icon_plus_alt2"></i></a>
                                                    <a class="btn btn-success" href="#"><i class="icon_check_alt2"></i></a>
                                                    <a class="btn btn-danger" href="#"><i
                                                            class="icon_close_alt2"></i></a>
                                                </div>
                                            </td>
                                        </c:if>
                                    </form>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <%--For displaying Previous link except for the 1st page --%>
                        <c:if test="${currentPage != 1}">
                            <td><a href="${pageContext.request.contextPath}/exhib/home?page=${currentPage - 1}">Previous</a></td>
                        </c:if>
                        <%--For displaying Page numbers.
                            The when condition does not display a link for the current page--%>
                        <table border="1" cellpadding="5" cellspacing="5">
                            <tr>
                                <c:forEach begin="1" end="${noOfPages}" var="i">
                                    <c:choose>
                                        <c:when test="${currentPage eq i}">
                                            <td>${i}</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><a href="${pageContext.request.contextPath}/exhib/home?page=${i}">${i}</a></td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </tr>
                        </table>

                        <%--For displaying Next link --%>
                        <c:if test="${currentPage lt noOfPages}">
                            <td><a href="${pageContext.request.contextPath}/exhib/home?page=${currentPage + 1}">Next</a></td>
                        </c:if>
                    </section>
                </div>
            </div>
            <c:if test="${sessionScope.user.role == ('USER')}">
                <p>This will be displayed only if the user has the role "USER".</p>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/exhib/user/user"
                   title="Bootstrap 3 themes generator">Primary</a></td>
            </c:if>
            <c:if test="${sessionScope.user.role == 'ADMIN'}">
                <p>This will be displayed only if the user has the role "ADMIN".</p>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/exhib/admin/createexhibition"
                   title="Bootstrap 3 themes generator">Primary</a></td>
            </c:if>
        </section>
    </section>

</section>
</body>
</html>
