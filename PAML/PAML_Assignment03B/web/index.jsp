<%-- 
    Document   : index
    Created on : Feb 6, 2017, 11:48:08 PM
    Author     : QQ
--%>

<%@page import="org.w3c.dom.NodeList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Book List</h1>
        <form>
            <label>Input book title:</label><br/>
            <input type="text" name="titleSearch" />
            <input type="submit" value=" Search " /><br/><br/><br/>
        </form>
        <a href="#">Add new Book</a>
        <a style="padding-left: 250px;" href="#">Add new Node</a>
        <table border="1" cellspacing="0px" cellpadding="3px">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Author</th>
                    <th>Edition</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    NodeList books = (NodeList) request.getAttribute("booklist");
                    for (int i = 0; i < books.getLength(); i++) {
                        NodeList book = books.item(i).getChildNodes();
                        String code = books.item(i).getAttributes().getNamedItem("code").getNodeValue();

                %>
                <tr>
                    <td><%= code%></td>
                    <td><%= book.item(1).getTextContent()%></td>
                    <td><%= book.item(3).getTextContent()%></td>
                    <td><%= book.item(5).getTextContent()%></td>
                    <td><%= book.item(7).getTextContent()%></td>
                    <td>
                        <a href="EditBook?code=<%= code%>">Edit</a>
                        <a href="DeleteBook?code=<%= code%>" 
                           onclick="return confirm('Are you sure that you want to delete this book ?')" >Delete</a>
                    </td>
                </tr>

                <%                    }
                %>
            </tbody>
        </table>
    </body>
</html>
