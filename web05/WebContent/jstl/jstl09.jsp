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
<h2>c:import 태그</h2>

<h3>RSS 피드 가져오기</h3>
<textarea rows="10" cols="80">
<c:import url="https://statmodeling.stat.columbia.edu/feed/"/>
<textarea rows="10" cols="80">${zdnetRSS}</textarea>
</textarea>
</body>
</html>