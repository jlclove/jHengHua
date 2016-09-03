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
        <a href="/account/profile"><fmt:message key="nav_account_profile"/></a>
    </li>
    <hr>
    <li>
        <a id="btn-logout" class="btn-logout" href="javascript:;"><fmt:message key="nav_logout_btn"/></a>
    </li>
</ul>
</fmt:bundle>
