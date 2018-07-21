<%-- 
    Document   : login
    Created on : Jan 4, 2017, 2:59:50 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login!</h1>
        <c:form action="Login" >
            <c:textfield label="Username" name="username" />
            <c:password label="Password" name="password" />
            <c:submit label="Login" />
        </c:form>
    </body>
</html>
