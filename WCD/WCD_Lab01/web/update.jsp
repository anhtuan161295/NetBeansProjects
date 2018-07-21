<%-- 
    Document   : update
    Created on : Dec 5, 2016, 8:37:42 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="Update">
            <label>User name</label><br/>
            <input type="text" name="username" value="${param.username}" readonly="true" /><br/>
            <label>Password</label><br/>
            <input type="text" name="password" value="${param.password}" /><br/>
            <label>Full name</label><br/>
            <input type="text" name="fullname" value="${param.fullname}" /><br/>
            <label>Email</label><br/>
            <input type="text" name="email" value="${param.email}" /><br/>
            <input type="submit" value="Update" />
        </form>
            <a href="javascript:history.go(-1)" >Back to list</a>

    </body>
</html>
