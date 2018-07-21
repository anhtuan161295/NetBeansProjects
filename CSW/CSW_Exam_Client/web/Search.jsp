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
        <h1>Search Book by Title</h1>
        <!--<a href="add.jsp" >Add user</a><br/><br/>-->
        <form method="post" action="SearchServlet">
            Title:
            <input type="text" name="searchTitle" />
            <input type="submit" value=" Search " />
        </form>
        <br/>
        <table border="1" cellspacing="1px" cellpadding="3px" style="width: 50%">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Title</th>
                    <th>Publisher</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="book" >
                    <tr>
                        <td><c:out value="${book.code}" /></td>
                        <td><c:out value="${book.title}" /></td>
                        <td><c:out value="${book.publisher}" /></td>
                        <td><c:out value="${book.price}" /></td>
                        <td>
<!--                            <a href="EditServlet?code=${book.code}">Update</a>
                            |
                            onclick="return confirm('Are you sure to delete this book ?')"  
                            -->
                            <a href="DeleteServlet?code=${book.code}" 
                                
                               >delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
