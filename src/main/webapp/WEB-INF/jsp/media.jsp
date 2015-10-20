<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/include.jsp"%>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="media"/>
    <jsp:param name="title" value="title_enterprise"/>
</jsp:include>
<fmt:bundle basename="site">
<div class="media-page container-fluid">
    <h4 class="text-center titlebar"><fmt:message key="media_title1"/></h4>
    <h4 class="text-center segment-line"><span><fmt:message key="media_title2"/></span></h4>
    <c:forEach items="${mediaList}" var="media" step="3" varStatus="status">
    <div class="row mt30">
        <div class="col-sm-4">
            <c:choose>
                <c:when test="${not empty media.link}">
                    <a class="media-name" href="${media.link}" target="_blank">${media.title}</a>
                </c:when>
                <c:otherwise>
                    <a class="media-name" href="/media/${media.id}" target="_blank">${media.title}</a>
                </c:otherwise>
            </c:choose>
            <hr/>
            <p class="media-content">
                    ${media.content}
            </p>
        </div>
        <c:if test="${status.index+1 < fn:length(mediaList)}">
        <div class="col-sm-4">
            <c:choose>
                <c:when test="${not empty mediaList[status.index+1].link}">
                    <a class="media-name" href="${mediaList[status.index+1].link}" target="_blank">${mediaList[status.index+1].title}</a>
                </c:when>
                <c:otherwise>
                    <a class="media-name" href="/media/${mediaList[status.index+1].id}" target="_blank">${mediaList[status.index+1].title}</a>
                </c:otherwise>
            </c:choose>
            <hr/>
            <p class="media-content">
                    ${mediaList[status.index+1].content}
            </p>
        </div>
        </c:if>
        <c:if test="${status.index+2 < fn:length(mediaList)}">
        <div class="col-sm-4">
            <c:choose>
                <c:when test="${not empty mediaList[status.index+2].link}">
                    <a class="media-name" href="${mediaList[status.index+2].link}" target="_blank">${mediaList[status.index+2].title}</a>
                </c:when>
                <c:otherwise>
                    <a class="media-name" href="/media/${mediaList[status.index+2].id}" target="_blank">${mediaList[status.index+2].title}</a>
                </c:otherwise>
            </c:choose>
            <hr/>
            <p class="media-content">
                    ${mediaList[status.index+2].content}
            </p>
        </div>
        </c:if>
    </div>
    </c:forEach>
</div>
</fmt:bundle>
<jsp:include page="common/foot.jsp"/>
