<%-- 
    Document   : insert
    Created on : Dec 14, 2016, 3:16:16 PM
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
        <h1>Add new user</h1>
        <c:form action="InsertUser" >
            <c:textfield name="user.username" label="User name" />
            <c:textfield name="user.password" label="Password" />
            <c:textfield name="user.fullname" label="Full name" />
            <c:textfield name="user.level" label="Level" />
            <c:submit value="Add User" />
        </c:form>
        <br/>
        <a href="Display" >Back to list</a>
    </body>
</html>
