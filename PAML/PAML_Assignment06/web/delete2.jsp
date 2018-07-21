<%-- 
    Document   : delete2
    Created on : Feb 10, 2017, 7:28:33 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Employee</title>
    </head>
    <body>
        <h1>Delete Employee</h1>
        <form method="post" action="DeleteEmployee" >
            ID: <br/>
            <input type="text" name="id" readonly="true" value="${empInfo.id}" /><br/>
            Password: <br/>
            <input type="password" name="password" readonly="true" value="${empInfo.password}" /><br/>
            Name: <br/>
            <input type="text" name="name" readonly="true" value="${empInfo.name}" /><br/>
            Age: <br/>
            <input type="text" name="age" readonly="true" value="${empInfo.age}" /><br/>
            Gender: <br/>
            <input type="text" name="gender" readonly="true" value="${empInfo.gender}" /><br/>
            Role: <br/>
            <input type="text" name="role" readonly="true" value="${empInfo.role}" /><br/><br/>
            <input type="submit" value="Delete" />

        </form>
        <br/>
        <a href="ViewEmployee" >Back to Home</a>
        <br/>
        <!--<h3>${delete_msg}</h3>-->
    </body>
</html>
