<%-- 
    Document   : checkLogin
    Created on : Nov 11, 2016, 4:23:56 PM
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

            String sesUsername = session.getAttribute("username").toString();
            String sesPassword = session.getAttribute("password").toString();
            if (username.equals(sesUsername)) {
                if (password.equals(sesPassword)) {
                    out.print("Login success");
                } else {
                    out.print("Login failed, password incorrect");

                }
            } else {
                out.print("Username incorrect");

            }

        %>
    </body>
</html>
