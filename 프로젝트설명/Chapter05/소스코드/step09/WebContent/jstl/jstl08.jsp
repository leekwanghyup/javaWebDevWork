<%@page import="java.util.ArrayList"%>
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
<h2>c:url 태그</h2>

<c:url var="calcUrl" value="/calc">
	<c:param name="v1" value="20"/>
	<c:param name="v2" value="30"/>
	<c:param name="op" value="+"/>
</c:url>
<a href="${calcUrl}">계산하기</a>
</body>
</html>