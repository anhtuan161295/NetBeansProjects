<%-- 
    Document   : login
    Created on : Dec 26, 2016, 3:46:14 PM
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
        <form method="post" action="j_security_check">
            User name:<br/>
            <input type="text" name="j_username" /><br/>
            Password:<br/>
            <input type="password" name="j_password" /><br/>
            <input type="submit" value=" Login " />
        </form>
    </body>
</html>
