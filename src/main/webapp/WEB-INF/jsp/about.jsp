<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp">
    <jsp:param name="css" value="about"/>
</jsp:include>
<div class="about-page container-fluid">
    <h2 class="titlebar">关于我们</h2>

    <div class="row">
        <div class="col-sm-2">
            <jsp:include page="common/sidebar.jsp"/>
        </div>
        <div class="col-sm-8">
            <h4>品牌理念</h4>

            <p>Suitsupply 是一个引领市场潮流、全球迅速发展的品牌。</p>

            <p>我们是行业先锋，突破陈规，并矢志坚持这一理念。创新精神为我们源源不断地带来新能量，让我们将全新的创意付诸实践。</p>

            <p>我们的优势在于我们的服务准则：坦率真诚、迅捷高效，给予顾客中肯建议但同时尊重个人选择；将精湛工艺与独特创意完美结合。</p>

            <p>我们心无旁骛、专心致志地为顾客服务；时刻让客人感受焦点服务。而我们也为独树一帜、有追求和理想的未来焦点人物而设。</p>
            <br/>
            <h4>企业社会责任</h4>

            <p>Suitsupply 致力于可持续的经营方式；因此，我们仅与达到国际劳工组织认可标准的工厂合作：</p>
            <ul>
                <li>无强制劳动</li>
                <li>无歧视</li>
                <li>无童工</li>
                <li>可自由成立工会，拥有集体谈判的权利</li>
                <li>满足家庭基本需要的工资</li>
                <li>无过度加班</li>
                <li>健康与安全的工作环境</li>
                <li>合法雇佣合同</li>
            </ul>
            <p>Suitsupply 是公平服装基金会（FWF）成员，该组织提倡在服装工厂建立良好工作环境。作为独立的机构，FWF 检查供应商遵守 "服装行业行为准则" 的程度。</p>

            <p>此外，Suitsupply 经常审查自己的供应商，并在必要时实施改进。你可以在2014年里找到更多我们关于这方面的努力。 品牌经营绩效考察 及 媒体报道.</p>

            <p>我们相信，质量不仅局限于服装，还包含制作的方式。更多关于公平服装基金会请查看: <a href="www.fairwear.nl">www.fairwear.nl.</a></p>
        </div>
    </div>
</div>
<jsp:include page="common/foot.jsp"/>
