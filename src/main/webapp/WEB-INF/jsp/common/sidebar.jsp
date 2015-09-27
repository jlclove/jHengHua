<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp"%>
<fmt:bundle basename="site">
<ul class="sidebar">
    <li>
        <a href="/media" <c:if test="${pageName==\"media\"}">class="selected"</c:if>><fmt:message key="nav_company_media"/></a>
    </li>
    <li>
        <a href="/news" <c:if test="${pageName==\"news\"}">class="selected"</c:if>><fmt:message key="nav_company_news"/></a>
    </li>
    <li>
        <a href="/enterprise/about" <c:if test="${pageName==\"about\"}">class="selected"</c:if>><fmt:message key="nav_company_about_us"/></a>
    </li>
    <li>
        <a href="/enterprise/franchise" <c:if test="${pageName==\"franchise\"}">class="selected"</c:if>><fmt:message key="nav_company_franchise"/></a>
    </li>
    <li>
        <a href="/enterprise/career" <c:if test="${pageName==\"career\"}">class="selected"</c:if>><fmt:message key="nav_company_career"/></a>
    </li>
    <li>
        <a href="/enterprise/contact" <c:if test="${pageName==\"contact\"}">class="selected"</c:if>><fmt:message key="nav_company_contact"/></a>
    </li>
</ul>
</fmt:bundle>
