<%-- 
    Document   : login
    Created on : Dec 16, 2016, 7:28:36 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-xs-4" ></div>
            <div class="col-xs-4" >
                <div class="form-horizontal">
                    <%
                        Cookie[] cookie = request.getCookies();

                    %>

                    <h1>Login Form</h1>
                    <form method="post" action="LoginController" >
                        <label>Username</label><br/>
                        <input type="text" class="form-control" name="login_username" 
                               placeholder="Username" required="true"
                               value="${cookie.login_username.value}"  /><br/>
                        <label>Password </label><br/>
                        <input type="password" class="form-control" name="login_password" 
                               placeholder="Password" required="true" 
                               value="${cookie.login_password.value}"  /><br/>
                        <input type="checkbox" class="checkbox-inline" name="login_remember" value="RemMe" />  Remember me 
                        <div class="pull-right" >
                            <button type="submit" class="btn btn-primary" >Login</button>
                        </div>
                    </form>
                </div>
                <div style="padding-top: 20px"></div>
                <div class="text-danger" >
                    <h4>
                        <%                        if (request.getAttribute("error_msg") != null) {
                                out.println(request.getAttribute("error_msg"));
                            }
                        %>
                    </h4>
                </div>

            </div>


        </div>
    </body>
</html>
