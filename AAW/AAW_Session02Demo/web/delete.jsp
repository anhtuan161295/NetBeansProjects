<%-- 
    Document   : delete
    Created on : Dec 10, 2016, 12:29:43 AM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Are you sure to delete <c:label name="userDelete.username" /> ?</h2>
        <c:form action="DeleteUser" >
            <c:hidden name="userDelete.username" />
            <c:submit value="Delete" />
        </c:form>
        <br/>
        <a href="Display">Back to list</a>
    </body>
</html>
