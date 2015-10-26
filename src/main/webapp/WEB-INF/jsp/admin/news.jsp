<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/16
  Time: 下午10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp"/>
<div class="container">
    <div class="clearfix">
        <h4 class="pull-left">新闻列表
            <div class="dropdown" style="display: inline-block;margin-left: 10px;">
                <button class="btn btn-sm btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    ${languages[lang]}
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <c:forEach items="${languages}" var="language">
                        <li><a href="javascript:selectLang('${language.key}')">${language.value}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </h4>
        <button class="btn btn-primary pull-right" data-toggle="modal" data-target="#addNewsModal">
            <i class="glyphicon glyphicon-plus"></i> 创建</button>
    </div>
    <div class="panel panel-default">
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>编号</th>
                        <th>标题</th>
                        <th>外链</th>
                        <th>创建时间</th>
                        <th>创建人</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody id="listContainer">
                </tbody>
            </table>
        </div>
    </div>
    <nav class="text-right">
        <ul class="pagination" id="pagination">

        </ul>
    </nav>
</div>

<!-- 新增新闻表单模板 -->
<div class="modal fade" id="addNewsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        <form action="/business/news" method="post" id="form">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加新闻</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="title" class="col-sm-2 control-label">主标题</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="title" name="title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="subtitle" class="col-sm-2 control-label">子标题</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="subtitle" name="subtitle">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="link" class="col-sm-2 control-label">链接</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="link" name="link" placeholder="输入链接地址会使新闻直接跳转到目标链接地址而看不到详情哦">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="type" class="col-sm-2 control-label">类型</label>
                        <div class="col-sm-3">
                            <%--<input type="text" id="type" name="type">--%>
                                <select name="type" id="type" class="form-control">
                                <c:forEach items="${newsType}" var="type">
                                    <option value="${type}">${type}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fileupload" class="col-sm-2 control-label">图片</label>
                        <div class="col-sm-3">
                            <span class="btn btn-success btn-block fileinput-button">
								<i class="glyphicon glyphicon-plus"></i>
								<span>上传图片</span>
                                <%--<form method="post">--%>
                                    <input id="fileupload" type="file" name="file" data-url="/business/file" multiple>
                                <%--</form>--%>
							</span>
                        </div>
                        <div class="col-sm-7">
                            <p class="form-control-static" id="filename"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="content" class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-9">
                            <div id="editor" style="width:100%;height:200px;"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
            <input type="hidden" name="id" id="id" value="0">
            <input type="hidden" name="pics" id="pics">
            <%--<input type="hidden" name="type" id="type" value="新闻">--%>
        </form>
        </div>
    </div>
</div>
<!-- 新增新闻表单模板 -->

<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="bower_components/upload/js/vendor/jquery.ui.widget,bower_components/upload/js/jquery.fileupload,bower_components/ueditor/ueditor.config,bower_components/ueditor/ueditor.all.min,javascripts/admin/news"/>
</jsp:include>
