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
        <h4 class="pull-left">门店列表
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
        <button class="btn btn-primary pull-right" data-toggle="modal" data-target="#addStoresModal">
            <i class="glyphicon glyphicon-plus"></i> 创建</button>
    </div>
    <div class="row">
        <div class="col-md-2">
            <div class="list-group" id="country">

            </div>
        </div>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>门店名</th>
                            <th>地址</th>
                            <th>省份</th>
                            <th>邮编</th>
                            <th>联系电话</th>
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
    </div>
</div>

<!-- 新增门店表单模板 -->
<div class="modal fade" id="addStoresModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        <form method="post" id="form">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加门店</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="storeName" class="col-sm-2 control-label">国家</label>
                        <div class="col-sm-9">
                            <p type="text" class="form-control-static" id="countryName"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="storeName" class="col-sm-2 control-label">门店名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="storeName" name="storeName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="address" class="col-sm-2 control-label">地址</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="address" name="address">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="province" class="col-sm-2 control-label">省份</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="province" name="province">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="zipCode" class="col-sm-2 control-label">邮编</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="zipCode" name="zipCode">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phone" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="phone" name="phone">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="picPath" class="col-sm-2 control-label">图片</label>
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
                    <hr>
                    <section>
                        <h5>营业时间</h5>
                        <div class="form-group">
                            <label for="workTime1" class="col-sm-2 control-label">周一</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime1From">
                            </div>
                            <div class="col-sm-1">
                                <p class="form-control-static">至</p>
                            </div>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime1To">
                            </div>
                            <input type="hidden" class="form-control" id="workTime1" name="workTime1">
                        </div>
                        <div class="form-group">
                            <label for="workTime2" class="col-sm-2 control-label">周二</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime2From">
                            </div>
                            <div class="col-sm-1">
                                <p class="form-control-static">至</p>
                            </div>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime2To">
                            </div>
                            <input type="hidden" class="form-control" id="workTime2" name="workTime2">
                        </div>
                        <div class="form-group">
                            <label for="workTime3" class="col-sm-2 control-label">周三</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime3From">
                            </div>
                            <div class="col-sm-1">
                                <p class="form-control-static">至</p>
                            </div>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime3To">
                            </div>
                            <input type="hidden" class="form-control" id="workTime3" name="workTime3">
                        </div>
                        <div class="form-group">
                            <label for="workTime4" class="col-sm-2 control-label">周四</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime4From">
                            </div>
                            <div class="col-sm-1">
                                <p class="form-control-static">至</p>
                            </div>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime4To">
                            </div>
                            <input type="hidden" class="form-control" id="workTime4" name="workTime4">
                        </div>
                        <div class="form-group">
                            <label for="workTime5" class="col-sm-2 control-label">周五</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime5From">
                            </div>
                            <div class="col-sm-1">
                                <p class="form-control-static">至</p>
                            </div>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime5To">
                            </div>
                            <input type="hidden" class="form-control" id="workTime5" name="workTime5">
                        </div>
                        <div class="form-group">
                            <label for="workTime6" class="col-sm-2 control-label">周六</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime6From">
                            </div>
                            <div class="col-sm-1">
                                <p class="form-control-static">至</p>
                            </div>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime6To">
                            </div>
                            <input type="hidden" class="form-control" id="workTime6" name="workTime6">
                        </div>
                        <div class="form-group">
                            <label for="workTime7" class="col-sm-2 control-label">周日</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime7From">
                            </div>
                            <div class="col-sm-1">
                                <p class="form-control-static">至</p>
                            </div>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="workTime7To">
                            </div>
                            <input type="hidden" class="form-control" id="workTime7" name="workTime7">
                        </div>
                    </section>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
            <input type="hidden" name="id" id="id" value="0">
            <input type="hidden" name="picPath" id="picPath">
            <input type="hidden" name="countryId" id="countryId">
            <input type="hidden" name="type" value="媒体">
            <%--<input type="hidden" name="type" id="type" value="新闻">--%>
        </form>
        </div>
    </div>
</div>
<!-- 新增新闻表单模板 -->
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="bower_components/upload/js/vendor/jquery.ui.widget,bower_components/upload/js/jquery.fileupload,javascripts/admin/stores"/>
</jsp:include>
