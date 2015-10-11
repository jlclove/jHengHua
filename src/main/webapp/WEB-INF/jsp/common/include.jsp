<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 15/9/9
  Time: 下午7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${empty lang}">
  <c:set var="lang" value="cn" scope="request"/>
</c:if>
<fmt:setLocale value="${lang}" scope="request"/>
