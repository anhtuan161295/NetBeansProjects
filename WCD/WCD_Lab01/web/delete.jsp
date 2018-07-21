<%-- 
    Document   : delete
    Created on : Dec 5, 2016, 9:49:36 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="Delete">
            <label>Are you sure to delete this ?</label><br/>
            <input type="text" name="username" value="${param.username}" hidden="true" />
            ${param.username} <br/>
            <input type="submit" value="Delete" />
        </form>
        <a href="javascript:history.go(-1)" >Back to list</a>
    </body>
</html>
