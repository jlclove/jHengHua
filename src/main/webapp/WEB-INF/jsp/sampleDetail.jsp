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
                <div class="row">
                    <div class="col-sm-6">
                        <span class="f14"><fmt:message key="product_sample_cardId"/>:</span>
                        <i class="f_large ml20 c_black fb">${sample.cardId}</i>
                    </div>
                    <%-- <div class="col-sm-6">
                        <span class="f14"><fmt:message key="product_sample_marterial"/>:</span>
                        <span class="f20 ml20">${sampleDetail.material}</span>
                    </div> --%>
                </div>
            </div>
            <div class="col-sm-4 text-right" id="qrcode">
            </div>
            <div class="col-sm-8">
                <span class="f14"><fmt:message key="product_sample_marterial"/>:</span>
                <span class="f20 ml20">${sample.material }</span>
            </div>
            <div class="col-sm-4 text-right">
                <span class="f16">${sample.nick}</span>
            </div>
        </div>
        <p class="f14 mt10"><fmt:message key="product_sample_features"/>:</span><span class="f20 ml20">${sample.descCn }</span></p>
        <hr/>
        <div class="row mt20">
            <c:forEach items="${sample.detailList}" var="detail">
            <div class="col-sm-4 mb15">
                <a href="/product/sample/detail/${detail.detailId}?cardId=${sample.cardId}">
                    <img src="http://www.jshenghua.com:82/Detail/${detail.desc_png}" class="img-responsive" width="100%"/>
                    <p style="margin-top: 10px;text-align: center">${detail.level}-${detail.cardIds.split('-')[1]}</p>
                </a>
            </div>
            </c:forEach>
        </div>
       <!--  <div id="washing-container" class="washing-container mt50 text-right">
            <a class="f14 mr30" href="www.jshenghua.com" target="_blank">www.jshenghua.com</a>
        </div> -->
    </div>
</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="javascripts/jquery.qrcode.min"/>
</jsp:include>
</fmt:bundle>
<script type="text/javascript">
	$('#qrcode').qrcode({width: 64,height: 64,text: "size doesn't matter"});
</script>
