<%-- 
    Document   : select
    Created on : Dec 21, 2016, 3:14:39 PM
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
        <h1><fmt:message key="lbl.listofusers" bundle="${bundleContent}" /></h1>
        <a href="ChangeLanguageServlet?language=en_US">English</a>
        <a href="ChangeLanguageServlet?language=vi_VN">Tiếng Việt</a>
        <h1></h1>
        <%
            if (request.isUserInRole("manager")) {
        %>
        <h3><a href="register.jsp"><fmt:message key="lbl.addnewuser" bundle="${bundleContent}" /></a></h3>
            <%
                } else {
                }
            %>

        <h3><a href="LogoutServlet"><fmt:message key="lbl.btnLogout" bundle="${bundleContent}" /></a></h3>


        <table class="table" >
            <tr>
                <th><fmt:message key="lbl.username" bundle="${bundleContent}" /></th>
                <th><fmt:message key="lbl.fullname" bundle="${bundleContent}" /></th>
                <th><fmt:message key="lbl.dob" bundle="${bundleContent}" /></th>
                <th><fmt:message key="lbl.email" bundle="${bundleContent}" /></th>
                <th><fmt:message key="lbl.role" bundle="${bundleContent}" /></th>

                <%
                    if (request.isUserInRole("manager")) {
                %>
                <th><fmt:message key="lbl.actions" bundle="${bundleContent}" /></th>

                <%
                    } else {
                    }
                %>
            </tr>
            <c:forEach items="${listUsers}" var="user" >
                <tr> 
                    <td><c:out value="${user.username}"></c:out></td>
                    <td><c:out value="${user.fullname}"></c:out></td>
                    <td><c:out value="${user.dateofbirth}"></c:out></td>
                    <td><c:out value="${user.email}"></c:out></td>
                    <td><c:out value="${user.role}"></c:out></td>

                    <%
                        if (request.isUserInRole("manager")) {
                    %>
                    <td>
                        <a  href="GetUserServlet?username=${user.username}&action=Update"><fmt:message key="lbl.update" bundle="${bundleContent}" /></a>
                        |
                        <a  href="GetUserServlet?username=${user.username}&action=Delete"><fmt:message key="lbl.delete" bundle="${bundleContent}" /></a>
                    </td>
                    <%
                        } else {
                        }
                    %>

                </tr>

            </c:forEach>

        </table>
    </body>
</html>
