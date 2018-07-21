<%-- 
    Document   : locale
    Created on : Dec 23, 2016, 2:38:37 PM
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
        <h1>Internationalization</h1>
        <a href="InterServlet?language=en_US">English</a>
        <a href="InterServlet?language=vi_VN">Tiếng Việt</a>
        <h3>Locale of ${country}</h3>
        Format number: ${fnumber} <br/>
        Format currency: ${fcurrency} <br/>
        Format percent: ${fpercent} <br/>
        Format date: ${fdate} <br/>
        Format string: <br/>
        - ${fmessage} <br/>
        - ${fuser} <br/>
        - ${fpass} <br/>


    </body>
</html>
