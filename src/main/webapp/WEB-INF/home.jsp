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
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2 style="align-content: center">HOME PAGE</h2>

<h1>Thanks for signing up with us!</h1>
<h2>You provided the following data:</h2>
<p><strong>First Name: </strong> ${firstname}</p>
<p><strong>Last Name: </strong> ${lastname}</p>
<p><strong>Email: </strong>${email}</p>
<br/>
<br/>
<tr>
    <td>${user.id}</td>
    <td><c:out value="${user.login}"/></td>
    <td>${user.pass}</td>
</tr>
<br/>

<form method="get" action="">
    <input type="hidden" name="command" value="Add">
    <label>id</label> <input type="text" name="id"><br/>
    <label>login</label> <input type="text"  name="login"><br/>
    <label>pass</label> <input type="text"  name="pass"><br/>
    <a href="${pageContext.request.contextPath}/home"><button type="submit">Add</button></a>
    <br/>

</form>
</body>
</html>
