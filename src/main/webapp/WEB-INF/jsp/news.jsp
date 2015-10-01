<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="news-page container-fluid">
    <h2 class="titlebar">新闻</h2>
    <div class="row">
        <div class="col-sm-8">
            <c:forEach items="${newsList}" var="news" begin="0" end="0">
                <div class="news-box">
                    <img src="/imgs/${news.mainPicPath}" class="img-responsive"/>
                    <div class="news-info animated">
                        <a href="#">
                            <p>${news.title}</p>
                            <div class="text-right">${news.subtitle}</div>
                        </a>
                    </div>
                </div>
            </c:forEach>

            <div class="container-fluid news-list row mt30 news-left">
                <c:forEach items="${newsList}" var="news" begin="1" varStatus="status">
                    <c:if test="${(status.index-1) % 2 == 0}">
                    <div class="row mt15">
                    </c:if>
                    <div class="col-sm-6">
                        <a href="${news.link}" target="_blank">
                            <img src="/imgs/${news.mainPicPath}" class="img-responsive"/>
                            <p class="title">${news.title}</p>
                            <div class="date"><fmt:formatDate value="${news.createTime}" pattern="MM月dd, yyyy"/></div>
                            <p>${news.subtitle}</p>
                            <span class="arrow-right">更多信息</span>
                        </a>
                    </div>
                    <c:if test="${(status.index) % 2 == 0}">
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="col-sm-4 news-right">
            <h4>新闻</h4>
            <ul class="list-unstyled news-list">
                <c:forEach items="${newsList}" var="news">
                    <li>
                        <a href="">${news.title}</a>  <fmt:formatDate value="${news.createTime}" pattern="MM月dd日 yyyy"/>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"/>
