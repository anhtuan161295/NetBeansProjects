<%-- 
    Document   : checkRegister
    Created on : Nov 11, 2016, 4:23:46 PM
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
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
        <a href="about.jsp">About</a>

        <br>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.isEmpty()) {
                out.print("Username is required.");
            } else if (password.isEmpty()) {
                out.print("Password is required.");
            } else {
                out.print("Register success");
                session.setAttribute("username", username);
                session.setAttribute("password", password);

            }

        %>
    </body>
</html>
