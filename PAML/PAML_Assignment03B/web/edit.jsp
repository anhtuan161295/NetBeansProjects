<%-- 
    Document   : edit
    Created on : Feb 7, 2017, 1:13:21 AM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Book</title>
    </head>
    <body>
        <h1>Edit Book</h1>
        <form method="post" action="EditBook">
            Code: <br/>
            <input type="text" name="code" readonly value="<%= request.getAttribute("code")%>"/><br/>
            Title: <br/>
            <input type="text" name="title"  value="<%= request.getAttribute("title")%>"/><br/>
            Price: <br/>
            <input type="text" name="price"  value="<%= request.getAttribute("price")%>"/><br/>
            Author: <br/>
            <input type="text" name="author"  value="<%= request.getAttribute("author")%>"/><br/>
            Edition: <br/>
            <input type="text" name="edition" value="<%= request.getAttribute("edition")%>"/><br/>
            <input type="submit" value="Edit" />
        </form>
    </body>
</html>
