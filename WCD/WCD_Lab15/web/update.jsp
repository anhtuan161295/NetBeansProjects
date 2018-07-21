<%-- 
    Document   : update.jsp
    Created on : Dec 9, 2016, 7:12:49 PM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    if (session.getAttribute("language") == null) {
        session.setAttribute("language", "en_US");
        session.setAttribute("resourseLocation", "resources.lang_en_US");
    }
%>
<fmt:setLocale value="${sessionScope.language}" ></fmt:setLocale>
<fmt:setBundle var="bundleContent" basename="${sessionScope.resourseLocation}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><fmt:message key="lbl.update" bundle="${bundleContent}" /></h1>
        <a href="ChangeLanguageServlet?language=en_US">English</a>
        <a href="ChangeLanguageServlet?language=vi_VN">Tiếng Việt</a>
        <h1></h1>
        <form method="post" action="UpdateServlet?action=UpdateConfirmed">
            <fmt:message key="lbl.username" bundle="${bundleContent}" /> <br/>
            <input type="text" value="${requestScope.UserInfo.username}" readonly="true" disabled class="form-control"/><br/>
            <input type="hidden" name="username" value="${requestScope.UserInfo.username}" /><br/>
             <fmt:message key="lbl.password" bundle="${bundleContent}" /> <br/>
            <input type="text" name="newPassword" value="${requestScope.UserInfo.password}" class="form-control" /><br/>
            <fmt:message key="lbl.fullname" bundle="${bundleContent}" /> <br/>
            <input type="text" name="newFullname" value="${requestScope.UserInfo.fullname}" class="form-control" /><br/>
            <fmt:message key="lbl.dob" bundle="${bundleContent}" /> <br/>
            <input type="text" name="newDob" value="${requestScope.UserInfo.dateofbirth}" class="form-control" /><br/>
            <fmt:message key="lbl.email" bundle="${bundleContent}" /> <br/>
            <input type="text" name="newEmail" value="${requestScope.UserInfo.email}" class="form-control" /><br/>
            <br/>
            <input type="submit" value="<fmt:message key="lbl.btnSave" bundle="${bundleContent}" />" class="btn btn-primary" />
        </form>
        <br/>
        <a href="SelectAllServlet"><fmt:message key="lbl.backtolist" bundle="${bundleContent}" /></a>

    </body>
</html>
