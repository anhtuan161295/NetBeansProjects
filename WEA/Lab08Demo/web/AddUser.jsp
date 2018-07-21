<%-- 
    Document   : AddUser
    Created on : Nov 17, 2016, 6:31:06 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsf/html" prefix="h" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Add User</h2>
        <c:view>
            <p>
                <h:message id="errors" for="User_ID" style="color:red">

                </h:message>
                <h:message id="errors1" for="email" style="color:red">

                </h:message>
            </p>
            <h:form>
                <h:panelGrid border="1" columns="2">
                    <h:outputText value="ID"></h:outputText>
                    <h:inputText id="User_ID" value="#{userBean.id}" required="true">
                        <c:validateLongRange minimum="1" maximum="500"></c:validateLongRange>
                    </h:inputText>
                    <h:outputText value="Name"></h:outputText>
                    <h:inputText value="#{userBean.name}" ></h:inputText>
                    <h:outputText value="Year of birth"></h:outputText>
                    <h:inputText value="#{userBean.yob}" ></h:inputText>
                    <h:outputText value="Email"></h:outputText>
                    <h:inputText id="email" value="#{userBean.email}" >
                        <c:validator validatorId="lab08.EmailValidator"></c:validator>
                    </h:inputText>
                    <h:commandButton action="#{userBean.addUser()}" value="Add Customer"></h:commandButton>

                </h:panelGrid>
            </h:form>
        </c:view>

    </body>
</html>
