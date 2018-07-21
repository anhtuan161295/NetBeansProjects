<%-- 
    Document   : insert
    Created on : Dec 21, 2016, 2:53:38 PM
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
        <h1>Add new User</h1>
        <form action="InsertServlet" method="Post" >
            <input type="text" name="username" placeholder="User name" /><br/>
            <input type="password" name="password" placeholder="Password" /><br/>
            <input type="text" name="fullname" placeholder="Full name" /><br/>
            <input type="number" name="level" placeholder="Level" /><br/><br/>
            <input type="submit" value="Add new" /><br/>
        </form>
        <br/>
        <a href="SelectAllServlet">Back to list</a>

    </body>
</html>
