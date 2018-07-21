<%-- 
    Document   : update.jsp
    Created on : Dec 9, 2016, 7:12:49 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" >
            <div class="col-xs-4" ></div>
            <div class="col-xs-4" >
                <h1>Edit user</h1>
                <form method="post" action="UserController?action=UpdateConfirmed">

                    <label>User name</label><br/>
                    <input type="text" value="${requestScope.UserInfo.username}" readonly="true" disabled class="form-control"/><br/>
                    <input type="hidden" name="username" value="${requestScope.UserInfo.username}" /><br/>
                    <label>Password</label><br/>
                    <input type="text" name="newPassword" value="${requestScope.UserInfo.password}" class="form-control" /><br/>
                    <label>Full name</label><br/>
                    <input type="text" name="newFullname" value="${requestScope.UserInfo.fullname}" class="form-control" /><br/>
                    <a href="UserController">Back to list</a>
                    <div class="pull-right" >
                        <input type="submit" value="Save" class="btn btn-primary" />
                    </div>
                </form>
                <br/>
            </div>
        </div>
    </body>
</html>
