<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="about-our-suits"/>
    <jsp:param name="title" value="title_stories"/>
</jsp:include>
<div class="content container-fluid">
    <h2>了解我们的面料</h2>
    <div class="row">
        <div class="col-sm-8">
            <div class="fit-header">
                <img style="width:100%" src="/static/images/about-suits/header-aos.jpg" class="img-responsive"/>
                <div class="text-right fit-info hidden-xs">
                    想要找到适合您的面料，对其面料的了解特别重要。以下我们将带您走进我们德唯思现货面料的世界。
                </div>
            </div>
            <h3 class="f20 mt30">“DWINS FABRIC自创始以来一直奉行以高品质面料应对快速市场反应的发展理念。”</h3>
            <p class="mt20">面料作为服装中最重要的组成部件，高品位环保型面料时刻为您品牌服饰埋下愉悦且舒适的穿着感受。</p>
            <div class="row">
                <div class="col-sm-3">
                    <h3>结构</h3>
                    <a href="#" data-toggle="modal" data-target="#video-1">
                        <img src="/static/images/about-suits/video-aos-1.jpg" class="fit-box img-responsive"/>
                    </a>
                    <p>我们的面料，其内部与外部同样凝聚匠心。一件优秀的面料并不能轻而易举地获得流畅饱满的外形，独特的工艺是令其保持曲线优雅、挺阔有型的关键。</p>
                </div>
                <div class="col-sm-6">
                    <img src="/static/images/about-suits/fit-aos.jpg" class="img-responsive"/>
                </div>
                <div class="col-sm-3">
                    <h3>细节</h3>
                    <p>我们对低调、甚至有时毫不起眼的精致细节毫不马虎，因为除了整体效果之外，细节也是至关重要的。浏览我们的不同面料款型，并了解使之与众不同的精妙细节。</p>
                    <a href="#" data-toggle="modal" data-target="#video-2">
                        <img src="/static/images/about-suits/video-aos-2.jpg" class="fit-box img-responsive"/>
                    </a>
                    <h3>纱线</h3>
                    <p>我们的上等纱线均产自最受推崇并最负盛名的纱线制造厂，它们位于世界各地是奢华、创新和品质的代表。</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="fit-box fit-sidebar container-fluid">
                <h2 class="mt0">了解我们的款型</h2>
                <p>了解DWINS FABRIC的所有款型：</p>
                <hr/>
                <div class="fit-classic container-fluid">
                    <div class="col-xs-6 text-right">
                        <div class="f20 mb10 color_blue">了解面料是如何制造而成的？</div>
                        <ul class="fit-classic-type list-unstyled f16">
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-hartford.png" class="active">流行元素的搜集</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-laspalla.png">色彩精准的定位</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-lazio.png">纤维选择</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-london.png">织造工艺制定</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-sienna.png">后整理方案研究</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-napoli.png">成品</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-napoli.png">适应小批次，多花型，现货面料解决方案</a></li>
                        </ul>
                    </div>
                    <div class="col-xs-6">
                        <img src="/static/images/about-suits/fit-sketch-hartford.png" class="fit-classic-img img-responsive"/>
                    </div>
                </div>
                <div class="fit-classic container-fluid">
                    <div class="col-xs-6">
                        <img src="/static/images/about-suits/fit-sketch-hudson.png" class="fit-classic-img img-responsive"/>
                    </div>
                    <div class="col-xs-6">
                        <div class="f20 mb10 color_blue">面料基本属性</div>
                        <ul class="fit-classic-type list-unstyled f16">
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-hudson.png" class="active">国产面料</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-madison.png">进口面料</a></li>
                            <!--  <li><a href="#" data-preview="images/about-suits/fit-sketch-mercer.png">MERCER</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-havana.png">HAVANA</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-washington.png">WASHINGTON</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-soho.png">SOHO</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-copenhagen.png">COPENHAGEN</a></li> -->
                        </ul>
                    </div>
                </div>
                <div class="fit-classic container-fluid">
                    <div class="col-xs-6 text-right">
                        <div class="f20 mb10 color_blue">面料分类管理</div>
                        <ul class="fit-classic-type list-unstyled f16">
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-tuxedo.png" class="active">SHANGHAI</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-tuxedo.png" class="active">LONDON</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-tuxedo.png" class="active">MILANO</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-tuxedo.png" class="active">GUANGZHOU</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-tuxedo.png" class="active">ROTTERDAM</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-tuxedo.png" class="active">MUNICH</a></li>
                        </ul>
                    </div>
                    <div class="col-xs-6">
                        <img src="/static/images/about-suits/fit-sketch-tuxedo.png" class="fit-classic-img img-responsive"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal video-->
<div class="modal fade" id="video-1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <video src="/static/videos/aos-canvas.mp4" controls="controls" width="100%" preload="none"/>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="video-2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <video src="/static/videos/aos-canvas.mp4" controls="controls" width="100%" preload="none"/>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp">
    <jsp:param name="js" value="javascripts/about-suits,bower_components/bootstrap/dist/js/bootstrap.min"/>
</jsp:include>
