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
        <button class="btn btn-primary pull-right">
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
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="javascripts/admin/news"/>
</jsp:include>
