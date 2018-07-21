<%-- 
    Document   : delete
    Created on : Dec 10, 2016, 12:29:43 AM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h2>Are you sure to delete ${requestScope.UserInfo.username} ?</h2>
        <form method="post" action="DeleteServlet?action=DeleteConfirmed">

            <!--<label>User name</label><br/>-->
            <!--<input type="text" value="${requestScope.UserInfo.username}" readonly="true" disabled class="form-control" /><br/>-->
            <input type="hidden" name="username" value="${requestScope.UserInfo.username}" /><br/><br/>

            <input type="submit" value="Delete" class="btn btn-danger" />

        </form>
        <br/>
        <a href="SelectAllServlet">Back to list</a>

    </body>
</html>
