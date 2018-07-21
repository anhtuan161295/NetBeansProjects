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
        <h1>Hello World!</h1>
        <h2>Confirm delete ?</h2>
        <form method="post" action="DeleteData2Servlet">
            
            <label>User name</label><br/>
            <input type="text" value="${requestScope.UserInfo.username}" readonly="true" disabled/><br/>
            <input type="hidden" name="username" value="${requestScope.UserInfo.username}" /><br/>
            <input type="submit" value="Delete" />

        </form>
        <br/>
        <a href="DisplayDataServlet">Back to list</a>
    </body>
</html>
