<%-- 
    Document   : success
    Created on : Dec 7, 2016, 3:05:29 PM
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
        <%
            String user = (String) session.getAttribute("user");
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }
        %>
        <h2>Hi: <%= userName%>, login success <br/>
            Your session ID: <%= sessionID%> </h2>
        <h2>Your user name login: <%= user%> </h2>
        <h2><a href="checkout.jsp">Checkout Page</a></h2>
        <form method="post" action="LogoutServlet">
            <input type="submit" value="Log out" />
        </form>

    </body>
</html>
