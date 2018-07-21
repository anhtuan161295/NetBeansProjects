<%-- 
    Document   : transaction
    Created on : Feb 20, 2017, 3:10:49 PM
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
        <h1>Transaction is My Bank</h1>
        <h3>Hello, ${sessionScope.user.name}</h3>
        <form action="transaction_process.jsp" >
            Enter amount:<input type="text" name="amount" value="0"><br/><br/>
            Choose operation:<br>
            Deposit<input type="radio" name="operation" value="deposit" />
            Withdraw<input type="radio" name="operation" value="withdraw" />
            Check balance<input type="radio" name="operation" value="checkbalance" />
            <br/><br/>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
