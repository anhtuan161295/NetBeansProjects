<%-- 
    Document   : register
    Created on : Nov 11, 2016, 4:18:27 PM
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
        <form name="RegisterForm" method="POST" action="checkRegister.jsp">
            Username: <br>
            <input type="text" name="username" value="" /><br>
            Password: <br>
            <input type="text" name="password" value="" /><br>
            <input type="submit" value="Register" />
        </form>
    </body>
</html>
