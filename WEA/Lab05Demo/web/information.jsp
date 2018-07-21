<%-- 
    Document   : information
    Created on : Nov 14, 2016, 4:02:18 PM
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
        <h1>Input your informations</h1>
        <form action="ForwardServlet" method="POST">
            <table cellspacing="0" border="0" cellpadding="5" >
                <tbody>
                    <tr>
                        <td>Enter your full name:</td>
                        <td><input type="text" name="fullname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Enter your year of birth:</td>
                        <td><input type="text" name="yearofbirth" value="" /></td>
                    </tr>
                    <tr>
                        <td>Enter your address:</td>
                        <td><input type="text" name="address" value="" /></td>
                    </tr>
                    <tr>
                        <td>Enter your email:</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Enter your interest:</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="interest" value="Shopping" />Shopping</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="interest" value="Watching Films" />Watching Films</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="interest" value="Sporting" />Sporting</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
