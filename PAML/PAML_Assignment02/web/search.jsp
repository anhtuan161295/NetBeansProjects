<%-- 
    Document   : search
    Created on : Jan 13, 2017, 7:03:20 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="EmployeeServlet?action=list" >Back</a>
        <h1>List of book</h1>
        <table border="1" cellspacing="0" cellpadding="3" >
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listSearch}" var="emp" >
                    <tr>
                        <td><c:out value="${emp.id}" /></td>
                        <td><c:out value="${emp.name}" /></td>
                        <td><c:out value="${emp.age}" /></td>
                        <td><c:out value="${emp.gender}" /></td>
                        <td><c:out value="${emp.role}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
