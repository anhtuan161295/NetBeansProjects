<%-- 
    Document   : register_process
    Created on : Dec 14, 2016, 2:37:12 PM
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
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            String fname = request.getParameter("fullname");

            out.println("Your user name: " + user + "<br>");
            out.println("Your full name: " + fname + "<br>");

        %>
        
        
    </body>
</html>
