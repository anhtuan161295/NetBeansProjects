<%-- 
    Document   : update1.jsp
    Created on : Feb 10, 2017, 6:40:56 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employee</title>
    </head>
    <body>
        <h1>Enter id to find employee</h1>
        <form method="post" action="GetEmployee?action=update">
            Employee ID: <br/>
            <input type="text" name="id" /><br/><br/>
            <input type="submit" value="Find" />
        </form>
    </body>
    <br/>
    <a href="ViewEmployee" >Back to Home</a>
    <br/>
    <h4 style="color: red">${emp_notfound}</h4>

</html>
