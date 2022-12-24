<%@page import="spms.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="background-color:#00008b;color:#ffffff;height:20px;padding: 5px;">
	SPMS(Simple Project Management System)

	<!-- 5.6.3  페이지 헤더에 로그인 사용자 이름 출력 -->
	<span style="float:right;">
	<% Member member = (Member)session.getAttribute("member");%>
	<%=member.getName()%>님 로그인 중 ....
		<a style="color:white;" href="<%=request.getContextPath()%>/auth/logout">로그아웃</a> 
	</span>	
</div>