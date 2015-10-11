<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/9
  Time: 下午7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/include.jsp"%>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="sample"/>
    <jsp:param name="title" value="nav_shop"/>
</jsp:include>
<fmt:bundle basename="site">
<div class="sample-detail-bg">
    <div class="content container sample-detail-page">
        <div class="row">
            <div class="col-sm-8">
                <span class="f14"><fmt:message key="product_sample_cardId"/>:</span>
                <i class="f_large ml20 c_black fb">${sampleDetail.cardId}</i>
                <span class="f14 ml30"><fmt:message key="product_sample_marterial"/>:</span>
                <span class="f20 ml20">${sampleDetail.material}</span>
            </div>
            <div class="col-sm-4 text-right" id="qrcode">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-8">
                <span class="f14"><fmt:message key="product_sample_width"/>:</span>
                <span class="f20 ml20">57/58"</span>
            </div>
            <div class="col-sm-4 text-right">
                <span class="f16">${sampleDetail.nick}</span>
            </div>
        </div>
        <p class="f14 mt10"><fmt:message key="product_sample_features"/></p>
        <hr/>
        <div class="row mt20">
            <c:forEach items="${sampleDetail.detailList}" var="detail">
            <div class="col-sm-4 mb15">
                <a href="/product/sample/detail/${detail.sampleName}">
                    <img src="http://www.jshenghua.com:82/Detail/${detail.picPath}" class="img-responsive" width="100%"/>
                </a>
            </div>
            </c:forEach>
        </div>
        <div id="washing-container" class="washing-container mt50 text-right">
            <a class="f14 mr30" href="www.jshenghua.com" target="_blank">www.jshenghua.com</a>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="javascripts/sampleDetail,javascripts/jquery.qrcode.min"/>
</jsp:include>
</fmt:bundle>
<script type="text/javascript">
	$('#qrcode').qrcode({width: 64,height: 64,text: "size doesn't matter"});
</script>
