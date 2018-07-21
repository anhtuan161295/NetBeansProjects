

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            test.InterestCalculatorWS_Service service
                    = new test.InterestCalculatorWS_Service();
            test.InterestCalculatorWS port
                    = service.getInterestCalculatorWSPort();
            double amount = 1000;
            double rate = 0.1;
            int duration = 12;
            double result = port.simpleInterest(amount, rate, duration);
            out.println("Result = " + result);


        %>
    </body>
</html>
