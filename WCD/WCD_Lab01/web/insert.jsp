<%-- 
    Document   : insert
    Created on : Dec 5, 2016, 2:59:21 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="Insert">
            <label>User name</label><br/>
            <input type="text" name="username" /><br/>
            <label>Password</label><br/>
            <input type="text" name="password" /><br/>
            <label>Full name</label><br/>
            <input type="text" name="fullname" /><br/>
            <label>Email</label><br/>
            <input type="text" name="email" /><br/>
            <input type="submit" value="Add new" />
        </form>
    </body>
</html>
