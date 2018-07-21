<%-- 
    Document   : insert
    Created on : Dec 14, 2016, 3:16:16 PM
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
        <div class="container" >
            <div class="col-xs-4" ></div>
            <div class="col-xs-4" >
                <h1>Add new user</h1>
                <form method="post" action="UserController?action=Insert">

                    <label>User name</label><br/>
                    <input type="text" name="username" placeholder="User name" class="form-control" /><br/>
                    <label>Password</label><br/>
                    <input type="text" name="password" placeholder="Password" class="form-control"  /><br/>
                    <label>Full name</label><br/>
                    <input type="text" name="fullname" placeholder="Full name" class="form-control"   /><br/>
                    <label>Level</label><br/>
                    <input type="text" name="level" placeholder="Level" class="form-control"  /><br/>
                     <a href="UserController">Back to list</a>
                     <div class="pull-right" >
                         <input type="submit" value="Register" class="btn btn-primary" />
                     </div>
                </form>
                <br/>

            </div>
        </div>

    </body>
</html>
