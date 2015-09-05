<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="media"/>
</jsp:include>
<div class="media-page container-fluid">
    <h4 class="text-center titlebar">媒体报道</h4>
    <h4 class="text-center segment-line"><span>媒体</span></h4>

    <div class="row mt30">
        <div class="col-sm-4">
            <a class="media-name" href="#">华尔街日报</a>
            <hr/>
            <p class="media-content">
                "高品质的面料，轻柔舒适结构。‘极力注重细节’ [...] $614 [Sienna款] Suitsupply 西装与 $3.625 Armani 西装品质完全相同。"
            </p>
            <small>华尔街日报，2011年4月14日，©版权所有2013道琼斯公司。</small>
        </div>
        <div class="col-sm-4">
            <a class="media-name" href="#">纽约日报</a>
            <hr/>
            <p class="media-content">
                “对于纽约来说是一个新的概念，虽然Suitsupply已经成立十年了。面料令人印象十分深刻，面料来自意大利著名纺织厂，由其它国家制成[...];并配有立等可取的改衣服务。
            </p>
            <small>纽约时报，2012年1月31日©版权所有2013年纽约时报公司。</small>
        </div>
        <div class="col-sm-4">
            <a class="media-name" href="#">纽约杂志</a>
            <hr/>
            <p class="media-content">
                纽约最好的”[...]“店铺陈列在太多选择与选择不够之间完美平衡，是物超所值的选择。”
            </p>
            <small>纽约杂志，2012 ©版权所有2013年纽约媒体公司。</small>
        </div>
    </div>
    <div class="row mt30">
        <div class="col-sm-4">
            <a class="media-name" href="#">GQ男装</a>
            <hr/>
            <p class="media-content">
                "我们钟爱Suitsupply 对”酷“品牌的明确定位”
            </p>
            <small>GQ男装，2012年6月26日©版权所有2013康泰纳仕。</small>
        </div>
        <div class="col-sm-4">
            <a class="media-name" href="#">ESQUIRE</a>
            <hr/>
            <p class="media-content">
                “如果你想实现这些人展现的轻松风格”
            </p>
            <small>时尚先生，2013年2月19日©版权所有2013赫斯特通信。</small>
        </div>
        <div class="col-sm-4">
            <a class="media-name" href="#">名利场</a>
            <hr/>
            <p class="media-content">
                "他们的理念是把无可挑剔的剪裁（帆布结构，手缝肩，手工缝制细节）与更现代的审美意识以及合体的版型完美结合"
            </p>
            <small>名利场，2012年9月12日©版权所有2013康泰纳仕。</small>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"/>
