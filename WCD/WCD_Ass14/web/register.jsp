
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
        <h1><fmt:message key="lbl.register" bundle="${bundleContent}" /></h1>
        <a href="ChangeLanguageServlet?language=en_US">English</a>
        <a href="ChangeLanguageServlet?language=vi_VN">Tiếng Việt</a>
        <h1></h1>
        <form method="post" action="InsertServlet">
            <fmt:message key="lbl.username" bundle="${bundleContent}" /> <br/>
            <input type="text" name="username" /><br/>
            <fmt:message key="lbl.password" bundle="${bundleContent}" /> <br/>
            <input type="text" name="pasword" /><br/>
            <fmt:message key="lbl.fullname" bundle="${bundleContent}" /> <br/>
            <input type="text" name="fullname" /><br/>
            <fmt:message key="lbl.dob" bundle="${bundleContent}" /> <br/>
            <input type="text" name="dob" /><br/>
            <fmt:message key="lbl.email" bundle="${bundleContent}" /> <br/>
            <input type="text" name="email" /><br/>
            <fmt:message key="lbl.role" bundle="${bundleContent}" /> <br/>
            <input type="text" name="role" /><br/>
            <br/>
            <input type="submit" value="<fmt:message key="lbl.btnRegister" bundle="${bundleContent}" />" />

        </form>
        <br/>
        <a href="SelectAllServlet"><fmt:message key="lbl.backtolist" bundle="${bundleContent}" /></a>

    </body>
</html>
