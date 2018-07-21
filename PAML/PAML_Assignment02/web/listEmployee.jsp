<%-- 
    Document   : listEmployee
    Created on : Jan 13, 2017, 6:56:02 PM
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
        <form action="EmployeeServlet" >
            <select id="action" name="action" >
                <option value="id" >Search by id</option>
                <option value="name" >Search by name</option>
            </select>
            <input type="text" name="idText" />
            <input type="submit" value="Search" />
        </form>
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
                <c:forEach items="${list}" var="emp" >
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
