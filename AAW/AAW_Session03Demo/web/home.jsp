<%-- 
    Document   : home
    Created on : Jan 6, 2017, 2:49:08 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello: <s:property value="username" />
        <h1>Hello: <s:property value="#session.loginId" />
            <a href="logoutUser">Logout</a> </h1>
    </body>
</html>
