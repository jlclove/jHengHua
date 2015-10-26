<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp"%>
<fmt:bundle basename="site">
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0"/>
    <title><fmt:message key="${param.title}"/> - <fmt:message key="companyname"/></title>
    <link rel="stylesheet" type="text/css" href="/static/build/css/all.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <%--<link rel="stylesheet" type="text/css" href="/static/fonts/fonts.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="/static/bower_components/bootstrap/dist/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="/static/bower_components/font-awesome/css/font-awesome.min.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="/static/stylesheets/style.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="/static/stylesheets/head.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="/static/stylesheets/foot.css">--%>
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
                <button id="top-nav" type="button" class="navbar-toggle collapsed left" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        id="collapse-left">
                    <i class="icon-suiticon icon-suiticon-menu-1"></i>
                </button>
                <a class="navbar-brand" href="/">
                    HENGHUA
                    <%--<img alt="Brand" src="/static/images/logo.png">--%>
                </a>
                <button type="button" class="navbar-toggle collapsed right">
                    <a class="btnAccount icon-suiticon icon-suiticon-user-2"></a>
                </button>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#" data-nav="true"><fmt:message key="nav_shop"/></a>
                        <!--shop menu begin-->
                        <div class="nav-menu category">
                            <div class="nav-menu-wrap container-fluid">
                                <div class="col-sm-8">
                                    <div class="category-title hidden-xs"><fmt:message key="nav_shop_category"/></div>
                                    <ul class="list-unstyled category-list">
                                        <li class="category-item"><a href="/product/sample"><fmt:message key="nav_shop_category_sample"/></a></li>
                                        <li class="category-item hidden-xs"><a href="#"></a></li>
                                        <li class="category-item"><a href="/product/cloth"><fmt:message key="nav_shop_category_cloth"/></a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-4">
                                    <div class="category-title hidden-xs"><fmt:message key="nav_shop_features"/></div>
                                    <ul class="list-unstyled category-list">
                                        <li class="category-item visible-xs">
                                            <a href="/about-our-suits"><fmt:message key="nav_shop_features_suit"/></a></li>
                                        </li>
                                        <li class="category-item last visible-xs">
                                            <a href="/about-our-shirts"><fmt:message key="nav_shop_features_shirt"/></a></li>
                                        </li>
                                        <li class="category-item pr5 hidden-xs">
                                            <div class="unit-box">
                                                <a href="/about-our-suits">
                                                    <img src="/static/images/navigation/shop/pre-order.jpg" width="100%"/>
                                                </a>

                                                <div class="unit pos-right pos-top w1of4">
                                                    <span class="unit-title"><fmt:message key="nav_shop_features_suit"/></span>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="category-item pr5 hidden-xs">
                                            <div class="unit-box">
                                                <a href="#">
                                                    <img src="/static/images/navigation/shop/nav_shirt-configurator_01.jpg" width="100%"/>
                                                </a>

                                                <div class="unit pos-right pos-top w1of4">
                                                    <span class="unit-title"><fmt:message key="nav_shop_features_shirt"/></span>
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
                        <a href="#" data-nav="true"><fmt:message key="nav_stories"/></a>
                        <!--menu begin -->
                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <ul class="list-unstyled category-list visible-xs">
                                    <li class="category-item visible-xs">
                                        <a href="/media"><fmt:message key="nav_stories_media"/></a></li>
                                    </li>
                                    <li class="category-item visible-xs">
                                        <a href="/about-our-suits"><fmt:message key="nav_stories_suit"/></a></li>
                                    </li>
                                    <li class="category-item last visible-xs">
                                        <a href="/about-our-shirts"><fmt:message key="nav_stories_shirt"/></a></li>
                                    </li>
                                </ul>
                                <div class="col-sm-2 unit-box pl10 hidden-xs">
                                    <a href="/media">
                                        <img src="/static/images/navigation/stories/what-they-say-about-us.jpg" width="100%"/>
                                        <div class="unit reverse pos-right pos-top w3of8">
                                            <span class="unit-title"><fmt:message key="nav_stories_media"/></span>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-sm-2 unit-box pl10 hidden-xs">
                                    <a href="/about-our-suits">
                                        <img src="/static/images/navigation/stories/about_our_suits_1.jpg" width="100%"/>

                                        <div class="unit pos-right pos-top w3of8">
                                            <span class="unit-title"><fmt:message key="nav_stories_suit"/></span>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-sm-2 unit-box pl10 hidden-xs">
                                    <a href="/about-our-shirts">
                                        <img src="/static/images/navigation/stories/about-our-shirts.jpg" width="100%"/>

                                        <div class="unit pos-top pos-left w3of8">
                                            <span class="unit-title"><fmt:message key="nav_stories_shirt"/></span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <!--menu end-->
                    </li>
                    <li>
                        <a href="#" data-nav="true"><fmt:message key="nav_service"/></a>
                        <!--menu begin-->
                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <div class="col-sm-6">
                                    <div class="category-title hidden-xs"><fmt:message key="nav_service"/></div>
                                    <ul class="list-unstyled category-list">
                                        <li class="category-item"><a href="/service/tailor"><fmt:message key="nav_service_tailor"/></a></li>
                                        <li class="category-item"><a href="/service/payment"><fmt:message key="nav_service_payment"/></a></li>
                                        <li class="category-item"><a href="/service/shipment"><fmt:message key="nav_service_shipment"/></a></li>
                                        <li class="category-item"><a href="/service/return"><fmt:message key="nav_service_return"/></a></li>
                                        <li class="category-item"><a href="/service/question"><fmt:message key="nav_service_question"/></a></li>
                                        <li class="category-item"><a href="/service/customer"><fmt:message key="nav_service_customer"/></a></li>
                                        <li class="category-item last"><a href="/service/corporate"><fmt:message key="nav_service_corporate"/></a></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <!--menu end-->
                    </li>
                    <li>
                        <a href="#" data-nav="true"><fmt:message key="nav_stores"/></a>
                        <!--menu begin-->
                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <ul class="list-unstyled category-list visible-xs f18">
                                    <li class="category-item"><a href="#"><fmt:message key="nav_stores_china"/></a></li>
                                    <li class="category-item"><a href="#"><fmt:message key="nav_stores_italy"/></a></li>
                                    <li class="category-item"><a href="#"><fmt:message key="nav_stores_russia"/></a></li>
                                    <li class="category-item">
                                        <a href="#" class="category-item">
                                            <div class="category-title"><fmt:message key="nav_stores_open_shanghai"/></div>
                                            <img src="/static/images/navigation/stories/shanghai-opened.jpg" width="100%"/>
                                        </a>
                                    </li>
                                    <li class="category-item last">
                                        <a href="#">
                                            <div class="category-title"><fmt:message key="nav_stores_open_san_francisco"/></div>
                                            <img src="/static/images/navigation/stories/sanfran-drawing.jpg" width="100%"/>
                                        </a>
                                    </li>
                                </ul>
                                <div class="col-sm-6 hidden-xs">
                                    <div class="category-title"><fmt:message key="nav_stores_nearby"/></div>
                                    <div class="f18">
                                        <div class="col-sm-4"><a href="#"><fmt:message key="nav_stores_china"/></a></div>
                                        <div class="col-sm-4"><a href="#"><fmt:message key="nav_stores_italy"/></a></div>
                                        <div class="col-sm-4"><a href="#"><fmt:message key="nav_stores_russia"/></a></div>
                                    </div>
                                </div>
                                <div class="col-sm-3 unit-box pl10 hidden-xs">
                                    <div class="category-title"><fmt:message key="nav_stores_open_shanghai"/></div>
                                    <a href="#" class="category-item">
                                        <img src="/static/images/navigation/stories/shanghai-opened.jpg" width="100%"/>
                                    </a>
                                </div>
                                <div class="col-sm-3 unit-box pl10 hidden-xs">
                                    <div class="category-title"><fmt:message key="nav_stores_open_san_francisco"/></div>
                                    <a href="#">
                                        <img src="/static/images/navigation/stories/sanfran-drawing.jpg" width="100%"/>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <!--menu end-->
                    </li>
                    <li>
                        <a href="#" data-nav="true"><fmt:message key="nav_company"/></a>
                        <!--menu begin-->
                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <div class="col-sm-6">
                                    <div class="category-title hidden-xs"><fmt:message key="nav_company_about"/></div>
                                    <ul class="list-unstyled category-list">
                                        <li class="category-item"><a href="/media"><fmt:message key="nav_company_media"/></a></li>
                                        <li class="category-item"><a href="/enterprise/franchise"><fmt:message key="nav_company_franchise"/></a></li>
                                        <li class="category-item"><a href="/news"><fmt:message key="nav_company_news"/></a></li>
                                        <li class="category-item"><a href="/enterprise/career"><fmt:message key="nav_company_career"/></a></li>
                                        <li class="category-item"><a href="/enterprise/about"><fmt:message key="nav_company_about_us"/></a></li>
                                        <li class="category-item last"><a href="/enterprise/contact"><fmt:message key="nav_company_contact"/></a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3 hidden-xs">
                                    <div class="category-title hidden-xs"><fmt:message key="nav_company_contact"/></div>
                                    <ul class="list-unstyled category-list">
                                        <li class="category-item">
                                            <small><fmt:message key="nav_company_contact_text1"/></small>
                                        </li>
                                        <li class="category-item">
                                            <small>40088 59421</small>
                                        </li>
                                        <li class="category-item">
                                            <small><fmt:message key="nav_company_contact_text2"/></small>
                                        </li>
                                        <li class="category-item">
                                            <small>10.00 - 18.00</small>
                                        </li>
                                        <li class="category-item">
                                            <small><fmt:message key="nav_company_contact_text3"/></small>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-sm-3 hidden-xs">
                                    <div class="category-title hidden-xs"><fmt:message key="nav_company_contact_text4"/></div>
                                    <div>
                                        <p><fmt:message key="nav_company_contact_text5"/></p>
                                        <a class="unit-link mt10" href="#"><fmt:message key="nav_company_contact_text6"/></a>
                                    </div>
                                </div>
                                <%--<div class="col-sm-3 pl10">--%>
                                    <%--<div class="category-title">SUITSUPPLY 职位</div>--%>
                                    <%--<div class="unit-box">--%>
                                        <%--<a href="#">--%>
                                            <%--<img src="/static/images/navigation/company/careers-02.jpg" width="100%"/>--%>
                                        <%--</a>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<div class="col-sm-3 pl10">--%>
                                    <%--<div class="category-title">上海旗舰店：正在招聘</div>--%>
                                    <%--<div class="unit-box">--%>
                                        <%--<a href="#">--%>
                                            <%--<img src="/static/images/navigation/company/shanghai-01.jpg" width="100%"/>--%>
                                        <%--</a>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
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
                                    <span class="f16"><fmt:message key="choose_language"/></span>
                                    <div class="custom-select ml10">
                                        <select id="selectLang" class="custom-select">
                                            <c:forEach items="${languages}" var="language">
                                                <option value="${language.key}" <c:if test="${language.key==lang}"> selected="selected"</c:if> > ${language.value}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <a class="unit-link ml10 text-center" href="javascript:selectLang()"><fmt:message key="choose_language_button"/></a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <a href="#" data-nav="true" class="icon-suiticon icon-suiticon-magnifier-1"></a>

                        <div class="nav-menu">
                            <div class="nav-menu-wrap container-fluid">
                                <div class="input-group">
                                    <input type="text" class="custom-text" placeholder="<fmt:message key="nav_search_text"/>"/>
                                    <a class="unit-link ml10 text-center" href="#"><fmt:message key="nav_search_btn"/></a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="hidden-xs"><a href="#" class="btnAccount icon-suiticon icon-suiticon-user-2"></a></li>
                    <%--<li><a href="#" class="icon-suiticon icon-suiticon-cart-2"></a></li>--%>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <%--<div class="nav-menu visible-xs">--%>
        <%--<ul class="list-unstyled">--%>
            <%--<li><a href="#">在线购买</a></li>--%>
            <%--<li><a href="#">风尚专栏</a></li>--%>
            <%--<li><a href="#">专业服务</a></li>--%>
            <%--<li><a href="#">全球门店</a></li>--%>
            <%--<li><a href="#">企业信息</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
</header>
<div class="float-bg animated"></div>
<!-- Modal login-->
<div class="pop-modal login-modal modal fade" id="popModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body" id="loginBody">
                <div class="clearfix mb10">
                    <span class="f20 c_black pull-left"><fmt:message key="login_title"/></span>
                    <span class="pull-right"><fmt:message key="login_no_account"/><a href="#" class="red loginOrRegist"><fmt:message key="login_regist"/></a></span>
                </div>
                <div class="error-msg alert alert-danger alert-dismissible fade in" role="alert">
                    <%--<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>--%>
                    <fmt:message key="login_failed"/>
                </div>
                <form class="mt20" id="loginForm">
                    <div class="form-group with-icon">
                        <i class="fa fa-mobile"></i>
                        <input type="text" class="form-control" name="userId" placeholder="<fmt:message key="login_userid_hint"/>">
                    </div>
                    <div class="form-group with-icon">
                        <i class="fa fa-lock"></i>
                        <input type="password" class="form-control" name="password" placeholder="<fmt:message key="login_pwd_hint"/>">
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> <fmt:message key="login_auto_submit"/>
                        </label>
                        <a href="#" class="pull-right"><fmt:message key="login_forgot"/></a>
                    </div>
                    <button id="btn-login" class="btn btn-success btn-large btn-block" type="submit" data-loading-text="<fmt:message key="login_doing"/>"><fmt:message key="login_go"/></button>
                </form>
            </div>

            <div class="modal-body" id="registBody" style="display: none">
                <div class="clearfix mb10">
                    <span class="f20 c_black pull-left"><fmt:message key="regist_title"/></span>
                    <span class="pull-right"><fmt:message key="regist_has_account"/><a href="#" class="red loginOrRegist"><fmt:message key="regist_login"/></a></span>
                </div>
                <div class="error-msg alert alert-danger alert-dismissible fade in" role="alert"></div>
                <form class="mt20" id="registForm">
                    <div class="form-group">
                        <input type="text" class="form-control" name="mobilePhone" placeholder="<fmt:message key="regist_mobile_hint"/>">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="nickname" placeholder="<fmt:message key="regist_nickname_hint"/>">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" placeholder="<fmt:message key="regist_pwd_hint"/>">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password2" placeholder="<fmt:message key="regist_pwd_again_hint"/>">
                    </div>
                    <button id="btn-regist" class="btn btn-success btn-large btn-block" data-loading-text="<fmt:message key="regist_doing"/>"type="submit"><fmt:message key="regist_go"/></button>
                </form>
            </div>
        </div>
    </div>
</div>
<%--<div class="login-modal modal fade" id="registModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">--%>
    <%--<div class="modal-dialog" role="document">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-body">--%>
                <%--<div class="clearfix mb10">--%>
                    <%--<span class="f20 c_black pull-left">新用户注册</span>--%>
                    <%--<span class="pull-right">已有账号？<a href="#" class="red loginOrRegist">马上登录</a></span>--%>
                <%--</div>--%>
                <%--<div class="error-msg alert alert-danger alert-dismissible fade in" role="alert"></div>--%>
                <%--<form class="mt20" id="registForm">--%>
                    <%--<div class="form-group">--%>
                        <%--<input type="text" class="form-control" name="mobilePhone" placeholder="请输入手机号码">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input type="text" class="form-control" name="nickname" placeholder="昵称">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input type="password" class="form-control" name="password" placeholder="请输入密码">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<input type="password" class="form-control" name="password2" placeholder="请确认新密码">--%>
                    <%--</div>--%>
                    <%--<button id="btn-regist" class="btn btn-success btn-large btn-block" data-loading-text="注册中..."type="submit">立即注册</button>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
</fmt:bundle>
