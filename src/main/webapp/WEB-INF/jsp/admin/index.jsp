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
        <h4 class="pull-left">新闻列表</h4>
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
                            <input type="text" class="form-control" id="link" name="link">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pics" class="col-sm-2 control-label">图片</label>
                        <div class="col-sm-9">
                            <input type="file" id="pics" name="pics">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="content" class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-9">
                            <textarea id="content" name="content" class="form-control" rows="5"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
            <input type="hidden" name="id" id="id" value="0">
            <input type="hidden" name="type" id="type" value="新闻">
        </form>
        </div>
    </div>
</div>
<!-- 新增新闻表单模板 -->

<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="javascripts/admin/news"/>
</jsp:include>
