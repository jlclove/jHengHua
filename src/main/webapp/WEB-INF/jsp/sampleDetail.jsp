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
</jsp:include>
<div class="content container mt50 sample-detail-page">
        <div class="row">
            <div class="col-sm-8">
                <span class="f14">编号:</span>
                <i class="f_large ml20 c_black fb">${sampleDetail.cardId}</i>
                <span class="f14 ml30">原料:</span>
                <span class="f20 ml20">${sampleDetail.material}</span>
            </div>
            <div class="col-sm-4 text-right">
                <img src="/static/images/barcode.png"/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-8">
                <span class="f14">幅宽:</span>
                <span class="f20 ml20">57/58"</span>
            </div>
            <div class="col-sm-4 text-right">
                <span class="f16">${sampleDetail.nick}</span>
            </div>
        </div>
        <p class="f14 mt10">柔软而密实的平纹组织融入完美的色彩搭配。英伦休闲范儿十足。</p>
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
        <%--<div class="col-md-6 f16">--%>
            <%--<form class="form-horizontal">--%>
                <%--<div class="form-group">--%>
                    <%--<label class="col-sm-2 control-label">CardId</label>--%>
                    <%--<div class="col-sm-10">--%>
                        <%--<p class="form-control-static">${sampleDetail.cardId}</p>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label class="col-sm-2 control-label">Material</label>--%>
                    <%--<div class="col-sm-10">--%>
                        <%--<p class="form-control-static">${sampleDetail.material}</p>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label class="col-sm-2 control-label">Nick</label>--%>
                    <%--<div class="col-sm-10">--%>
                        <%--<p class="form-control-static">${sampleDetail.nick}</p>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>

</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="bower_components/jquery/dist/jquery.min,javascripts/jquery-barcode.min,javascripts/sampleDetail"/>
</jsp:include>
