<%-- 
    Document   : insert
    Created on : Feb 10, 2017, 4:31:57 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new employee</title>
    </head>
    <body>
        <h1>Add new employee</h1>
        <form method="post" action="AddEmployee" >
            ID: <br/>
            <input type="text" name="id" required="true" /><br/>
            Password: <br/>
            <input type="text" name="password" required="true" /><br/>
            Name: <br/>
            <input type="text" name="name" required="true" /><br/>
            Age: <br/>
            <input type="text" name="age" required="true" /><br/>
            Gender: <br/>
            <input type="text" name="gender" required="true" /><br/>
            Role: <br/>
            <input type="text" name="role" required="true" /><br/><br/>
            <input type="submit" value="Insert" />

        </form>
        <br/>
        <a href="ViewEmployee" >Back to Home</a>
        <br/>
        <h3>${insert_msg}</h3>
    </body>
</html>
