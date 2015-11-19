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
        <c:forEach items="${sampleList}" var="sample" varStatus="s">
            <div class="col-sm-4 product-item">
                <a href="/product/sample/${sample.cardId}">
                    <div class="clearfix">
                    <c:forEach items="${sample.detailList}" var="detail" begin="0" end="2">
                        <div class="w1of3 pull-left pl5 pr5">
                            <img src="http://www.jshenghua.com:82/Thumb/${detail.picPath}" class="img-responsive" width="100%"/>
                        </div>
                    </c:forEach>
                    </div>
                    <div class="product-desc mt10 pl5">
                        <div><span class="head">${sample.cardId}</span>  -  <span class="f16">${sample.nick}</span>  -  <span class="f16">${sample.material}</span></div>
                        <%--<div class="pb10">${sample.}</div>--%>
                        <%--<div class="head">¥7,180 CNY</div>--%>
                    </div>
                </a>
            </div>
            <c:if test="${s.last}">
                <script type="text/javascript">
                    var sinceId = '${sample.id}';
                </script>
            </c:if>
        </c:forEach>
    </div>
</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="javascripts/filter,javascripts/sample"/>
</jsp:include>
<script type ="text/javascript">
	$(document).ready(function() {
		
		//alert('${indexType}');
		if('${indexType}' == '1')
			$('[name=singleCheck][value="原料,全棉"]').click();
		if('${indexType}' == '2')
			$('[name=singleCheck][value="原料,毛"]').click();
		if('${indexType}' == '3')
			$('[name=singleCheck][value="原料,竹纤维"]').click();
		if('${indexType}' == '4')
			$('[name=singleCheck][value="原料,莫代尔"]').click();
		if('${indexType}' == '5')
			$('[name=singleCheck][value="织物名称,朝阳条格"]').click();
		if('${indexType}' == '6')
			$('[name=singleCheck][value="织物名称,牛津纺"]').click();
		if('${indexType}' == '7')
			$('[name=singleCheck][value="原料,全麻"]').click();
		if('${indexType}' == '8')
			$('[name=singleCheck][value="原料,全毛"]').click();
	})
</script>

</fmt:bundle>
