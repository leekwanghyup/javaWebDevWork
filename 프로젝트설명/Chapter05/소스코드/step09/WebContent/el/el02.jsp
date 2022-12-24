<%@page import="java.util.ResourceBundle"%>
<%@page import="spms.vo.Member"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 데이터 준비
	pageContext.setAttribute("scores", new int[]{90,80,70,100});
	List<String> nameList = new LinkedList<String>();
	nameList.add("홍길동");
	nameList.add("임꺽정");
	nameList.add("일지매");
	pageContext.setAttribute("nameList", nameList);

	Map<String,String> map = new HashMap<String,String>();
	map.put("s01", "홍길동");
	map.put("s02", "임꺽정");
	map.put("s03", "일지매");
	pageContext.setAttribute("map", map);

	pageContext.setAttribute("member", 
	new Member().setNo(100).setName("홍길동").setEmail("hong@test.com"));
	// 경로 지정 :  패키지포함 클래스명 
	pageContext.setAttribute("myRB", ResourceBundle.getBundle("bundle.test.MyResourceBundle"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="el01.jsp">[이전]</a><a href="el03.jsp">[다음]</a></div>
<h2>EL - 값 꺼내기</h2>
<table border="1">
	<tr>
		<th>대상</th>
		<th>EL 코드</th>
		<th>설명</th>
	</tr>
	<tr>
		<td>리스트</td>
		<td>\${myList[2]}</td>
		<td>List 객체에서 인덱스로 지정된 항목의 값을 꺼낸다.
		<div>
			[실행 결과] : \${nameList[1]} = ${nameList[1]}
		</div>
		</td>
	</tr>
	<tr>
		<td>맵</td>
		<td>\${myMap.keyName}</td>
		<td>Map 객체에서 키에 해당하는 값을 꺼낸다.
			<div>[실행 결과] : \${map.s02} = ${map.s02}</div>
		</td>
	</tr>
	<tr>
		<td>자바빈</td>
		<td>\${myObj.propName}</td>
		<td>자바 객체에서 프로퍼티의 값을 꺼낸다.
			<div>[실행 결과] : \${member.email} = ${member.email}</div>
		</td>
	</tr>
	<tr>
		<td>리소스 번들</td><td>\${myRB.keyName}</td>
		<td>ResourceBundle 객체에서 키에 해당하는 값을 꺼낸다.
		<div>[실행 결과] :\${myRB.OK} = ${myRB.OK}</div>
		</td>
	</tr>
</table>
<div><a href="el01.jsp">[이전]</a><a href="el03.jsp">[다음]</a></div>
</body>
</html>