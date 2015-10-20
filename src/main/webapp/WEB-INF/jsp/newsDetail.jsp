<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/include.jsp"%>
<jsp:include page="common/head.jsp">
  <jsp:param name="css" value="news"/>
  <jsp:param name="title" value="title_enterprise"/>
</jsp:include>
<div class="news-page container mt50">
  <h3>${news.title}</h3>
  <h5>${news.subtitle}</h5>
  <div><fmt:formatDate value="${news.createTime }" pattern="yyyy-MM-dd HH:mm"/></div>
  <div>
  	<c:if test="${not empty news.mainPicPath }">
  		<img class="mt15" src="/imgs/${news.mainPicPath }">
  	</c:if>
  	<div class="mt15">
  		${news.content}
  	</div>
  </div>
</div>
<jsp:include page="common/foot.jsp"/>
