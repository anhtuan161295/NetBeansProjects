<%-- 
    Document   : index
    Created on : Jan 13, 2017, 7:16:23 PM
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
        <jsp:forward page="/EmployeeServlet?action=list" />
    </body>
</html>
