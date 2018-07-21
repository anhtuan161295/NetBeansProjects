<%-- 
    Document   : locale2
    Created on : Dec 23, 2016, 2:58:33 PM
    Author     : QQ
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Internationalization</h1>
        <a href="InterServlet2?language=en_US">English</a>
        <a href="InterServlet2?language=vi_VN">Tiếng Việt</a>
        <h2>Locale of ${country}</h2>
        <h3>
            <fmt:setLocale value="${language}" ></fmt:setLocale>
            <fmt:formatNumber var="formatNumber" type="number" value="1234567.123" />
            Format number: ${formatNumber} <br/>
            <fmt:formatNumber var="formatCurrency" type="currency" value="1234567.123" />
            Format currency: ${formatCurrency} <br/>
            <fmt:formatNumber var="formatPercent" type="percent" value="12.34" />
            Format percent: ${formatPercent} <br/>
            <fmt:formatDate var="formatDate" value="<%= new Date()%>" dateStyle="full" />
            Format date: ${formatDate} <br/>
            <fmt:setBundle var="bundleContent" basename="resources.content" />
            Format string: <br/>
            <fmt:message key="lbl.welcome" bundle="${bundleContent}" /> <br/>
            <fmt:message key="lbl.username" bundle="${bundleContent}" /> <br/>
            <fmt:message key="lbl.password" bundle="${bundleContent}" /> <br/>

        </h3>
    </body>
</html>
