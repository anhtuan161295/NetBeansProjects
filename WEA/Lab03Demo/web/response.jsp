<%-- 
    Document   : response
    Created on : Nov 11, 2016, 3:41:29 PM
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
        <jsp:useBean id="mybean" scope="session" class="test.UserInfo" />
        <jsp:setProperty name="mybean" property="username" value='<%=request.getParameter("username")%>' />
        <h3>Username: <jsp:getProperty name="mybean" property="username" /></h3>
        <jsp:setProperty name="mybean" property="password" value='<%=request.getParameter("password")%>' />
        <h3>Password:  <jsp:getProperty name="mybean" property="password" /></h3>
        <jsp:setProperty name="mybean" property="fullname" value='<%=request.getParameter("fullname")%>' />
        <h3>Full name: <jsp:getProperty name="mybean" property="fullname" /></h3>
        <jsp:setProperty name="mybean" property="email" value='<%=request.getParameter("email")%>' />
        <h3>Email: <jsp:getProperty name="mybean" property="email" /></h3>

    </body>
</html>
