package lesson03.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorld implements Servlet{ // 서블릿 클래스는 Servlet인터페이스를 구현해야함
	
	// 서블릿 생명주기 관련 메서드 : init, service, destory
	// 서블릿 정보 관련 메서드 : getServletConfig, getServletInfo
	
	ServletConfig config; // 서블릿 설정 정보 
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 생성 후 초기화 작업을 수행하기 위해 호출 
		System.out.println("init()호출됨");
		config = this.config;
	}
	
	@Override
	public void destroy() {
		// 서블릿컨테이너가 종료 또는 멈추었을 때, 해당 서블릿을 비활성화 시킬때 호출
		// 서비스 수행을 위해 확보했던 자원 해제 또는 데이터 저장 등 마무리 작업 
		System.out.println("destroy()호출됨");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 클라이언트가 요청할 때 마다 호출되는 메서드 
		// 실제 서비스 작업을 수행하는 메서드이다. 
		System.out.println("service()호출됨");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// ServletConfig 객체 반환 : 서블릿 이름, 초기매개변수값, 서블릿 환경정보 등
		System.out.println("getServletConfig()호출");
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// 서블릿을 작성한 사람에 대한 정보, 서블릿 버전, 권리 등을 담은 문자열 반환
		System.out.println("getServletInfo()호출됨");
		return "version=1.0;author=leekwanghyup;copyright=leekwanghyup2018";
	}
}