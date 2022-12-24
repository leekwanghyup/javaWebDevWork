## 소스코드 
	step09
	
## 1. JSTL 라이브러리 준비 

## 2. JSTL 주요 태그 사용법 
	- 사용할 태그 라이브러리 선언
	- JSTL 태그
	- c:out 
		/WebContent/jstl/jstl01.jsp : 값 출력
		/WebContent/jstl/jstl02.jsp : 값 저장 
		/WebContent/jstl/jstl02s.jsp : 객체의 프로퍼티 값 변경
	- c:remove
		/WebContent/jstl/jstl03.jsp : 보관소에 저장된 값 제거
	- c:if 
		/WebContent/jstl/jstl04.jsp : 조건문 
	- c:choose 
		/WebContent/jstl/jstl05.jsp  : 조건문 
	- c:forEach
		/WebContent/jstl/jstl06.jsp : 반복문
	- c:forToken
	 	/WebContent/jstl/jstl07.jsp : 반복문
	- c:url 
		/WebContent/jstl/jstl08.jsp : 요청주소와 쿼리스트링 
	- c:import 
		/WebContent/jstl/jstl09.jsp : RSS피드 가져오기 
	- c:redirect
		/WebContent/jstl/jstl10.jsp : 리다이렉트
		/WebContent/jstl/jstl11.jsp :
	-fmt:formatDate 
		/WebContent/jstl/jstl12.jsp :

## 3. 회원목록페이지에서 자바코드 없애기 
	- /WebContent/memberMemberList.jsp
		+ 태그라이브러리 선언
		+ jsp: useBean삭제
		+ 자바코드 제거

  