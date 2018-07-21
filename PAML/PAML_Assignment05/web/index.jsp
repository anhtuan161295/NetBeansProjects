<%-- 
    Document   : index
    Created on : Feb 8, 2017, 6:06:07 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Employee List</h1>
        <table border="1" cellspacing="0px" cellpadding="3px">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                %>
                <c:forEach items="${list}" var="item" >
                    <tr>
                        <td><c:out value="${item.id}" /></td>
                        <td><c:out value="${item.name}" /></td>
                        <td><c:out value="${item.age}" /></td>
                        <td><c:out value="${item.gender}" /></td>
                        <td><c:out value="${item.role}" /></td>
                        <td></td>
                    </tr>
                </c:forEach>
                <%
                %>
            </tbody>
        </table>
    </body>
</html>
