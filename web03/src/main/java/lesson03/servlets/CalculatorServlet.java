package lesson03.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/calc")
public class CalculatorServlet extends GenericServlet{
	
	// GenericServlet에서 Servlet인터페이스에서 구현해야할 메서드를 미리 구현했기 때문에 
	// init,destory등의 메소드가 필요하지 않다면 service메서드만 구현하면된다. 
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("a=" + a + "," + "b=" + b + "의 계산결과 입니다.");
		writer.println("a + b = " + (a + b));
		writer.println("a - b = " + (a - b));
		writer.println("a * b = " + (a * b));
		writer.println("a / b = " + ((float)a / (float)b));
		writer.println("a % b = " + (a % b));
	}

}