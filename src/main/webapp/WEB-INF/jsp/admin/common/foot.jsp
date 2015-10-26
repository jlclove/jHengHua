<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/16
  Time: 下午10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp" %>
</body>
<script type="text/javascript" src="/static/bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/bower_components/jquery-validation/dist/jquery.validate.js"></script>
<script type="text/javascript" src="/static/javascripts/underscore-min.js"></script>
<script type="text/javascript" src="/static/javascripts/admin/main.js"></script>
<c:forTokens items="${param.js}" delims="," var="file">
    <script type="text/javascript" src="/static/${file}.js"></script>
</c:forTokens>
<script type="text/javascript">
    function selectLang(lang){
        $.ajax({
            url: '/business/core/localization?lang=' + lang,
            method: 'put',
            success: function(){
                window.location.reload();
            }
        });
    }
</script>
</html>
