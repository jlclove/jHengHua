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
            <div class="col-md-6 mb20">
                <img src="http://www.jshenghua.com:82/Detail/${sampleDetail.picPath}" class="img-responsive" width="100%"/>
            </div>
            <div class="col-md-6 f16">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_name"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.nameCn}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_samplename"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.sampleName}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_material"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.material}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_currency"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.currency}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_price"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.price}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_reserve"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.reserve}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_retailunit"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.retailUnit}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_detailname"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.detailName}</p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="javascripts/sampleDetail"/>
</jsp:include>
</fmt:bundle>