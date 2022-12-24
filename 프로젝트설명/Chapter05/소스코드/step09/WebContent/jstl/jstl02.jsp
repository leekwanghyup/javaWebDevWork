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
<div><a href="jstl01.jsp">[이전]</a><a href="jstl02s.jsp">[다음]</a></div>
<h2>c:set 태그</h2>
<h3>값 설정 방식</h3>
<c:set var="username1" value="홍길동"/> <!-- value속성 -->
<c:set var="username2">임꺽정</c:set> <!-- 태그로 감싸기 -->
1) ${username1}<br>
2) ${username2}<br>

<h3>기본 보관소 - page</h3>
3) ${pageScope.username1}<br> <!-- 스코프 미지정시 pageContext에 저장된다. -->
4) ${requestScope.username1}<br>

<h3>보관소 지정 - scope 속성</h3>
<c:set var="username3" scope="request">일지매</c:set>
5) ${pageScope.username3}<br>
6) ${requestScope.username3}<br> 

<h3>기존의 값 덮어씀</h3>
<% pageContext.setAttribute("username4", "똘이장군"); %>
7) 기존 값=${username4}<br>
<c:set var="username4" value="주먹대장"/>
8) 덮어쓴 값=${username4}<br>
</body>
</html>