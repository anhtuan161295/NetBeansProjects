<%-- 
    Document   : add
    Created on : Feb 15, 2017, 4:59:17 PM
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
        <h1>Add new user</h1>
        <form method="post" action="addUser">
            User name: <br/>
            <input type="text" name="user" required="true" /><br/>
            Password: <br/>
            <input type="password" name="pwd" required="true" /><br/>
            Full name: <br/>
            <input type="text" name="fname" required="true" /><br/>
            Level: <br/>
            <input type="number" name="level" required="true" /><br/>
            <br/>
            <input type="submit" value="Add new" />

        </form>
    </body>
</html>
