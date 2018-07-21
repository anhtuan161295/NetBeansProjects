<%-- 
    Document   : login
    Created on : Jan 6, 2017, 2:45:27 PM
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
        <h1>Hello World!</h1>
        <s:if test="hasActionErrors()" >
            <s:actionerror />
        </s:if>
        <s:if test="hasActionMessages()" >
            <s:actionmessage />
        </s:if>
        
        <s:form method="post" action="loginUser" >
            <s:textfield name="username" label="Input user name" />
            <s:submit value="Login" />
        </s:form>
    </body>
</html>
