<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="service"/>
    <jsp:param name="title" value="企业信息"/>
</jsp:include>
<div class="content container-fluid">
    <h2 class="titlebar">购买指南</h2>
    <div class="row">
        <div class="col-sm-2">
            <ul class="sidebar">
                <li>
                    <a href="#">改衣及定制</a>
                </li>
                <li>
                    <a href="#">安全支付</a>
                </li>
                <li>
                    <a href="#" class="selected">配送</a>
                </li>
                <li>
                    <a href="#">退换货</a>
                </li>
                <li>
                    <a href="#">常见问题</a>
                </li>
                <li>
                    <a href="#">客户服务</a>
                </li>
                <li>
                    <a href="#">企业团购</a>
                </li>
                <li>
                    <a href="#">关于我们</a>
                </li>
            </ul>
        </div>
        <div class="col-sm-8">
            <h4>专业服务</h4>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"/>
