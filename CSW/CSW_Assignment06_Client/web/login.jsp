<%-- 
    Document   : login
    Created on : Mar 13, 2017, 4:59:45 PM
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
            Username:<br/>
            <input type="text" name="username" /><br/>
            Password:<br/>
            <input type="password" name="password" /><br/><br/>
            <input type="submit" value=" Login " />
        </form>
    </body>
</html>
