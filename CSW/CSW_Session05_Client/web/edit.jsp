<%-- 
    Document   : edit
    Created on : Mar 1, 2017, 6:29:49 PM
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
        <h1>Edit user</h1>
        <form method="post" action="EditServlet">
            User name: <br/>
            <input type="text" name="user" value="${user.username}" readonly="true" required="true" /><br/>
            Password: <br/>
            <input type="password" name="pwd" value="${user.password}" required="true" /><br/>
            Full name: <br/>
            <input type="text" name="fname" value="${user.fullname}" required="true" /><br/>
            Level: <br/>
            <input type="number" name="level" value="${user.level}" required="true" /><br/>
            <br/>
            <input type="submit" value="Save" />

        </form>
    </body>
</html>
