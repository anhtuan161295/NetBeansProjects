<%-- 
    Document   : register
    Created on : Nov 17, 2016, 8:46:43 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="Register Page!"/></h1>
            <h:form>
                <h:panelGrid border="1" columns="3">
                    <h:outputLabel value="Username (*) :"></h:outputLabel>
                    <h:inputText value="#{userController.user.username}" id="username" required="true"></h:inputText>
                    <h:message for="username" style="color:red" ></h:message>

                    <h:outputLabel value="Password (*) :"></h:outputLabel>
                    <h:inputText value="#{userController.user.password}" id="password" required="true"></h:inputText>
                    <h:message for="password" style="color:red" ></h:message>

                    <h:outputLabel value="Real name (*) :"></h:outputLabel>
                    <h:panelGroup>
                        <h:inputText value="#{userController.user.firstname}" id="firstname" required="true"></h:inputText>
                        <h:inputText value="#{userController.user.lastname}" id="lastname" required="true"></h:inputText>
                    </h:panelGroup>
                    <h:message for="firstname" style="color:red" ></h:message>

                    <h:outputLabel value="Birth date (*) :"></h:outputLabel>
                    <h:inputSecret value="#{userController.user.birthdate}" id="birthdate">
                        <f:convertDateTime pattern="dd/MM/yyyy" ></f:convertDateTime>
                    </h:inputSecret>
                    <h:message for="birthdate" style="color:red" ></h:message>

                    <h:outputLabel value="Email (*) :"></h:outputLabel>
                    <h:inputText value="#{userController.user.email}" id="email" required="true"></h:inputText>
                    <h:message for="email" style="color:red" ></h:message>

                </h:panelGrid>
                <h:commandButton value="Register" action="#{userController.createUser()}"></h:commandButton>
            </h:form>

        </body>
    </html>
</f:view>
