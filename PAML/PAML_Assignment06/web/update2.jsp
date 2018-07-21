<%-- 
    Document   : update2
    Created on : Feb 10, 2017, 6:56:34 PM
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
        <h1>Update Employee</h1>
        <form method="post" action="UpdateEmployee" >
            ID: <br/>
            <input type="text" name="id" readonly="true" value="${empInfo.id}" /><br/>
            Password: <br/>
            <input type="password" name="password" required="true" value="${empInfo.password}" /><br/>
            Name: <br/>
            <input type="text" name="name" required="true" value="${empInfo.name}" /><br/>
            Age: <br/>
            <input type="text" name="age" required="true" value="${empInfo.age}" /><br/>
            Gender: <br/>
            <input type="text" name="gender" required="true" value="${empInfo.gender}" /><br/>
            Role: <br/>
            <input type="text" name="role" required="true" value="${empInfo.role}" /><br/><br/>
            <input type="submit" value="Update" />

        </form>
        <br/>
        <a href="ViewEmployee" >Back to Home</a>
        <br/>
        <h3>${update_msg}</h3>
    </body>
</html>
