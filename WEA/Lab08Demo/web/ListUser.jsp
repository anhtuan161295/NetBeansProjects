<%-- 
    Document   : ListUser
    Created on : Nov 17, 2016, 6:43:23 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsf/html" prefix="h" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lists of Users</title>
    </head>
    <body>
        <c:view>
            <h:form>
                <h:outputText value="User #{userBean.name} is added successfully"></h:outputText>
            </h:form>
        </c:view>
    </body>
</html>
