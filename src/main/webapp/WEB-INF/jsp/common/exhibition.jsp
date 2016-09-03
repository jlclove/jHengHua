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
            <li class="${status.first ? 'active': ''}">【${exhibition.type}】${exhibition.name}； <b>地址：</b> ${exhibition.address}； <b>举办时间：</b> ${exhibition.startTime} 至 ${exhibition.endTime}</li>
        </c:forEach>
    </ul>
</div>
</c:if>
