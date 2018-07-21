<%-- 
    Document   : listUsers
    Created on : Dec 9, 2016, 4:16:46 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="ListUser"><h1>List of Users</h1></a>
        <a href="insert.jsp">Add User</a>
        <h1>Hello: 
            <a href="Logout">Logout</a> </h1>
        <table border="1" cellspacing="0" >
            <tr>
                <th>User name</th>
                <th>Full name</th>
                <th>Level</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="#{userMB.listUsers()}" var="user" >
                <tr>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.fullname}" /></td>
                    <td><c:out value="${user.level}" /></td>
                    <td>
                        <a href="GetUser?username=<c:out value="${user.username}" />&action=Update">Update</a> |
                        <a href="GetUser?username=<c:out value="${user.username}" />&action=Delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
