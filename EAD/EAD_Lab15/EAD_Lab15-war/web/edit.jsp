<%-- 
    Document   : edit
    Created on : Mar 1, 2017, 6:29:49 PM
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
        <h1>Edit book</h1>
        <form method="post" action="BookServlet?action=update">
            Code: <br/>
            <input type="text" name="code" value="${book.code}" readonly="true" required="true" /><br/>
            Title: <br/>
            <input type="text" name="title" value="${book.title}" required="true" /><br/>
            Price: <br/>
            <input type="number" name="price" value="${book.price}" required="true" min="0" /><br/>
            Author: <br/>
            <input type="text" name="author" value="${book.author}" required="true" /><br/>
            <br/>
            <input type="submit" value="Save" />

        </form>
        <br/>
        <a href="BookServlet?action=list">Back to list</a>

    </body>
</html>
