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
  ${news.content}
</div>
<jsp:include page="common/foot.jsp"/>
