package lesson03.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/test01")
public class ServletRequestAndResponse extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain"); // 출력 데이터의 인코딩 형식과 문자집합 지정
		response.setCharacterEncoding("utf-8"); // 출력 데이터의 문자집합 지정, 기본값 ISO-8859-1
		PrintWriter out = response.getWriter(); // 출력 스트림 객체 반환, 출력데이터의 인코딩과 문자집합을 지정 후 정의해야함 
		ServletOutputStream outputStream = response.getOutputStream(); // 이미지 또는 동영상인 경우 출력 스트림
		
		System.out.println(request.getRemoteAddr()); // 클라이언트의 IP주소 반환
		System.out.println(request.getScheme()); // 클라이언트가 요청한 URI 형식 scheme반환
		System.out.println(request.getProtocol()); // 요청프로토콜의 이름과 버전
		
		Enumeration<String> parameterNames = request.getParameterNames(); // 요청정보의 매개변수 이름만 추출하여 반환 
		String[] parameterValues = request.getParameterValues("hobby"); // 요청정보의 매개변수값만 추출하여 반환
		Map<String,String[]> parameterMap = request.getParameterMap(); // 모든 매개변수이름과 값을 Map객체에 담아 반환
		System.out.println(parameterMap.keySet()); // 매개변수 이름
		System.out.println(Arrays.toString(parameterMap.get("hobby"))); // 매개변수 이름에 해당하는 매개변수값 
	}
}
