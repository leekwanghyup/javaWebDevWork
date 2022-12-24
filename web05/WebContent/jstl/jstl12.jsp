<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<h2>날짜 다루기</h2>
<h3>fmt:parseDate 태그</h3>
<code>
&lt;fmt:parseDate var="date1" value="2013-11-16" pattern="yyyy-MM-dd"/>
</code>
<fmt:parseDate var="date1" value="2013-11-16" pattern="yyyy-MM-dd"/>

<h3>fmt:formatDate 태그</h3>
<fmt:formatDate value="${date1}" pattern="MM/dd/yy"/> 
</textarea>
</body>
</html>