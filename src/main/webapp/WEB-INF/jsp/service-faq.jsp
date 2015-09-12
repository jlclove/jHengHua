<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="service-faq"/>
    <jsp:param name="title" value="企业信息"/>
</jsp:include>
<div class="about-page container-fluid">
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
                    <a href="#">配送</a>
                </li>
                <li>
                    <a href="#">退换货</a>
                </li>
                <li>
                    <a href="#" class="selected">常见问题</a>
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
            <h4>常见问题</h4>
            <div class="faq-category">
                <ul class="list-unstyled clearfix">
                    <li class="">所有问题</li>
                    <li class="w1of2 pull-left selected">企业团购</li>
                    <li class="w1of2 pull-left">配送</li>
                    <li class="w1of2 pull-left">礼品卡</li>
                    <li class="w1of2 pull-left">支付方式</li>
                    <li class="w1of2 pull-left">个人制定</li>
                    <li class="w1of2 pull-left">购买</li>
                    <li class="w1of2 pull-left">退换货</li>
                    <li class="w1of2 pull-left">服务</li>
                    <li class="w1of2 pull-left">尺寸及剪裁</li>
                    <li class="w1of2 pull-left">关税</li>
                    <li class="w1of2 pull-left">网站</li>
                    <li class="w1of2 pull-left">经销商和代理商</li>
                </ul>
            </div>
            <h4 class="mt20">购买资讯</h4>

            <ul class="list-unstyled" id="accordion">
                <li>
                    <a href="#cols1" data-toggle="collapse" data-target="#cols1" data-parent="#accordion">Henghua 销售礼品卡吗？ +</a>
                    <p id="cols1" class="panel-collapse collapse in">Henghua 销售礼品卡吗？ +Henghua 销售礼品卡吗？ +Henghua 销售礼品卡吗？ +</p>
                </li>
                <li>
                    <a href="#cols2" data-toggle="collapse" data-target="#cols2" data-parent="#accordion">Henghua 礼品卡何时过期？ +</a>
                    <p id="cols2" class="panel-collapse collapse">Henghua 销售礼品卡吗？ +Henghua 销售礼品卡吗？ +Henghua 销售礼品卡吗？ +</p>
                </li>
            </ul>

            <!---->
            <!--Henghua 礼品卡能在网店使用吗？ +-->
            <!--为何我的支付失败？ +-->
            <!--Henghua 网购的付款方式包括哪些？-->
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"/>
