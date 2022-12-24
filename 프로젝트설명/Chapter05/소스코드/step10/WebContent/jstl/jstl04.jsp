<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<div></div><a href="jstl03.jsp">[이전]</a><a href="jstl05.jsp">[다음]</a></div>

<h2>c:if 태그</h2>

<c:if test="${10 > 20}" var="result1">
	1) 10은 20보다 크다.<br>
</c:if>

2) ${result1}<br>

<c:if test="${10 < 20}" var="result2">
	3) 10은 20보다 크다.<br>
</c:if>

4) ${result2}<br>

<p><a href="jstl03.jsp">[이전]</a><a href="jstl05.jsp">[다음]</a></p>
</body>
</html>