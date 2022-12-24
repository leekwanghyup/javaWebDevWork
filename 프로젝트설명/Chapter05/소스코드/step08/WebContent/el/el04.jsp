<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<body>
<p><a href="el03.jsp">[이전]</a></p>
<h2>예약된 키워드</h2>
<table border="1">
	<tr>
		<td>and</td>
		<td>or</td>
		<td>not</td>
		<td>eq</td>
	</tr>
	<tr>
		<td>ne</td>
		<td>lt</td>
		<td>gt</td>
		<td>le</td>
	</tr>
	<tr>
		<td>ge</td>
		<td>true</td>
		<td>false</td>
		<td>null</td>
	</tr>
	<tr>
		<td>instanceof</td>
		<td>empty</td>
		<td>div</td>
		<td>mod</td>
	</tr>
</table>
<%
	pageContext.setAttribute("ne", "오호라!");
%>
<%-- EL 예약키워드를 보관소 객체의 식별자로 지정하면 JSP페이지에서 사용할 수 없다.  
	${ne} 
--%>
<p><a href="el03.jsp">[이전]</a></p>
</body>
</html>