<%-- 
    Document   : login
    Created on : Dec 30, 2016, 2:50:34 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <html:form action="/login" >
            User name: <br/>
            <html:text property="username" /> <br/>
            Password: <br/>
            <html:text property="password" /> <br/>
            <html:submit value="Login" />
        </html:form>
        <bean:write name="LoginForm" property="error" filter="false" /><br/>

    </body>
</html>
