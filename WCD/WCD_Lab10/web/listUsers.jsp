<%-- 
    Document   : listUsers
    Created on : Dec 9, 2016, 4:16:46 PM
    Author     : QQ
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container" >
            <div class="col-xs-1" ></div>
            <div class="col-xs-10" >
                <%
                    User user = new User("Guest", "Guest", "Guest", 0);
                    if (session.getAttribute("user") != null) {
                        user = (User) session.getAttribute("user");
                    } else {
//                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                %>
                <a href="UserController"><h1>List of Users</h1></a>
                <div class="col-xs-4">

                    <%                        if (user.getLevel() == 2) {
                    %> 
                    <a href="insert.jsp">Add User</a>

                    <%
                        }
                    %>

                </div>
                <div class="col-xs-6">
                    <form class="form-inline" method="post" action="UserController?action=Search">
                        <input type="text" name="keywords" class="form-control" />
                        <input type="submit" value="Search" class="btn btn-primary" />
                    </form>
                </div>
                <div class="col-xs-2">
                    Hi <strong><%=user.getUsername()%></strong> ,
                    <a href="LogoutController" >Logout</a>
                </div>

                <div style="margin-bottom: 70px"></div>

                <table class="table" >
                    <tr>
                        <th>User name</th>
                        <th>Full name</th>
                        <th>Level</th>
                            <%
                                if (user.getLevel() == 2) {
                            %> 
                        <th>Actions</th>

                        <%
                            }
                        %>


                    </tr>
                    <c:forEach items="${listUsers}" var="user" >
                        <tr>
                            <td><c:out value="${user.username}"></c:out></td>
                            <td><c:out value="${user.fullname}"></c:out></td>
                            <td><c:out value="${user.level}"></c:out></td>
                            <%
                                if (user.getLevel() == 2) {
                            %> 
                            <td>
                                <a style="text-decoration-line: none" href="UserController?username=${user.username}&action=Update">Update</a> |
                                <a style="text-decoration-line: none" href="UserController?username=${user.username}&action=Delete">Delete</a>
                            </td>

                            <%
                                }
                            %>


                        </tr>

                    </c:forEach>

                </table>

            </div>

        </div> 






    </body>
</html>
