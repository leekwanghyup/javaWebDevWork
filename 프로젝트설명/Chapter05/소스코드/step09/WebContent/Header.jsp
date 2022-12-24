<%@page import="spms.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 세션스코프에서 member객체를 얻어옴 -->
<jsp:useBean id="member" class="spms.vo.Member" type="spms.vo.Member" scope="session" />

<div style="background-color:#00008b;color:#ffffff;height:20px;padding: 5px;">
	SPMS(Simple Project Management System)
	
	<% if(member.getEmail()!=null) { // 로그인을 하지 않은 경우 사용자 정보를 출력하지 않음%>
	<span style="float:right;">
		<%=member.getName()%>님 로그인 중 ....
		<a style="color:white;" href="<%=request.getContextPath()%>/auth/logout">로그아웃</a> 
	</span>
	<%}%>	
</div>