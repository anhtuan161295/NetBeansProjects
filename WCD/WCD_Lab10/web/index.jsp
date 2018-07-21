<%-- 
    Document   : index
    Created on : Dec 16, 2016, 2:54:01 PM
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
        <%
        response.sendRedirect("UserController");
        %>
    </body>
</html>
