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

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" >
            <div class="col-xs-4" ></div>
            <div class="col-xs-4" >
                <h1>Add new employee</h1>
                <form method="post" action="Insert?action=Insert">

                    <label>Employee ID</label><br/>
                    <input type="text" name="id" placeholder="Employee ID" required="true" /><br/>
                    <label>Employee Name</label><br/>
                    <input type="text" name="name" placeholder="Employee Name" required="true"  /><br/>
                    <label>Address</label><br/>
                    <input type="text" name="address" placeholder="Address" required="true"   /><br/>
                    <label>Age</label><br/>
                    <input type="number" name="age" placeholder="Age" required="true" min="16"  /><br/>
                    <br/>
                    <input type="submit" value="Insert" class="btn btn-primary" />
                    <input type="reset" value="Reset" class="btn btn-primary" />
                </form>
                <br/>
                <!--<a href="UserController">Back to list</a>-->
            </div>
        </div>

    </body>
</html>
