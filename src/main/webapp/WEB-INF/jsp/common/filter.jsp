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
<div id="filter" class="suits filter-bar" data-spy="affix" data-offset-top="${fn:length(exhibitions) > 0 ? '92' : '62'}">
    <div class="filter-btn clearfix">
        <div class="pull-left">
            <a id="filterBtn" v-on:click="toggleFilter" class="filter-item animated" href="javascript:;">
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
            <div class="filter-clear btn btn-default" v-on:click="clearAll">Clear All <i
                    class="close-section close-section--alpha icon-suiticon icon-suiticon-delete-1"></i></div>
            <div class="filter-property"></div>
        </div>
        <div class="row pos-rel">
            <div class="filter-category-item" v-for="filter in filters">
                <a href="javascript:;" class="" v-on:click="toggleMenuItem">{{filter.text}}</a>
                <ul class="list-inline animated">
                    <li v-for="v in filter.values">
                        <div class="checkbox">
                            <label>
                                <input v-on:click="check" checked="{{(filter.column=='fabrics'&&fabrics==v)||(filter.column=='materialTypes'&&materialTypes.split(',').indexOf(v)>=0)}}" name="singleCheck" type="checkbox" value="{{filter.column}},{{v}},{{filter.text}}" data-multi="{{filter.multiOption}}">{{v}}
                            </label>
                        </div>
                    </li>
                    <%--<li>--%>
                        <%--<a v-if="filter.multiOption" v-on:click="search" href="javascript:;" class="btn-confirm unit-link ml10"><fmt:message key="product_filter_ok"/></a>--%>
                    <%--</li>--%>
                </ul>
            </div>
        </div>
    </div>
</div>
<script>
    var keyword = '${param.keyword}';
    var materialTypes = '${param.materialTypes}';
    var fabrics = '${param.fabrics}';
</script>
</fmt:bundle>
