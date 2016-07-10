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
<div class="content container mt20">
    <h3 class="c_black">${cloth.name}</h3>
    <div class="row">
        <div class="col-md-6 mb20">
            <img src="http://www.jshenghua.com:82/Detail/${cloth.desc_png}" class="img-responsive" width="100%"/>
        </div>
        <div class="col-md-6 f16">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="product_cloth_detail_serialNo"/></label>
                    <div class="col-sm-10">
                         <p class="form-control-static">${cloth.serialNo}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="product_cloth_detail_color"/></label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${cloth.mainColor}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="product_cloth_detail_onUnderStyle"/></label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${cloth.onUnderStyle}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="product_cloth_detail_materials"/></label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${cloth.material}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="product_cloth_detail_price"/></label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${cloth.price} <fmt:message key="product_cloth_detail_priceMoney"/>/${cloth.unit }</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="product_cloth_detail_serialno"/></label>
                    <div class="col-sm-10">
                        <p class="form-control-static serialno-container">
                            <c:forTokens items="${cloth.sonCodeList}" delims="," var="s">
                                <span class="product-property-item animated">${s}</span>
                            </c:forTokens>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="product_cloth_detail_size"/></label>
                    <div class="col-sm-10">
                        <p class="form-control-static size-container">
                            <c:forTokens items="${cloth.sizeList}" delims="," var="s">
                                <span class="product-property-item animated">${s}</span>
                            </c:forTokens>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="product_cloth_detail_style"/></label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${cloth.style}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="product_cloth_detail_washing"/></label>
                    <div class="col-sm-10">
                        <p class="form-control-static washing-container">
                        	<c:forEach items="${washingList }" var="w">
                        		<img src="http://www.jshenghua.com:82/${w.png}"></img>
                        	</c:forEach>
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="product_cloth_detail_wearing"/></label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${cloth.wearStyle}</p>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="bower_components/jquery/dist/jquery.min,javascripts/clothDetail"/>
</jsp:include>
</fmt:bundle>
