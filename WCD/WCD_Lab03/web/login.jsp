<%-- 
    Document   : login
    Created on : Dec 7, 2016, 2:42:35 PM
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
        <h1>Login Page</h1>
        <form method="post" action="LoginServlet">
            <label>User name:</label><br/>
            <input type="text" name="username" /><br/>
            <label>Password:</label><br/>
            <input type="text" name="password" /><br/><br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
