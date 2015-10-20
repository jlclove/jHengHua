<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/10/11
  Time: 下午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/include.jsp"%>
<jsp:include page="common/head.jsp">
  <jsp:param name="css" value="news"/>
  <jsp:param name="title" value="title_enterprise"/>
</jsp:include>
<div class="news-page container mt50">
  <h3>${media.title}</h3>
  <h5>${media.subtitle}</h5>
  <div><fmt:formatDate value="${media.createTime }" pattern="yyyy-MM-dd HH:mm"/></div>
  <div>
  	<c:if test="${not empty media.mainPicPath }">
  		<img class="mt15" src="/imgs/${media.mainPicPath }">
  	</c:if>
  	<div class="mt15">
  		${media.content}
  	</div>
  </div>
</div>
<jsp:include page="common/foot.jsp"/>
