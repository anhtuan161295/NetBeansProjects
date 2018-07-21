<%-- 
    Document   : listUsers
    Created on : Dec 9, 2016, 4:16:46 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="Display"><h1>List of Users</h1></a>
        <a href="insert.jsp">Add User</a>
        <table class="table" >
            <tr>
                <th>User name</th>
                <th>Full name</th>
                <th>Level</th>
                <th>Actions</th>
            </tr>
            <s:iterator status="stat" value="list" >
                <tr>
                    <td><s:property value="username" /></td>
                    <td><s:property value="fullname" /></td>
                    <td><s:property value="level" /></td>
                        <td>
                            <a href="GetUser?username=<s:property value="username" />&action=Update">Update</a> |
                        <a href="GetUser?username=<s:property value="username" />&action=Delete">Delete</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
