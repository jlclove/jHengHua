<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="about-our-shirts"/>
    <jsp:param name="title" value="title_stories"/>
</jsp:include>
<div class="content container-fluid">
    <div class="unit-box row">
        <a href="#">
            <img src="/static/images/about-shirts/main-image-v8.jpg" width="100%" class="img-responsive"/>
        </a>
        <div class="unit about-shirts-header">
            <div class="unit-title">
                <div>了解我们的衬衫</div>
            </div>
            <p class="mt15 hidden-xs">我们的衬衫分为三种系列：蓝标、紫标和红标；每一种系列都有其独到的用料选择和细节处理，面料均来自世界顶级的纺织厂。</p>
        </div>
    </div>
    <div class="row block-alpha">
        <div class="wrapper">
            <div class="unit-title">我们的衬衫款型</div>
            <div class="container-fluid">
                <div class="col-xs-6">
                    <img src="/static/images/about-shirts/fits-CN.png" class="img-responsive"/>
                </div>
                <div class="col-xs-6">
                    <p class="mt30">我们的常规剪裁在整个胸部和衣袖处比较宽松，在腰部则略微收紧。我们的修身剪裁衬衫的胸部和臀部较为纤细，腰部呈略微锥形造型。极致修身款型非常贴身，衣袖更为狭窄，袖孔位置稍高。</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="wrapper">
            <div class="unit-title">我们的衬衫系列</div>
            <img src="/static/images/about-shirts/our-lines-CN.jpg" class="img-responsive"/>
        </div>
    </div>
    <div class="row block-alpha">
        <div class="wrapper">
            <div class="container-fluid">
                <div class="col-xs-6 text-right mt150">
                    <div class="unit-title">BLUE LINE 蓝标系列</div>
                    <p class="mt30">Blue Line 蓝标系列衬衫由长绒棉纤维，编织成耐用的双股纱，该流程使用多重捻纱工艺来制成纱线，以增加布料的强度。除此之外，我们的 Blue Line 蓝标系列衬衫拥有多款精致造型，既美观又舒适。</p>
                    <a href="#" class="unit-link mt40 f14">探索蓝标BLUE LINE系列</a>
                </div>
                <div class="col-xs-6 pl50">
                    <img src="/static/images/about-shirts/blue-line-v2.png" class="img-responsive"/>
                </div>
            </div>
        </div>
        <div class="container pb50">
            <div class="title">蓝标细节</div>
            <div class="row">
                <div class="col-sm-4">
                    <img src="/static/images/about-shirts/blue-details-1.jpg" class="img-responsive"/>
                    <p class="mt20 f16">肩部分割轭确保可方便活动</p>
                </div>
                <div class="col-sm-4">
                    <img src="/static/images/about-shirts/blue-details-2.jpg" class="img-responsive"/>
                    <p class="mt20 f16">我们的有柄纽扣可增加其牢固性，防止纽扣掉落。</p>
                </div>
                <div class="col-sm-4">
                    <img src="/static/images/about-shirts/blue-details-3.jpg" class="img-responsive"/>
                    <p class="mt20 f16">超细缝合工艺（每厘米高达 8 针）使面料更耐穿，做工更精细。</p>
                </div>
            </div>
            <div class="text-center">
                <a href="#" class="unit-link mt40 f14">购买衬衫</a>
            </div>
        </div>
    </div>

</div>
<jsp:include page="common/foot.jsp"/>
