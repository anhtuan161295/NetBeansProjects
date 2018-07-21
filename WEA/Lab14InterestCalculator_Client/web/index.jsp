<%-- 
    Document   : index
    Created on : Nov 28, 2016, 3:49:04 PM
    Author     : QQ
--%>

<%@page import="test.InterestCalculatorWS_Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <h1>Call web service example</h1>
        <%
            try {
                test.InterestCalculatorWS_Service service = new InterestCalculatorWS_Service();
                test.InterestCalculatorWS port = service.getInterestCalculatorWSPort();
                double principal = 1000.0d;
                double rate = 12.0d;
                float duration = 3.0f;
                double result = port.simpleInterest(principal, rate, duration);
                out.println("Simple Interest is: " + result);

            } catch (Exception ex) {
                out.println("Lỗi rồi");
            }

        %>
    </body>
</html>
