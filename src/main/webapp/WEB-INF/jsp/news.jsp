<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="news"/>
    <jsp:param name="title" value="企业信息"/>
</jsp:include>
<div class="news-page container-fluid">
    <h2 class="titlebar">新闻</h2>
    <div class="row">
        <div class="col-sm-8">
            <div class="news-box">
                <img src="/static/images/news/gq-shelflife/gq-shelflife-big.jpg" class="img-responsive"/>
                <div class="news-info animated">
                    <a href="#">
                        <p>“驻店裁缝，HENGHUA正以全新的零售体验征服全世界”</p>
                        <div class="text-right">“HENGHUA，整合直营的一站式西服专家，让你看上去完美无瑕！”</div>
                    </a>
                </div>
            </div>
            <div class="news-list row mt30 news-left">
                <div class="col-sm-6">
                    <a href="#">
                        <img src="/static/images/news/spring-summer-2015/ss15collection_newitems_429x230.jpg" class="img-responsive"/>
                        <p class="title">2015 春夏广告大片</p>
                        <div class="date">二月 19, 2015</div>
                        <p>2015春夏系列广告，欧洲品牌HENGHUA携荷兰知名摄影大师Carli Hermes长途跋涉来到南半球被誉为南非之母的神奇土地——开普敦城，在好望角的悬崖边进行了一场唯美的水下拍摄。</p>
                        <span class="arrow-right">更多信息</span>
                    </a>
                </div>
                <div class="col-sm-6">
                    <a href="#">
                        <img src="/static/images/news/store-opening-singapore/singapore.jpg" class="img-responsive"/>
                        <p class="title">HENGHUA 新加坡店铺开业</p>
                        <div class="date">十月 14, 2014</div>
                        <span class="arrow-right">更多信息</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="col-sm-4 news-right">
            <h4>新闻</h4>
            <ul class="list-unstyled news-list">
                <li>
                    <a href="">“驻店裁缝，HENGHUA正以全新的零售体验征服全世界” </a> 六月 25, 2015
                </li>
                <li>
                    <a href="#">HENGHUA荣获2015欧洲电子商务峰会多渠道拓展（OMNICHANNEL）组金奖</a> 六月 15, 2015
                </li>
                <li>
                    <a href="#">HENGHUA进驻BLOOMINGDALE'S百货</a> 五月 10, 2015
                </li>
                <li>
                    <a href="#">2015 春夏广告大片</a> 二月 19, 2015
                </li>
                <li>
                    <a href="#">HENGHUA 新加坡店铺开业</a> 十月 14, 2014
                </li>
            </ul>

            <h4 class="mt50">前5条热门新闻</h4>
            <ul class="list-unstyled news-list">
                <li>
                    <a href="#">华尔街日报：制作考究的西装 </a>四月 14, 2011
                </li>
                <li>
                    <a href="#">十款低于1000美元的最佳西装 </a>一月 17, 2014
                </li>
                <li>
                    <a href="#">独家预览：HENGHUA 2015春夏系列 </a>七月 11, 2014
                </li>
                <li>
                    <a href="#">HENGHUA 2014 秋冬系列广告片——“独”有的气质！ </a>九月 3, 2014
                </li>
            </ul>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"/>
