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
                            <fmt:message key="input.exhibition"/>
                        </header>

                        <table class="table table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th><fmt:message key="input.id"/></th>
                                <th><fmt:message key="input.start.date"/></th>
                                <th><fmt:message key="input.end.date"/></th>
                                <th><fmt:message key="input.name"/></th>
                                <th><fmt:message key="input.theme"/></th>
                                <th><fmt:message key="input.author"/></th>
                                <c:if test="${sessionScope.user.role == ('USER')}">
                                    <th><fmt:message key="input.action"/></th>
                                </c:if>
                            </tr>
                            <c:forEach items="${requestScope.exhibitions}" var="exhibition">
                                <tr>
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
                                                    <fmt:message key="input.already.add"/>
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>
                                                    <form method="post"
                                                          action="${pageContext.request.contextPath}/exhib/user/addwish">
                                                        <button type="submit" name="addwish" value="${exhibition.id}">
                                                            <fmt:message key="input.add"/>
                                                        </button>
                                                    </form>
                                                </td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <%--For displaying Previous link except for the 1st page --%>
                        <c:if test="${currentPage != 1}">
                            <td>
                                <a href="${pageContext.request.contextPath}/exhib/home?page=${currentPage - 1}">Previous</a>
                            </td>
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
                                            <td>
                                                <a href="${pageContext.request.contextPath}/exhib/home?page=${i}">${i}</a>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </tr>
                        </table>

                        <%--For displaying Next link --%>
                        <c:if test="${currentPage lt noOfPages}">
                            <td><a href="${pageContext.request.contextPath}/exhib/home?page=${currentPage + 1}">Next</a>
                            </td>
                        </c:if>
                    </section>
                </div>
            </div>
        </section>
    </section>

</section>
</body>
</html>
