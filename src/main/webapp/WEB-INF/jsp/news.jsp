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
    <jsp:param name="css" value="news"/>
    <jsp:param name="title" value="title_enterprise"/>
</jsp:include>
<fmt:bundle basename="site">
<div class="news-page container-fluid">
    <h2 class="titlebar"><fmt:message key="news_title"/></h2>
    <div class="row">
        <div class="col-sm-8">
            <c:forEach items="${newsList}" var="news" begin="0" end="0">
                <div class="news-box">
                    <img style="width:100%" src="/imgs/${news.mainPicPath}" class="img-responsive"/>
                    <div class="news-info animated">
                        <c:choose>
                            <c:when test="${not empty news.link}">
                                <a href="${news.link}" target="_blank">
                            </c:when>
                            <c:otherwise>
                                <a href="/news/${news.id}" target="_blank">
                            </c:otherwise>
                        </c:choose>
                            <p>${news.title}</p>
                            <div class="text-right">${news.subtitle}</div>
                        </a>
                    </div>
                </div>
            </c:forEach>

            <div class="container-fluid news-list row mt30 news-left">
                <div class="row mt15">
                <c:forEach items="${newsList}" var="news" begin="1" varStatus="status" step="2">
                    <div class="col-sm-6">
                        <c:choose>
                            <c:when test="${not empty news.link}">
                                <a href="${news.link}" target="_blank">
                            </c:when>
                            <c:otherwise>
                                <a href="/news/${news.id}" target="_blank">
                            </c:otherwise>
                        </c:choose>
                            <img src="/imgs/${news.mainPicPath}" class="img-responsive"/>
                            <p class="title">${news.title}</p>
                            <div class="date"><fmt:formatDate value="${news.createTime}" pattern="yyyy,MMdd"/></div>
                            <p>${news.subtitle}</p>
                            <span class="arrow-right"><fmt:message key="news_more"/></span>
                        </a>
                    </div>
                     <c:if test="${status.index < fn:length(newsList)}">
                        <div class="col-sm-6">
                            <c:choose>
                                <c:when test="${not empty news.link}">
                                <a href="${newsList[status.index + 1].link}" target="_blank">
                                </c:when>
                                <c:otherwise>
                                    <a href="${newsList[status.index + 1].id}" target="_blank">
                                </c:otherwise>
                            </c:choose>
                            <a href="${newsList[status.index + 1].link}" target="_blank">
                                <img src="/imgs/${newsList[status.index + 1].mainPicPath}" class="img-responsive"/>
                                <p class="title">${newsList[status.index + 1].title}</p>
                                <div class="date"><fmt:formatDate value="${newsList[status.index + 1].createTime}" pattern="yyyy,MMdd"/></div>
                                <p>${newsList[status.index + 1].subtitle}</p>
                                <span class="arrow-right"><fmt:message key="news_more"/></span>
                            </a>
                        </div>
                    </c:if> 
                </c:forEach>
                </div>
            </div>
        </div>
        <div class="col-sm-4 news-right">
            <h4><fmt:message key="news_title"/></h4>
            <ul class="list-unstyled news-list">
                <c:forEach items="${newsList}" var="news">
                    <li>
                        <c:choose>
                            <c:when test="${not empty news.link}">
                                <a href="${news.link}" target="_blank">${news.title}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/news/${news.id}" target="_blank">${news.title}</a>
                            </c:otherwise>
                        </c:choose>
                        &nbsp;&nbsp;<fmt:formatDate value="${news.createTime}" pattern="yyyy,MMdd"/>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</fmt:bundle>
<jsp:include page="common/foot.jsp"/>
