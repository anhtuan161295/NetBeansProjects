<%-- 
    Document   : home.jsp
    Created on : Feb 10, 2017, 3:42:59 PM
    Author     : QQ
--%>

<%@page import="org.w3c.dom.NodeList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        + <a href="insert.jsp" >Add new employee</a> <br/>
        + <a href="delete1.jsp" >Delete employee</a> <br/>
        + <a href="update1.jsp" >Update employee</a> <br/><br/>
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
//                    NodeList empList = (NodeList) request.getAttribute("list");
//                    for (int i = 0; i < empList.getLength(); i++) {
//                        NodeList emp = empList.item(i).getChildNodes();
//                        String id = empList.item(i).getAttributes().getNamedItem("id").getNodeValue();

                %>
                <c:forEach items="${list}" var="emp" >
                <tr>
                    <td><c:out value="${emp.id}" /></td>
                    <td>${emp.name}</td>
                    <td>${emp.age}</td>
                    <td>${emp.gender}</td>
                    <td>${emp.role}</td>
                    <td>
                        <a href="EditBook?code=">Edit</a>
                        <a href="DeleteBook?code=" 
                           onclick="return confirm('Are you sure that you want to delete this book ?')" >Delete</a>
                    </td>
                </tr>
                </c:forEach>
                <%                    
//                }
                %>

            </tbody>
    </body>
</html>
