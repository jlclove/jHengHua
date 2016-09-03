<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 16/9/3
  Time: 下午2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp"%>

<c:if test="${fn:length(exhibitions) > 0}">
<div class="exhibition-container">
    <ul>
        <c:forEach items="${exhibitions}" var="exhibition" varStatus="status">
            <li class="${status.first ? 'active': ''}">［${exhibition.type}］${exhibition.name}, 地址: ${exhibition.address}, ${exhibition.startTime} - ${exhibition.endTime}</li>
        </c:forEach>
    </ul>
</div>
</c:if>
