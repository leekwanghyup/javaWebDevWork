<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	MyMember member = new MyMember();
	member.setNo(100);
	member.setName("홍길동");
	pageContext.setAttribute("member", member); 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<div><a href="jstl02.jsp">[이전]</a><a href="jstl03.jsp">[다음]</a></div>
	9) 기존값 : ${member.name}<br>
	<c:set target="${member}" property="name" value="임꺽정"/>
	10) 변경된 값 : ${member.name}<br>
</body>
</html>
<%!
	public class MyMember {
		int no;
		String name;
		
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
%>