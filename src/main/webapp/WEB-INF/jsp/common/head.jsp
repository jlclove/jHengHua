<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0"/>
    <title>This is a header</title>
    <link rel="stylesheet" type="text/css" href="/static/fonts/fonts.css">
    <link rel="stylesheet" type="text/css" href="/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/static/stylesheets/style.css">
    <link rel="stylesheet" type="text/css" href="/static/stylesheets/head.css">
    <link rel="stylesheet" type="text/css" href="/static/stylesheets/foot.css">
    <c:forTokens items="${param.css}" delims="," var="file">
        <link rel="stylesheet" type="text/css" href="/static/stylesheets/${file}.css">
    </c:forTokens>
</head>
<body>
<header class="animated">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed left" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        id="collapse-left">
                    <i class="icon-suiticon icon-suiticon-menu-1"></i>
                </button>
                <a class="navbar-brand" href="/">
                    <img alt="Brand" src="/static/images/logo.png">
                </a>
                <%--<button type="button" class="navbar-toggle collapsed right" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"--%>
                        <%--id="collapse-right">--%>
                    <%--<i class="icon-suiticon icon-suiticon-cart-2"></i>--%>
                <%--</button>--%>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#" data-nav="true">在线购买</a>
                        <!--shop menu begin-->
                        <div class="nav-menu category">
                            <div class="nav-menu-wrap container-fluid">
                                <div class="col-sm-8">
                                    <div class="category-title">产品目录</div>
                                    <ul class="list-unstyled category-list">
                                        <li class="category-item"><a href="/product/sample">面料</a></li>
                                        <li class="category-item"><a href="#"></a></li>
                                        <li class="category-item"><a href="/product/cloth">服装</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-4">
                                    <div class="category-title">特色栏目</div>
                                    <ul class="list-unstyled category-list">
                                        <li class="category-item pr5">
                                            <div class="unit-box">
                                                <a href="/about-our-suits">
                                                    <img src="/static/images/navigation/shop/pre-order.jpg" width="100%"/>
                                                </a>

                                                <div class="unit pos-right pos-top w1of4">
                                                    <span class="unit-title">了解我们的西装</span>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="category-item pr5">
                                            <div class="unit-box">
                                                <a href="#">
                                                    <img src="/static/images/navigation/shop/nav_shirt-configurator_01.jpg" width="100%"/>
                                                </a>

                                                <div class="unit pos-right pos-top w1of4">
                                                    <span class="unit-title">设计您的专属衬衫</span>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!--shop menu end-->
                    </li>
                    <li>
                        <a href="#" data-nav="true">风尚专栏</a>
                        <!--menu begin -->
                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <div class="col-sm-2 unit-box pl10">
                                    <a href="/media">
                                        <img src="/static/images/navigation/stories/what-they-say-about-us.jpg" width="100%"/>
                                        <div class="unit reverse pos-right pos-top w3of8">
                                            <span class="unit-title">媒体报道</span>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-sm-2 unit-box pl10">
                                    <a href="/about-our-suits">
                                        <img src="/static/images/navigation/stories/about_our_suits_1.jpg" width="100%"/>

                                        <div class="unit pos-right pos-top w3of8">
                                            <span class="unit-title">了解我们的西装</span>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-sm-2 unit-box pl10">
                                    <a href="/about-our-shirts">
                                        <img src="/static/images/navigation/stories/about-our-shirts.jpg" width="100%"/>

                                        <div class="unit pos-top pos-left w3of8">
                                            <span class="unit-title">了解我们的衬衫</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <!--menu end-->
                    </li>
                    <li>
                        <a href="#" data-nav="true">专业服务</a>
                        <!--menu begin-->
                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <div class="col-sm-6">
                                    <div class="category-title">专业服务</div>
                                    <ul class="list-unstyled category-list">
                                        <li class="category-item"><a href="service.html">驻店裁缝</a></li>
                                        <li class="category-item"><a href="service.html">支付方式</a></li>
                                        <li class="category-item"><a href="service.html">配送</a></li>
                                        <li class="category-item"><a href="service.html">退换货</a></li>
                                        <li class="category-item"><a href="service.html">常见问题</a></li>
                                        <li class="category-item"><a href="service.html">客户服务</a></li>
                                        <li class="category-item"><a href="service.html">企业团购</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <div class="category-title">联系我们</div>
                                    <ul class="list-unstyled category-list">
                                        <li class="category-item">
                                            <small>免费客服热线</small>
                                        </li>
                                        <li class="category-item">
                                            <small>40088 59421</small>
                                        </li>
                                        <li class="category-item">
                                            <small>周一至周五</small>
                                        </li>
                                        <li class="category-item">
                                            <small>10.00 - 18.00</small>
                                        </li>
                                        <li class="category-item">
                                            <small>(节假日除外)</small>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <div class="category-title">客服邮件</div>
                                    <div>
                                        <p>邮件您的问题和建议至 service@suitsupply.com 我们将于2个工作日内回复您。</p>
                                        <a class="unit-link mt10" href="#">发邮件</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--menu end-->
                    </li>
                    <li>
                        <a href="#" data-nav="true">全球门店</a>
                        <!--menu begin-->
                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <div class="col-sm-6">
                                    <div class="category-title">寻找最近门店</div>
                                    <div class="f18">
                                        <div class="col-sm-4"><a href="#">中国</a></div>
                                        <div class="col-sm-4"><a href="#">意大利</a></div>
                                        <div class="col-sm-4"><a href="#">白俄罗斯</a></div>
                                        <div class="col-sm-4"><a href="#">中国</a></div>
                                        <div class="col-sm-4"><a href="#">意大利</a></div>
                                        <div class="col-sm-4"><a href="#">白俄罗斯</a></div>
                                    </div>
                                </div>
                                <div class="col-sm-3 unit-box pl10">
                                    <div class="category-title">上海公馆旗舰店现已开业！</div>
                                    <a href="#">
                                        <img src="/static/images/navigation/stories/shanghai-opened.jpg" width="100%"/>
                                    </a>
                                </div>
                                <div class="col-sm-3 unit-box pl10">
                                    <div class="category-title">旧金山门店已盛大开幕</div>
                                    <a href="#">
                                        <img src="/static/images/navigation/stories/sanfran-drawing.jpg" width="100%"/>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <!--menu end-->
                    </li>
                    <li>
                        <a href="#" data-nav="true">企业信息</a>
                        <!--menu begin-->
                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <div class="col-sm-6">
                                    <div class="category-title">关于 SUITSUPPLY</div>
                                    <ul class="list-unstyled category-list">
                                        <li class="category-item"><a href="/media">媒体报道</a></li>
                                        <li class="category-item"><a href="/franchise">合作伙伴</a></li>
                                        <li class="category-item"><a href="/news">新闻</a></li>
                                        <li class="category-item"><a href="/career">加入我们</a></li>
                                        <li class="category-item"><a href="/about">关于我们</a></li>
                                        <li class="category-item"><a href="/contact">联系我们</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3 pl10">
                                    <div class="category-title">SUITSUPPLY 职位</div>
                                    <div class="unit-box">
                                        <a href="#">
                                            <img src="/static/images/navigation/company/careers-02.jpg" width="100%"/>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-sm-3 pl10">
                                    <div class="category-title">上海旗舰店：正在招聘</div>
                                    <div class="unit-box">
                                        <a href="#">
                                            <img src="/static/images/navigation/company/shanghai-01.jpg" width="100%"/>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--menu end-->
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#" data-nav="true" class="icon-suiticon icon-suiticon-globe-2"></a>

                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <div class="input-group">
                                    <span class="f16">Choose your shipping destination and language</span>
                                    <div class="custom-select ml10">
                                        <select class="custom-select">
                                            <option>中文</option>
                                            <option>English</option>
                                        </select>
                                    </div>
                                    <a class="unit-link ml10" href="#">CONTINUE</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <a href="#" data-nav="true" class="icon-suiticon icon-suiticon-magnifier-1"></a>

                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <input type="text" class="custom-text" placeholder="输入关键字或商品号"/>
                                <a class="unit-link ml10" href="#">搜索</a>
                            </div>
                        </div>
                    </li>
                    <li><a href="#" class="icon-suiticon icon-suiticon-user-2"></a></li>
                    <%--<li><a href="#" class="icon-suiticon icon-suiticon-cart-2"></a></li>--%>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <div class="nav-menu visible-xs">
        <ul class="list-unstyled">
            <li><a href="#">在线购买</a></li>
            <li><a href="#">风尚专栏</a></li>
            <li><a href="#">专业服务</a></li>
            <li><a href="#">全球门店</a></li>
            <li><a href="#">企业信息</a></li>
        </ul>
    </div>
</header>
<div class="float-bg animated"></div>
<div class="mobile-menu animated">
    <i class="icon-suiticon icon-suiticon-delete-1"></i>

    <%--<div class="mobile-menu-content">--%>
        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>

        <%--<p>hello</p>--%>
    <%--</div>--%>
</div>
