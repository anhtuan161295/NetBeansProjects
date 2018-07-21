<%-- 
    Document   : delete
    Created on : Dec 10, 2016, 12:29:43 AM
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
            <div class="col-xs-3" ></div>
            <div class="col-xs-6" >
                <h2>Are you sure to delete ${requestScope.UserInfo.username} ?</h2>
                <form method="post" action="UserController?action=DeleteConfirmed">

                    <!--<label>User name</label><br/>-->
                    <!--<input type="text" value="${requestScope.UserInfo.username}" readonly="true" disabled class="form-control" /><br/>-->
                    <input type="hidden" name="username" value="${requestScope.UserInfo.username}" /><br/>
                    
                    <div class="col-xs-4">
                        <a href="UserController">Back to list</a>
                    </div>
                    <div class="col-xs-4 pull-right" >
                        <input type="submit" value="Delete" class="btn btn-danger" />
                    </div>

                </form>
                <br/>

            </div>
        </div>

    </body>
</html>
