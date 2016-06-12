<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/12
  Time: 下午10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp"%>
<fmt:bundle basename="site">
<div class="suits filter-bar" data-spy="affix" data-offset-top="62">
    <div class="filter-btn clearfix">
        <div class="pull-left">
            <a id="filterBtn" class="filter-item animated" href="#">
                <span><fmt:message key="product_filter_text"/></span>
                <i class="icon-suiticon icon-suiticon-filter-1-1"></i>
                <span class="tip">1</span>
            </a>
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
            <div class="filter-clear btn btn-default">Clear All <i
                    class="close-section close-section--alpha icon-suiticon icon-suiticon-delete-1"></i></div>
            <div class="filter-property"></div>
        </div>
        <div class="row pos-rel">
            <c:forEach items="${filters}" var="filter">
                <div class="filter-category-item">
                    <a href="#" class="">${filter.text}</a>
                    <ul class="list-inline animated">
                        <c:forEach items="${filter.values}" var="v" varStatus="status">
                            <li>
                                <div class="checkbox">
                                    <label>
                                        <input name="singleCheck" type="checkbox" value="${filter.column},${v},${filter.text}" data-multi="${multiColumns.contains(filter.column)}">${v}
                                    </label>
                                </div>
                            </li>
                        </c:forEach>
                        <li>
                            <c:if test="${multiColumns.contains(filter.column)}">
                                <a href="javascript:;" class="btn-confirm unit-link ml10"><fmt:message key="product_filter_ok"/></a>
                            </c:if>
                        </li>
                    </ul>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</fmt:bundle>
