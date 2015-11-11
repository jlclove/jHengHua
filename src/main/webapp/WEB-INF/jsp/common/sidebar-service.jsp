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
<ul class="sidebar hidden-xs">
    <li>
        <a href="/service/tailor" <c:if test="${pageName=='tailor'}">class="selected"</c:if>>
            <fmt:message key="nav_service_tailor"/>
        </a>
    </li>
    <li>
        <a href="/service/payment" <c:if test="${pageName=='payment'}">class="selected"</c:if>><fmt:message key="nav_service_payment"/></a>
    </li>
    <li>
        <a href="/service/shipment" <c:if test="${pageName=='shipment'}">class="selected"</c:if>><fmt:message key="nav_service_shipment"/></a>
    </li>
    <li>
        <a href="/service/return" <c:if test="${pageName=='return'}">class="selected"</c:if>><fmt:message key="nav_service_return"/></a>
    </li>
    <li>
        <a href="/service/question" <c:if test="${pageName=='question'}">class="selected"</c:if>><fmt:message key="nav_service_question"/></a>
    </li>
    <li>
        <a href="/service/customer" <c:if test="${pageName=='customer'}">class="selected"</c:if>><fmt:message key="nav_service_customer"/></a>
    </li>
    <li>
        <a href="/service/corporate" <c:if test="${pageName=='corporate'}">class="selected"</c:if>><fmt:message key="nav_service_corporate"/></a>
    </li>
</ul>
</fmt:bundle>
