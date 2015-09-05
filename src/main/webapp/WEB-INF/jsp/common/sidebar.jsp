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
        <a href="/media" <c:if test="${pageName==\"media\"}">class="selected"</c:if>>媒体报道</a>
    </li>
    <li>
        <a href="/news" <c:if test="${pageName==\"news\"}">class="selected"</c:if>>新闻</a>
    </li>
    <li>
        <a href="/about" <c:if test="${pageName==\"about\"}">class="selected"</c:if>>关于我们</a>
    </li>
    <li>
        <a href="/franchise" <c:if test="${pageName==\"franchise\"}">class="selected"</c:if>>合作伙伴</a>
    </li>
    <li>
        <a href="/career" <c:if test="${pageName==\"career\"}">class="selected"</c:if>>加入我们</a>
    </li>
    <li>
        <a href="/contact" <c:if test="${pageName==\"contact\"}">class="selected"</c:if>>联系我们</a>
    </li>
</ul>
