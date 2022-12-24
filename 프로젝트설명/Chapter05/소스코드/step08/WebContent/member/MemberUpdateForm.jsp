<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp:useBean태그저거, 표현식을 제거하고 EL 사용-->
<h1>회원정보</h1>
<form action='update' method='post'>
	번호: <input type='text' name='no' value='${member.no}' readonly><br>
	이름: <input type='text' name='name' value='${member.name}'><br>
	이메일: <input type='text' name='email' value='${member.email}'><br>
	가입일: ${member.createdDate}<br>
	<input type='submit' value='저장'>
	<input type='button' value='삭제' onclick='location.href="delete?no=${member.no}";'> 
	<input type='button' value='취소' onclick='location.href="list"'>
</form>
</body>
</html>