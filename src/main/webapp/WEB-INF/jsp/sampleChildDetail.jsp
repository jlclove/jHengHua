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
    <jsp:param name="title" value="在线购买"/>
</jsp:include>
<div class="content container mt50 sample-detail-page">

    <div class="row">
        <div class="col-md-6">
            <img src="http://www.jshenghua.com:82/Detail/${sampleDetail.picPath}" class="img-responsive"/>
        </div>
        <div class="col-md-6 f16">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-4 control-label">Name</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${sampleDetail.nameCn}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">Currency</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${sampleDetail.currency}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">DetailName</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${sampleDetail.detailName}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">Material</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${sampleDetail.material}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">NameEn</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${sampleDetail.nameEn}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">Price</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${sampleDetail.price}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">Reserve</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${sampleDetail.reserve}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">RetailUnit</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${sampleDetail.retailUnit}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">SampleName</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">${sampleDetail.sampleName}</p>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
<jsp:include page="common/foot.jsp"/>
