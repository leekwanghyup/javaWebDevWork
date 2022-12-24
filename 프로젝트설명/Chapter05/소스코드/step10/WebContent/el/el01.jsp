<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL표현식</title>
</head>
<body>
<h2>EL - 리터럴 표현식</h2>
<table border="1">
<tr><th>데이터 형</th><th>EL 코드</th><th>실행 결과</th></tr>
<tr><td>문자열</td><td>\${"test"}</td><td>${"test"}</td></tr>
<tr><td>문자열</td><td>\${'test'}</td><td>${'test'}</td></tr>
<tr><td>정수</td><td>\${20}</td><td>${20}</td></tr>
<tr><td>부동소수점</td><td>\${3.14}</td><td>${3.14}</td></tr>
<tr><td>불린</td><td>\${true}</td><td>${true}</td></tr>
<tr><td>널 값</td><td>\${null}</td><td>${null}</td></tr>
</table>

<p><a href="el02.jsp">[다음]</a></p>
</body>
</html>