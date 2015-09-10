<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="sample"/>
</jsp:include>
<!-- .banner -->
<div class="suits banner container-fluid">
    <div class="col-sm-3 title">了解我们的西装</div>
    <div class="col-sm-4 visible-xs visible-sm sub">了解我们的西装和不同的价格系列</div>
    <div class="col-sm-4 visible-md visible-lg sub mt5">全面了解我们独一无二的优质细节和隐藏特点。</div>
    <div class="col-sm-5 unit-box">
        <div class="unit reverse">
            <a class="unit-link" href="/about-our-suits">了解更多</a>
        </div>
    </div>
</div>
<!-- /.banner -->

<!-- .filter -->
<div class="suits filter-bar" data-spy="affix" data-offset-top="62">
    <div class="filter-btn clearfix">
        <div class="pull-left">
            <a id="filterBtn" class="filter-item animated" href="#"><span>筛选</span><i class="icon-suiticon icon-suiticon-filter-1-1"></i></a>
        </div>
        <%--<div class="pull-right">--%>
            <%--<a class="filter-item animated" href="#"><span class="hidden-xs">排序</span><i class="icon-suiticon icon-suiticon-transfer-7"></i></a>--%>
        <%--</div>--%>
        <%--<div class="pull-right">--%>
            <%--<a class="filter-item animated" href="#"><span class="hidden-xs">显示</span><i class="icon-suiticon icon-suiticon-preview-1"></i></a>--%>
        <%--</div>--%>
    </div>
    <div class="filter-category container-fluid clearfix">
        <div class="row filter-selected-content clearfix">
            <div class="filter-clear btn btn-default">Clear All <i class="close-section close-section--alpha icon-suiticon icon-suiticon-delete-1"></i></div>
            <div class="filter-property"></div>
        </div>
        <div class="row pos-rel">
        <c:forEach items="${clothType}" var="type">
        <div class="filter-category-item">
            <a href="#" class="">${type.key}</a>
            <ul class="list-inline animated">
            <c:forEach items="${type.value}" var="v" varStatus="status">
                <li>
                    <div class="checkbox">
                        <label>
                            <input name="singleCheck" type="checkbox" value="${type.key},${v}">${v}
                        </label>
                    </div>
                </li>
            </c:forEach>
            </ul>
        </div>
        </c:forEach>
        </div>
    </div>
</div>
<!-- /.filter -->

<div class="product-wrap container">
    <div id="list" class="row">
        <c:forEach items="${clothList}" var="cloth" varStatus="s">
        <%--<c:if test="${s.index % 4 == 0}">--%>
            <%--<div class="row">--%>
        <%--</c:if>--%>
            <div class="col-sm-3 product-item">
                <a href="/product/cloth/${cloth.serialNo}">
                    <img src="http://www.jshenghua.com:82/Thumb/${cloth.image}" class="img-responsive" width="100%"/>
                    <div class="product-desc mt10 pl5">
                        <div><span class="head">${cloth.name}</span>  -  <span class="f16">${cloth.serialNo}</span></div>
                    </div>
                </a>
            </div>
        <c:if test="${s.last}">
        <script type="text/javascript">
            var sinceId = '${cloth.id}';
        </script>
        </c:if>
        <%--<c:if test="${s.index % 4 == 3 || s.last}">--%>
            <%--</div>--%>
        <%--</c:if>--%>
        </c:forEach>
    </div>
</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="javascripts/filter,javascripts/cloth"/>
</jsp:include>
