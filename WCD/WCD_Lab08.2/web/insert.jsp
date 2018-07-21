<%-- 
    Document   : insert
    Created on : Dec 14, 2016, 3:16:16 PM
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
        <form method="post" action="InsertDataServlet">

            <label>User name</label><br/>
            <input type="text" name="username" placeholder="User name"  /><br/>
            <label>Password</label><br/>
            <input type="text" name="password" placeholder="Password" /><br/>
            <label>Full name</label><br/>
            <input type="text" name="fullname" placeholder="Full name"  /><br/>
            <label>Level</label><br/>
            <input type="text" name="level" placeholder="Level"  /><br/><br/>
            <input type="submit" value="Register" />

        </form>
        <br/>
        <a href="DisplayDataServlet">Back to list</a>

    </body>
</html>
