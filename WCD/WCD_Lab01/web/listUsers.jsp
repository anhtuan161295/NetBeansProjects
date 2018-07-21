<%-- 
    Document   : listUsers
    Created on : Dec 5, 2016, 3:25:59 PM
    Author     : QQ
--%>

<%--<%@page import="www.fpt.com.User"%>
<%@page import="java.util.ArrayList"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Users</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String username = session.getAttribute("user").toString();
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }
        %>

        <h2>Hi: <%= username%>, login success <br/>
            Your session ID: <%= sessionID%> 
            <form method="post" action="LogoutServlet">
                <input type="submit" value="Log out" />
            </form>
        </h2>
        <%
            if (username.equals("admin")) {
                out.print("<a href=\"insert.jsp\"  >Add new</a>");
            }
        %>

        <!--<a href="insert.jsp"  >Add new</a>-->
        <table border="1" cellspacing="0">
            <tr>
                <th>User name</th>
                <th>Password</th>
                <th>Full name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${requestScope.listUser}" var="user" >
                <tr>
                    <td><c:out value="${user.username}" ></c:out></td>
                    <td><c:out value="${user.password}" ></c:out></td>
                    <td><c:out value="${user.fullname}" ></c:out></td>
                    <td><c:out value="${user.email}" ></c:out></td>
                        <td>   
                        <c:url value="update.jsp" var="updateURL" >
                            <c:param name="username" value="${user.username}" />
                            <c:param name="password" value="${user.password}" />
                            <c:param name="fullname" value="${user.fullname}" />
                            <c:param name="email" value="${user.email}" />
                        </c:url>
                        <c:url value="delete.jsp" var="deleteURL" >
                            <c:param name="username" value="${user.username}" />
                            <%--<c:param name="password" value="${user.password}" />--%>
                            <%--<c:param name="fullname" value="${user.fullname}" />--%>
                            <%--<c:param name="email" value="${user.email}" />--%>
                        </c:url>
<!--                        <a href="update.jsp?username=${user.username}"  >Update</a> |
                        <a href="delete.jsp?username=${user.username}"  >Delete</a>-->

                        <%
                            if (username.equals("admin")) {
                                out.print("<a href=\"${updateURL}\" >Update</a> |");
                                out.print("<a href=\"${deleteURL}\" >Delete</a>");
                            }
                        %>

                        <!--<a href="${updateURL}" >Update</a> |-->
                        <!--<a href="${deleteURL}" >Delete</a>-->
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <form method="post" action="Search">
            <label>Search by user name</label><br/>
            <input type="text" name="txtSearch"  /> 
            <input type="submit" value="Search" />
        </form>

        <%
//            ArrayList<User> list = new ArrayList<>();
//            if (request.getAttribute("listUser") != null) {
//                list = (ArrayList<User>) request.getAttribute("listUser");
//                for (User user : list) {
//                    out.println(user.getUsername());
//                    out.println("<br/>");
//                }
//            }

        %>



    </body>
</html>
