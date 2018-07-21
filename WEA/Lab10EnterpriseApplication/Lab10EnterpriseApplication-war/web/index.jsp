<%-- 
    Document   : index
    Created on : Nov 25, 2016, 7:38:02 PM
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
        <h1>Calculator!</h1>
        <form method="post" action="CalculatorServlet">
            <label>Input A</label><br>
            <input type="text" name="numberA" value="" /><br/>
            <label>Input B</label><br/>
            <input type="text" name="numberB" value="" /><br/>
            <input type="submit" value="Addition" />

        </form>

        <%
            if (request.getAttribute("result") != null) {
                float result = Float.parseFloat(request.getAttribute("result").toString());
                out.print("<h1>Result = " + result + " </h1>");
            }

//                <h1>Result = < / h1 >

        %>
    </body>
</html>
