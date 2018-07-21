<%-- 
    Document   : listUser
    Created on : Dec 9, 2016, 4:16:46 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Users</h1>
        <a href="insert.jsp">Add User</a><br/><br/>
        <table border="1" cellspacing="0" cellpadding="10" >
            <tr>
                <th>User name</th>
                <th>Full name</th>
                <th>Level</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${requestScope.listUsers}" var="user" >
                <tr>
                    <td><c:out value="${user.username}"></c:out></td>
                    <td><c:out value="${user.fullname}"></c:out></td>
                    <td  align="center" ><c:out value="${user.level}"></c:out></td>



                        <td>
                            <a style="text-decoration-line: none" href="UpdateData1Servlet?username=${user.username}">Update</a> |
                        <a style="text-decoration-line: none" href="DeleteData1Servlet?username=${user.username}">Delete</a>

                    </td>
                </tr>

            </c:forEach>

        </table>
    </body>
</html>
