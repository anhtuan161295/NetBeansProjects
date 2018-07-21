<%-- 
    Document   : index
    Created on : Nov 11, 2016, 3:04:57 PM
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
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
        <a href="about.jsp">About</a>

        <br>
        <form name="UserInput" action="response.jsp">
            <h1>User Information</h1>
            Input user name: <br>
            <input type="text" name="username" value="" /> <br>
            Input password: <br>
            <input type="text" name="password" value="" /> <br>
            Input full name: <br>
            <input type="text" name="fullname" value="" /> <br>
            Input email: <br>
            <input type="text" name="email" value="" /> <br>
            <input type="submit" value="OK" />

        </form>
    </body>
</html>
