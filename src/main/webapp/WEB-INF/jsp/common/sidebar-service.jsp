<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/5
  Time: 下午2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="sidebar">
    <li>
        <a href="/service/tailor" <c:if test="${pageName==\"tailor\"}">class="selected"</c:if>>驻店裁缝</a>
    </li>
    <li>
        <a href="/service/payment" <c:if test="${pageName==\"payment\"}">class="selected"</c:if>>支付方式</a>
    </li>
    <li>
        <a href="/service/shipment" <c:if test="${pageName==\"shipment\"}">class="selected"</c:if>>配送</a>
    </li>
    <li>
        <a href="/service/return" <c:if test="${pageName==\"return\"}">class="selected"</c:if>>退换货</a>
    </li>
    <li>
        <a href="/service/question" <c:if test="${pageName==\"question\"}">class="selected"</c:if>>常见问题</a>
    </li>
    <li>
        <a href="/service/customer" <c:if test="${pageName==\"customer\"}">class="selected"</c:if>>客户服务</a>
    </li>
    <li>
        <a href="/service/corporate" <c:if test="${pageName==\"corporate\"}">class="selected"</c:if>>企业团购</a>
    </li>
</ul>
