<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer class="footer">
    <section class="footer-section pt50 pb50 text-center">
        <h2>
            <span class="color_blue">掌握最新资讯</span>
        </h2>
        <h4>订阅邮件，立即尊享 Suitsupply 最新产品信息</h4>

        <form class="email-form mt30">
            <input type="email" placeholder="输入邮件地址"/>
            <input type="button" class="btn-submit transition"/>
        </form>
    </section>

    <section class="footer-section white container-fluid">
        <div class="col-sm-4">
            <div class="media usp center-block">
                <div class="media-left">
                    <img src="/static/images/shipping.png"/>
                </div>
                <div class="media-body">
                    <div class="color_blue">免费配送</div>
                    <div class="small">3000元起免运费</div>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="media usp center-block">
                <div class="media-left">
                    <img src="/static/images/contact.png"/>
                </div>
                <div class="media-body">
                    <div class="color_blue">需要帮助？</div>
                    <div class="small">免费客服热线 40088 59421</div>
                    <a class="small" href="#">邮件客服.</a>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="media usp center-block">
                <div class="media-left">
                    <img src="/static/images/returns.png"/>
                </div>
                <div class="media-body">
                    <div class="color_blue">免费退换货</div>
                    <div class="small">或许您改变了主意？可以30日内免费退换货。</div>
                </div>
            </div>
        </div>
    </section>

    <section class="footer-section container-fluid pt50 pb120">
        <ul class="help-bar col-sm-7 pl100 list-inline clearfix">
            <li class="help-bar-link"><a href="#">隐私声明</a></li>
            <li class="help-bar-link"><a href="#">购买条款</a></li>
            <li class="help-bar-link"><a href="#">购买指南</a></li>
            <li class="help-bar-link"><a href="#">沪ICP备13019284</a></li>
        </ul>

        <ul class="social-bar col-sm-5 pl100 list-inline clearfix">
            <li class="pull-left">关注我们</li>
            <li><a href="#" class="social-icon social-wechat"></a></li>
            <li><a href="#" class="social-icon social-weibo"></a></li>
            <li><a href="#" class="social-icon social-youku"></a></li>
            <li><a href="#" class="social-icon social-tudou"></a></li>
        </ul>

        <ul class="pay-bar col-sm-5 pl100 mt30 list-inline clearfix">
            <li><a href="#" class="pay-icon pay-mastercard"></a></li>
            <li><a href="#" class="pay-icon pay-visa"></a></li>
            <li><a href="#" class="pay-icon pay-ali"></a></li>
            <li><a href="#" class="pay-icon pay-union"></a></li>
        </ul>
    </section>
</footer>
</body>
<script type="text/javascript" src="/static/bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript">
    $('a[data-nav]').click(function(e){
        var current = $(this).parent().find('.nav-menu-wrap');
        var visible = current.data('visible');
        closeMenu();
        if(!visible) {
            current.css('marginTop', 0).addClass('active');
            current.data('visible', true);
        }
        e.preventDefault();
        return false;
    });
    function closeMenu() {
        $('.nav-menu-wrap').each(function(i, e){
            if($(e).data('visible')) {
                $(e).css('marginTop', -$(e).outerHeight()).removeClass('active');
                $(e).data('visible', false);
            }
        });
    }
    $(document).click(function(e){
        if($(e.target).closest('.navbar').length == 0) {
            closeMenu();
        }
    });
    $('#collapse-left').click(function(){
        $('header').css('transform', 'translate3d(80%,0,0)');
        $('.mobile-menu').css('transform', 'translate3d(0,0,0)');
        $('.float-bg').addClass('visible');
//        setTimeout(function(){
//            $('.float-bg').addClass('visible');
//        }, 300);
    });
    $('.float-bg').click(function(){
        $('header').css('transform', 'translate3d(0,0,0)');
        $('.mobile-menu').css('transform', 'translate3d(-100%,0,0)');
        $('.float-bg').removeClass('visible');
//        setTimeout(function(){
//            $('.float-bg').css('zIndex', -1);
//        }, 300);
    });
</script>

<c:forTokens items="${param.js}" delims="," var="file">
    <script type="text/javascript" src="/static/${file}.js"></script>
</c:forTokens>
</html>
