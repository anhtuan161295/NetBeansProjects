<%-- 
    Document   : delete
    Created on : Dec 10, 2016, 12:29:43 AM
    Author     : QQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1><fmt:message key="lbl.confirmDelete" bundle="${bundleContent}" /></h1>
        <a href="ChangeLanguageServlet?language=en_US">English</a>
        <a href="ChangeLanguageServlet?language=vi_VN">Tiếng Việt</a>
        <h1></h1>
        <form method="post" action="DeleteServlet?action=DeleteConfirmed">

            <!--<label>User name</label><br/>-->
            <!--<input type="text" value="${requestScope.UserInfo.username}" readonly="true" disabled class="form-control" /><br/>-->
            <input type="hidden" name="username" value="${requestScope.UserInfo.username}" /><br/><br/>

            <input type="submit" value="<fmt:message key="lbl.btnDelete" bundle="${bundleContent}" />" class="btn btn-danger" />

        </form>
        <br/>
        <a href="SelectAllServlet"><fmt:message key="lbl.backtolist" bundle="${bundleContent}" /></a>


    </body>
</html>
