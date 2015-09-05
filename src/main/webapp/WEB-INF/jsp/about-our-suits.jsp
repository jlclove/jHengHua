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
</jsp:include>
<div class="content container-fluid">
    <h2>了解我们的西装</h2>
    <div class="row">
        <div class="col-sm-8">
            <div class="fit-header">
                <img src="/static/images/about-suits/header-aos.jpg" class="img-responsive"/>
                <div class="text-right fit-info hidden-xs">
                    想要找到适合的西装，对其有所了解尤为重要。以下我们为您介绍了我们西装独一无二的优质细节和隐藏特点。
                </div>
            </div>
            <h3 class="f20 mt30">“穿着我们量身定制的西装，感受其带来的喜悦。”</h3>
            <p class="mt20">微拱胸袋精巧地呼应了修身版型的流畅轮廓，诸如手缝、功能性纽扣孔这类细节为服装增添了几分奢华质感，而这恰恰能够彰显我们的身份。作为西装爱好者，对设计考究的上衣有一个全面的了解总是好的。</p>
            <div class="row">
                <div class="col-sm-3">
                    <h3>结构</h3>
                    <a href="#" data-toggle="modal" data-target="#video-1">
                        <img src="/static/images/about-suits/video-aos-1.jpg" class="fit-box img-responsive"/>
                    </a>
                    <p>我们的上衣，其内部与外部同样凝聚匠心。一件优秀的上衣并不能轻而易举地获得流畅饱满的外形，衬里令其保持曲线优雅、挺阔有型的关键。作为对老式意大利工艺的致敬，我们采用一层薄薄的马毛加固棉布作为西装衬里。此类帆布可完美贴合穿着者的体形，让上衣更加垂顺合身。</p>
                </div>
                <div class="col-sm-6">
                    <img src="/static/images/about-suits/fit-aos.jpg" class="img-responsive"/>
                </div>
                <div class="col-sm-3">
                    <h3>细节</h3>
                    <p>我们对低调、甚至有时毫不起眼的精致细节毫不马虎，因为除了整体效果之外，细节也是至关重要的。浏览我们的不同西装款型，并了解使之与众不同的精妙细节。</p>
                    <a href="#" data-toggle="modal" data-target="#video-2">
                        <img src="/static/images/about-suits/video-aos-2.jpg" class="fit-box img-responsive"/>
                    </a>
                    <h3>面料</h3>
                    <p>我们的上等面料均产自最受推崇并最负盛名的面料制造厂，它们位于意大利北方地区比耶拉。从Beste到Vitale Barberis Canonico，几世纪来的传统和对工艺的熟练掌握使这些著名意大利纺织厂成为奢华、创新和品质的代表。</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="fit-box fit-sidebar container-fluid">
                <h2 class="mt0">了解我们的款型</h2>
                <p>了解 Suitsupply 的所有款型： 不论是尖翻领或方驳领，单排或双排扣， 经典款或现代款Suitsupply都一应俱全。</p>
                <hr/>
                <div class="fit-classic container-fluid">
                    <div class="col-xs-6 text-right">
                        <div class="f20 mb10 color_blue">CLASSIC</div>
                        <ul class="fit-classic-type list-unstyled f16">
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-hartford.png" class="active">HARTFORD</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-laspalla.png">LA SPALLA</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-lazio.png">LAZIO</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-london.png">YORK</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-sienna.png">SIENNA</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-napoli.png">NAPOLI</a></li>
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
                        <div class="f20 mb10 color_blue">CONTEMPORARY</div>
                        <ul class="fit-classic-type list-unstyled f16">
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-hudson.png" class="active">HUDSON</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-madison.png">MADISON</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-mercer.png">MERCER</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-havana.png">HAVANA</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-washington.png">WASHINGTON</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-soho.png">SOHO</a></li>
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-copenhagen.png">COPENHAGEN</a></li>
                        </ul>
                    </div>
                </div>
                <div class="fit-classic container-fluid">
                    <div class="col-xs-6 text-right">
                        <div class="f20 mb10 color_blue">FORMAL</div>
                        <ul class="fit-classic-type list-unstyled f16">
                            <li><a href="#" data-preview="images/about-suits/fit-sketch-tuxedo.png" class="active">SMOKING</a></li>
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
