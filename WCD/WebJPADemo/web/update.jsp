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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Edit user</h1>
        <form method="post" action="UpdateServlet?action=UpdateConfirmed">

            <label>User name</label><br/>
            <input type="text" value="${requestScope.UserInfo.username}" readonly="true" disabled class="form-control"/><br/>
            <input type="hidden" name="username" value="${requestScope.UserInfo.username}" /><br/>
            <label>Password</label><br/>
            <input type="text" name="newPassword" value="${requestScope.UserInfo.password}" class="form-control" /><br/>
            <label>Full name</label><br/>
            <input type="text" name="newFullname" value="${requestScope.UserInfo.fullname}" class="form-control" /><br/><br/>
            <input type="submit" value="Save" class="btn btn-primary" />
        </form>
        <br/>
        <a href="SelectAllServlet">Back to list</a>

    </body>
</html>
