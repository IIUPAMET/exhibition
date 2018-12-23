<%--
  Created by IntelliJ IDEA.
  User: Mykola
  Date: 13.12.2018
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Page</title>
</head>
<body>

<%@include file="/WEB-INF/header.jsp" %>

<section id="main-content">
    <section class="wrapper">
        <section class="panel">
            <header class="panel-heading">
                Form Elements
            </header>
            <div class="panel-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Exhibition Name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="Exhibition Name" name="exhibition_name">
                        </div>

                        <label class="col-sm-2 control-label">Start Date</label>
                        <div class="col-sm-10">
                            <input id="dp1" type="text" value="28-10-2013" size="16" class="form-control"
                                   name="start_date">
                        </div>

                        <label class="col-sm-2 control-label">End Date</label>
                        <div class="col-sm-10">
                            <input id="dp2" type="text" value="28-10-2013" size="16" class="form-control"
                                   name="end_date">
                        </div>

                        <label class="col-sm-2 control-label">Exhibition Theme</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="Exhibition Theme" name="theme">
                        </div>

                        <label class="col-sm-2 control-label">Exhibition Author</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="Exhibition Author" name="author">
                        </div>

                        <label class="col-sm-2 control-label">Exhibition numOfTickets</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="numOfTickets" name="numoftickets">
                        </div>

                        <label class="control-label col-sm-2">Description</label>
                        <div class="col-sm-10">
                            <textarea class="form-control ckeditor" name="description" rows="6"></textarea>
                        </div>
                    </div>
                    <button class="btn btn-success" formaction="${pageContext.request.contextPath}/exhib/admin/create">Success</button>
                </form>
            </div>
        </section>
    </section>
</section>

</body>
</html>
