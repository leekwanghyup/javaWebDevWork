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
<h2>c:forTokens 태그</h2>

<% pageContext.setAttribute("tokens","v1=20&v2=30&op=+"); %>
<ul>
<c:forTokens var="item" items="${tokens}" delims="&">
	<li>${item}</li>	
</c:forTokens>
</ul>
</body>
</html>