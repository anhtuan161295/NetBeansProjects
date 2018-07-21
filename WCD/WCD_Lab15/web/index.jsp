<%-- 
    Document   : index
    Created on : Dec 26, 2016, 2:38:59 PM
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
            response.sendRedirect("SelectAllServlet");
            if (request.isUserInRole("manager")) {
        %>
        <h2>Hiển thị chức năng insert, update, delete, select</h2>
        <%
        } else {
        %>
        <h2>Hiển thị xem danh sách</h2>
        <%
            }
        %>
    </body>
</html>
