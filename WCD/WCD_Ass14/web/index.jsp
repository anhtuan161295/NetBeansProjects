<%-- 
    Document   : index
    Created on : Dec 24, 2016, 8:48:20 PM
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
         <a href="ChangeLanguageServlet?language=en_US">English</a>
        <a href="ChangeLanguageServlet?language=vi_VN">Tiếng Việt</a>
        <h3>Locale of ${country}</h3>
        
        <%
        response.sendRedirect("SelectAllServlet");
        %>
    </body>
</html>
