<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/include.jsp"%>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="sample"/>
    <jsp:param name="title" value="nav_shop"/>
</jsp:include>
<fmt:bundle basename="site">
<!-- .banner -->
<div class="suits banner container-fluid">
    <div class="col-sm-3 title"><fmt:message key="nav_shop_features_suit"/></div>
    <div class="col-sm-4 visible-xs visible-sm sub"><fmt:message key="nav_shop_features_text1"/></div>
    <div class="col-sm-4 visible-md visible-lg sub mt5"><fmt:message key="nav_shop_features_text2"/></div>
    <div class="col-sm-5 unit-box">
        <div class="unit reverse">
            <a class="unit-link" href="/about-our-suits"><fmt:message key="nav_shop_features_more"/></a>
        </div>
    </div>
</div>
<!-- /.banner -->

<!-- .filter -->
<jsp:include page="common/filter.jsp"/>
<!-- /.filter -->

<div class="product-wrap container">
    <div class="row" id="list">
        <p class="text-center mt30 f16" v-if="!list">加载中...</p>
        <p class="f18 text-center mt30 f16" v-if="list && list.length == 0">no result found</p>
        <div class="col-sm-3 product-item" v-for="cloth in list" v-if="list.length > 0" style="padding-left: 7px;padding-right: 7px;">
            <a href="/product/cloth/{{cloth.serialNo}}">
                <img src="http://www.jshenghua.com:82/Thumb/{{cloth.desc_png}}" class="img-responsive" width="100%"/>
                <div class="product-desc mt10 pl5">
                    <div><span class="head">{{cloth.name}}</span>  -  <span class="f16">{{cloth.serialNo}}</span></div>
                </div>
            </a>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="javascripts/filter,javascripts/cloth"/>
</jsp:include>
</fmt:bundle>
