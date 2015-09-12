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
<div class="content container mt20">
    <h3 class="c_black">${cloth.name}</h3>
    <div class="row">
        <div class="col-md-6">
            <img src="http://www.jshenghua.com:82/Detail/${cloth.image}" class="img-responsive" width="100%"/>
        </div>
        <div class="col-md-6 f16">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">BarCode</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${clothDetail.barCode}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Category</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${clothDetail.category}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Color</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${clothDetail.color}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">fabricNo</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${clothDetail.fabricNo}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Materials</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${clothDetail.materials}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">RetailPrice</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${clothDetail.retailPrice}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">SerialNo</label>
                    <div class="col-sm-10">
                        <p class="form-control-static serialno-container">
                            <c:forTokens items="${clothDetail.serialNo}" delims="," var="s">
                                <span class="product-property-item animated">${s}</span>
                            </c:forTokens>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Size</label>
                    <div class="col-sm-10">
                        <p class="form-control-static size-container">
                            <c:forTokens items="${clothDetail.size}" delims="," var="s">
                                <span class="product-property-item animated">${s}</span>
                            </c:forTokens>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Style</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${clothDetail.style}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Washing</label>
                    <div class="col-sm-10">
                        <p class="form-control-static washing-container">
                            <c:forTokens items="${clothDetail.washing}" delims="," var="w">
                                <img src="http://www.jshenghua.com:82/${washingMap[w]}"></img>
                            </c:forTokens>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Wearing</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${clothDetail.wearing}</p>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="bower_components/jquery/dist/jquery.min,javascripts/clothDetail"/>
</jsp:include>
