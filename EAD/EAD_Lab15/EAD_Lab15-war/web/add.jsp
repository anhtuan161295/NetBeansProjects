<%-- 
    Document   : add
    Created on : Feb 15, 2017, 4:59:17 PM
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
        <h1>Add new book</h1>
        <form method="post" action="BookServlet?action=add">
            Code: <br/>
            <input type="text" name="code" required="true" /><br/>
            Title: <br/>
            <input type="text" name="title" required="true" /><br/>
            Price: <br/>
            <input type="number" name="price" required="true" min="0" /><br/>
            Author: <br/>
            <input type="text" name="author" required="true" /><br/>
            <br/>
            <input type="submit" value="Add new" />

        </form>
        <br/>
        <a href="BookServlet?action=list">Back to list</a>
    </body>
</html>
