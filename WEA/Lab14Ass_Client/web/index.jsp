<%-- 
    Document   : index
    Created on : Nov 28, 2016, 4:12:09 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="CalculateInterest">
            <label>Account number</label> <br/>
            <input type="text" name="AccountNumber" /> <br/> 
            <label>Balance</label> <br/>
            <input type="number" name="Balance" /> <br/>
            <label>Duration</label> <br/>
            <input type="number" name="Duration" /> <br/>
            <label>Rate</label> <br/>
            <input type="number" name="Rate" /> <br/>
            <input type="submit" value="Calculate Interest" />
        </form>
    </body>
</html>
