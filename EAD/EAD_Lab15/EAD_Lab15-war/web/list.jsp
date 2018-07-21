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
        <h1>List of Books</h1>
        <a href="add.jsp">Add new book</a><br/><br/> 
        <form method="post" action="BookServlet?action=search">
            Search by title:
            <input type="text" name="searchTitle" required="true" />
            <input type="submit" value="Search" />
        </form>
        <br/>
        <table border="1" cellspacing="0px" cellpadding="3px">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Author</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="book" >
                    <tr>
                        <td><c:out value="${book.code}" /></td>
                        <td><c:out value="${book.title}" /></td>
                        <td><c:out value="${book.price}" /></td>
                        <td><c:out value="${book.author}" /></td>
                        <td>
                            <a href="BookServlet?code=${book.code}&action=edit">Update</a>
                            |
                            <a href="BookServlet?code=${book.code}&action=delete" 
                               onclick="return confirm('Are you sure to delete this book ?')"   
                               >Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
