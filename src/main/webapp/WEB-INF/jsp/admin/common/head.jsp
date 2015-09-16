<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/16
  Time: 下午10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0"/>
    <title>${param.title} - 江苏恒华实业纺织面料服饰</title>
    <link rel="stylesheet" type="text/css" href="/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/static/stylesheets/admin/main.css">
    <c:forTokens items="${param.css}" delims="," var="file">
    <link rel="stylesheet" type="text/css" href="/static/stylesheets/admin/${file}.css">
    </c:forTokens>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">后台管理系统</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">新闻</a></li>
                    <li class=""><a href="#">媒体</a></li>
                    <li class=""><a href="#">用户</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <p class="navbar-text">
                        <span class="mr10"><c:if test="${not empty user}">欢迎你，${user.mobilePhone}</c:if></span>
                        <i class="glyphicon glyphicon-share-alt"></i>
                        <a href="/" class="navbar-link">网站</a>
                    </p>
                </ul>
            </div>
        </div>
    </nav>
