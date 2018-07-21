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
        <title>Add new customer</title>
    </head>
    <body>
        <h1>Add new customer</h1>
        <form method="post" action="InsertCustomer" >
            ID: <br/>
            <input type="text" name="id" required="true" /><br/>
            Password: <br/>
            <input type="password" name="password" required="true" /><br/>
            Name: <br/>
            <input type="text" name="name" required="true" /><br/>
            Balance: <br/>
            <input type="number" name="balance" required="true" min="1" /><br/>
           <br/>
            <input type="submit" value="Insert" />

        </form>
        <br/>
        <!--<a href="ViewEmployee" >Back to Home</a>-->
        <br/>
        <h3>${insert_msg}</h3>
    </body>
</html>
