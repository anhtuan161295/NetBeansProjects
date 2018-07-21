<%-- 
    Document   : login
    Created on : Feb 10, 2017, 3:40:28 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <h4 style="color: red">${error_MSG}</h4>
        <form method="post" action="LoginServlet" >
            User name: <br/>
            <input type="text" name="id" required="true" /><br/>
            Password: <br/>
            <input type="password" name="password" required="true" /><br/><br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
