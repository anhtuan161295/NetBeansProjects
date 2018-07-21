<%-- 
    Document   : list
    Created on : Feb 15, 2017, 4:43:43 PM
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
        <h1>List of users</h1>
        <table border="1" cellspacing="0px" cellpadding="3px">
            <thead>
                <tr>
                    <th>User name</th>
                    <th>Full name</th>
                    <th>Level</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${usersList}" var="user" >
                    <tr>
                        <td><c:out value="${user.username}" /></td>
                        <td><c:out value="${user.fullname}" /></td>
                        <td><c:out value="${user.level}" /></td>
                        <td>
                            <a href="#">Update</a>
                            |
                            <a href="#">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
