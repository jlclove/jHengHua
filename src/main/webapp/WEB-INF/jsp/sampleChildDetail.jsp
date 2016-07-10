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
                <img src="http://www.jshenghua.com:82/Detail/${sampleDetail.desc_png}" class="img-responsive" width="100%"/>
            </div>
            <div class="col-md-6 f16">
                <form class="form-horizontal">
               	   <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_detailId"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.detailId}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_cardId"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.cardIds}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_name"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.nameCn}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_material"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.material}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_level"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.level}</p>
                        </div>
                    </div> 
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_style"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.style}</p>
                        </div>
                    </div> 
                     <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_fabrics"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.fabrics}</p>
                        </div>
                    </div> 
                     <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_gramWeight"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.gramWeight}</p>
                        </div>
                    </div> 
                     <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_clearTypes"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.clearTypes}</p>
                        </div>
                    </div> 
                     <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_colorTypes"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static">${sampleDetail.colorTypes}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><fmt:message key="product_sample_detail_quantity"/></label>
                        <div class="col-sm-8">
                            <p class="form-control-static"><span id="stock">0</span> <span id="unit"></span></p>
                        </div>
                    </div>

                <%--    <div class="form-group">
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
                    </div>--%>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    var detailId = '${sampleDetail.detailId}';
</script>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="javascripts/sampleDetail"/>
</jsp:include>
</fmt:bundle>