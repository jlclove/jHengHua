<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/include.jsp"%>
<jsp:include page="../common/head.jsp">
    <jsp:param name="title" value="title_enterprise"/>
    <jsp:param name="css" value="account"/>
</jsp:include>
<fmt:bundle basename="site">
    <div class="content account container-fluid">
        <div class="row">
            <div class="col-sm-2">
                <h2 class="titlebar"><fmt:message key="title_account"/></h2>
                <hr>
                <jsp:include page="../common/sidebar-account.jsp"/>
            </div>
            <div class="col-sm-10" id="template">
                <h2 class="titlebar"><fmt:message key="nav_account_profile"/></h2>
                <hr>
                <h4><fmt:message key="message_my_account"/></h4>
                <hr>
                <form class="form-horizontal profile" role="form">
                    <div class="row">
                        <div class="form-group col-sm-6">
                            <label class="col-sm-2 control-label"><fmt:message key="message_account_name"/></label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${session_user.nickname}</p>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-2 control-label"><fmt:message key="message_account_email"/></label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${session_user.email}</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-6">
                            <label class="col-sm-2 control-label"><fmt:message key="message_account_company"/></label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${session_user.companyName}</p>
                            </div>
                        </div>
                        <div class="form-group col-sm-6">
                            <label class="col-sm-2 control-label"><fmt:message key="message_account_phone"/></label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${session_user.mobilePhone}</p>
                            </div>
                        </div>
                    </div>
                </form>
                <hr>
                <a href="javascript:;" class="btn btn-edit pull-right" data-toggle="modal" data-target="#myProfileModal"><fmt:message key="btn_account_edit"/></a>
                <div class="clearfix"></div>

                <h4><fmt:message key="message_change_password"/></h4>
                <hr>
                <form class="form-horizontal profile" role="form">
                    <div class="row">
                        <label class="col-sm-1 control-label"><fmt:message key="message_account_password"/></label>
                        <div class="col-sm-5">
                            <p class="form-control-static">******</p>
                        </div>
                    </div>
                </form>
                <hr>
                <a href="javascript:;" class="btn btn-edit pull-right" data-toggle="modal" data-target="#passwordModal"><fmt:message key="btn_account_edit"/></a>
                <div class="clearfix"></div>
            </div>
        </div>

        <%-- modal --%>
        <div class="modal" id="myProfileModal">
            <div class="modal-dialog modal-lg">
                <form id="accountForm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title"><fmt:message key="nav_account_profile"/></h4>
                    </div>
                    <div class="modal-body">
                        <div id="account-error-msg" class="error-msg alert alert-danger alert-dismissible fade in" role="alert" style="display: none">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                        </div>
                        <div class="form-horizontal" role="form">
                            <div class="row">
                                <div class="form-group">
                                    <label for="nickname" class="col-sm-2 control-label"><fmt:message key="message_account_name"/></label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="nickname" id="nickname" value="${session_user.nickname}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label"><fmt:message key="message_account_email"/></label>
                                    <div class="col-sm-8">
                                        <input type="email" class="form-control" name="email" id="email" value="${session_user.email}">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <label for="companyName" class="col-sm-2 control-label"><fmt:message key="message_account_company"/></label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="companyName" id="companyName" value="${session_user.companyName}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button id="accountBtn" type="submit" class="btn btn-primary" data-loading-text="loading...">Save changes</button>
                    </div>
                </div>
                </form>
            </div>
        </div>

        <div class="modal" id="passwordModal">
            <div class="modal-dialog">
                <form id="passwordForm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title"><fmt:message key="message_change_password"/></h4>
                        </div>
                        <div class="modal-body">
                            <div id="account-error-msg2" class="error-msg alert alert-danger alert-dismissible fade in" role="alert" style="display: none">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                            </div>
                            <div class="form-horizontal" role="form">
                                <div class="row">
                                    <div class="form-group">
                                        <label for="oldPassword" class="col-sm-3 control-label"><fmt:message key="message_account_old_password"/></label>
                                        <div class="col-sm-7">
                                            <input type="password" class="form-control" name="oldPassword" id="oldPassword">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <label for="newPassword" class="col-sm-3 control-label"><fmt:message key="message_account_password"/></label>
                                        <div class="col-sm-7">
                                            <input type="password" class="form-control" name="newPassword" id="newPassword">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group">
                                        <label for="newPassword2" class="col-sm-3 control-label"><fmt:message key="message_account_confirm_password"/></label>
                                        <div class="col-sm-7">
                                            <input type="password" class="form-control" name="newPassword2" id="newPassword2">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button id="passwordBtn" type="submit" class="btn btn-primary" data-loading-text="loading...">Save changes</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        var userId = '${session_user.userId}';
    </script>
    <jsp:include page="../common/foot.jsp">
        <jsp:param name="js" value="javascripts/account"/>
    </jsp:include>
</fmt:bundle>
