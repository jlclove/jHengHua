<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/16
  Time: 下午10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp"/>
<div class="login-page center-block">
    <div class="error-msg alert alert-danger alert-dismissible fade in" role="alert" style="display: none">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
        账号或密码不正确，请重新输入
    </div>
    <form id="loginForm">
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码">
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> 下次自动登录
            </label>
                <span class="pull-right">
                    <a href="#">忘记密码</a>
                </span>
        </div>
        <button id="loginBtn" type="submit" class="btn btn-primary btn-block" data-loading-text="登录中...">登录</button>
    </form>
</div>
<jsp:include page="common/foot.jsp"/>
