<%-- 
    Document   : index
    Created on : Dec 14, 2016, 2:18:04 PM
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
        <h1>Hello World!</h1>
        <%
//            String value = config.getServletContext().getInitParameter("One");
//            String value1 = config.getServletContext().getInitParameter("AAA");
//
//            out.println(value);
//            out.println(value1);

        %>
        <form action="register_process.jsp" >
            User name:<br/>
            <input type="text" name="username" /><br/>
            Password:<br/>
            <input type="text" name="password" /><br/>
            Full name:<br/>
            <input type="text" name="fullname" /><br/>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
