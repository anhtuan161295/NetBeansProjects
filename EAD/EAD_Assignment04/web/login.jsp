<%-- 
    Document   : login
    Created on : Feb 20, 2017, 4:18:44 PM
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
        <h1>Login</h1>
        <form method="post" action="LoginServlet">
            Id:<br/>
            <input type="text" name="id" /><br/>
            Password:<br/>
            <input type="password" name="pwd" /><br/><br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
