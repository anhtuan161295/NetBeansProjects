<%-- 
    Document   : success
    Created on : Dec 30, 2016, 2:57:46 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login success!</h1>
        <h2>You have successfully login </h2>
        <h2>Your user name: <bean:write name="LoginForm" property="username" /></h2>
        <h2>Your password: <bean:write name="LoginForm" property="password" /></h2>
        <a href="/GetAll.action" >Display list</a>
    </body>
</html>
