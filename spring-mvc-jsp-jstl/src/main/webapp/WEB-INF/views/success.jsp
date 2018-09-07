<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pawel
  Date: 2018-09-06
  Time: 04:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Article added</title>
</head>
<body>
    <c:if test="${not empty article}">
        <h1><c:out value="${article.title}" /></h1>
        <p>
            <c:out value="${article.content}" />
        </p>
        <c:if test="${not empty article.tags}">
            <c:forEach var="tag" items="${article.tags}">
               <li><c:out value="${tag}"/></li>
            </c:forEach>
        </c:if>
    </c:if>
</body>
</html>
