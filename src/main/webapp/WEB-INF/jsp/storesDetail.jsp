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
<div class="store-page container-fluid wrapper">
    <div class="store-info">
        <img src="/imgs/${store.picPath}" width="100%" class="hidden-xs">
        <div class="overlay">
            <h3>${store.storeName}</h3>
            <a href="/stores?countryId=${country.id}" class="arrow-left"><fmt:message key="store_back"/></a>
            <h4 class="mt30"><fmt:message key="store_address"/></h4>
            <p>${store.province} ${store.address}</p>
            <p>${store.zipCode} ${country.name}</p>
            <p><fmt:message key="store_phone"/>: ${store.phone}</p>
        </div>
    </div>
    <div class="row mt40 pl10 pr10">
        <div class="col-md-4">
            <h4><fmt:message key="store_opentime"/></h4>
            <hr>
            <div class="clearfix">
                <span class="pull-left"><fmt:message key="store_monday"/></span>
                <span class="pull-right">${store.workTime1}</span>
            </div>
            <div class="clearfix">
                <span class="pull-left"><fmt:message key="store_tuesday"/></span>
                <span class="pull-right">${store.workTime2}</span>
            </div>
            <div class="clearfix">
                <span class="pull-left"><fmt:message key="store_wednesday"/></span>
                <span class="pull-right">${store.workTime3}</span>
            </div>
            <div class="clearfix">
                <span class="pull-left"><fmt:message key="store_thusday"/></span>
                <span class="pull-right">${store.workTime4}</span>
            </div>
            <div class="clearfix">
                <span class="pull-left"><fmt:message key="store_friday"/></span>
                <span class="pull-right">${store.workTime5}</span>
            </div>
            <div class="clearfix">
                <span class="pull-left"><fmt:message key="store_saturday"/></span>
                <span class="pull-right">${store.workTime6}</span>
            </div>
            <div class="clearfix">
                <span class="pull-left"><fmt:message key="store_sunday"/></span>
                <span class="pull-right">${store.workTime7}</span>
            </div>
        </div>
    </div>
</div>
</fmt:bundle>
<jsp:include page="common/foot.jsp"/>
