<%-- 
    Document   : login
    Created on : Jan 4, 2017, 2:59:50 PM
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
        <h1>Login!</h1>
        <s:if test="hasActionErrors()" >
            <s:actionerror />
        </s:if>
        <s:if test="hasActionMessages()" >
            <s:actionmessage />
        </s:if>

        <s:form action="Login" >
            <s:textfield label="Username" name="username" />
            <s:password label="Password" name="password" />
            <s:submit value="Login" />
        </s:form>
    </body>
</html>
