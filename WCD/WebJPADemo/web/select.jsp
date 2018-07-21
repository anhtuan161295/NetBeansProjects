<%-- 
    Document   : select
    Created on : Dec 21, 2016, 3:14:39 PM
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
        <h1>List of Users</h1>
        <h3><a href="insert.jsp">Add new user</a></h3>
        

        <table class="table" >
            <tr>
                <th>User name</th>
                <th>Full name</th>
                <th>Level</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${listUsers}" var="user" >
                <tr> 
                    <td><c:out value="${user.username}"></c:out></td>
                    <td><c:out value="${user.fullname}"></c:out></td>
                    <td><c:out value="${user.level}"></c:out></td>

                        <td>
                            <a  href="SelectUserServlet?username=${user.username}&action=Update">Update</a>
                        |
                        <a  href="SelectUserServlet?username=${user.username}&action=Delete">Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>
    </body>
</html>
