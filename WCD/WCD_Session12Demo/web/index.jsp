<%-- 
    Document   : index
    Created on : Dec 19, 2016, 2:18:36 PM
    Author     : QQ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource 
            driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
            url="jdbc:sqlserver://localhost:1433; 
            DatabaseName=test;" 
            user="sa" 
            password="123456" 
            var = "conn" 

            />
        <sql:query dataSource="${conn}" var="users" >
            Select * from [Users]
        </sql:query>

        <h1>List of users</h1>
        <table border="1" cellspacing="0">
            <tr>
                <th>User name</th>
                <th>Full name</th>
                <th>Level</th>
            </tr>
            <c:forEach items="${users.rows}" var="row" >
                <tr>
                    <td><c:out value="${row.username}" /> </td>
                    <td><c:out value="${row.fullname}" /> </td>
                    <td><c:out value="${row.level}" /> </td>
                </tr>
            </c:forEach>


        </table>
    </body>
</html>
