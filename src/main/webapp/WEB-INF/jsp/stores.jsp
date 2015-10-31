<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/10/28
  Time: 下午10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/include.jsp"%>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="store"/>
    <jsp:param name="title" value="title_stores"/>
</jsp:include>
<fmt:bundle basename="site">
<div class="store-page container">
    <h3>商店地址</h3>
    <select class="form-control mt10" name="" id="" style="width: 330px;" onchange="javascript:window.location.href='/stores?countryId=' + this.value;">
        <c:forEach items="${countries}" var="cty">
            <option value="${cty.id}" <c:if test="${cty.id==country.id}">selected</c:if>  >${cty.name}</option>
        </c:forEach>
    </select>
    <h4>${country.name}</h4>
    <c:forEach items="${storeList}" var="store">
        <div><a class="f18" href="/stores/${store.id}">${store.storeName}</a></div>
    </c:forEach>
</div>
</fmt:bundle>
<jsp:include page="common/foot.jsp"/>
