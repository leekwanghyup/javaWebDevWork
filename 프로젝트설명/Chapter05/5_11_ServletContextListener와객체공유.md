## 소스코드 
	step11

## 도입 
	- 리스너(Listener) : 특정 이벤트 발생시 알림 기능 제공
	- 서블릿 컨테이너가 알려주는 특정 이벤트 
		웹 애플리케이션 시작 
		세션 : 생성/소멸, 활성/비활성, 데이터바인딩/언바인딩
		요청 : 요청/응답, 데이터바인딩/언바인딩
	- DAO는 여러 서블릿이 사용하는 객체로 공유하는 것이 바람직함 
		DAO객체는 서블릿이 실행되기 전에 준비되어야 함 
		웹 애플리케이션 시작 시점에 DAO객체를 서블릿 컨텍스트에 보관함 
		
## 1. DAO사용하기
	- AppInitServlet에서 수행하던 DAO객체 생성을 리스너로 옮긴다. 
	- ServletContextLisener 구현체 
		애플리케이션 시작 : contextInitailize() 호출
		애플리케이션 종료 : contextDestroyed() 호출
	
## 2. 리스너 ServletContextListener 만들기 
	- spms.listener.ContextLoaderListener : 
	 	ServletContextListener 인터페이스 구현
	 	contextInitailize() : DB 커넥션 생성, MemberDao객체 서블릿 컨텍스트에 보관
	 	contextDestroyed() : 커넥션 객체 리소스 반납 
		ContextLoaderListener 배치 
			1)@WebListener 애노테이션 
			2)DD파일(web.xml)
	
 
## 3. 기본 서블릿 변경하기 
	- MemberServlet 클래스 변경 
		- 기존 코드 삭제 : Connection객체와 MemberDao객체 생성 부분, 
		 	MemberDao는 서블릿 컨텍스트로부터 가져온다.
		 	 
## 4. AppInitServlet 제거
	- DD파일에서 AppInitServlet 배치 정보 제거 
	
## 실력 향상 과제
	-나머지 서블릿들도 코드 변경 
		MemberAddServlet
		MemberUpdateServlet
		MemberDeleteServelt
		LogInServlet  
 