<%-- 
    Document   : update.jsp
    Created on : Dec 9, 2016, 7:12:49 PM
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
        <h1>Edit user</h1>
        <c:form action="UpdateUser" >
            <c:textfield name="userUpdate.username" label="User name" />
            <c:textfield name="userUpdate.password" label="Password" />
            <c:textfield name="userUpdate.fullname" label="Full name" />
            <c:textfield name="userUpdate.level" label="Level" />
            <c:submit value="Save" />
        </c:form>
        <br/>
        <a href="Display" >Back to list</a>
    </body>
</html>
