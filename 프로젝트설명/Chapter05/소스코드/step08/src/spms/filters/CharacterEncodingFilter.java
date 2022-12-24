package spms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = "/*", initParams = {
		@WebInitParam(name = "encoding", value = "utf-8")
})
public class CharacterEncodingFilter implements Filter{

	FilterConfig config; 
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 사전 작업 : 요청 필터
		request.setCharacterEncoding(config.getInitParameter("encoding")); // 필터배치정보에서 초기화변수 설정
		chain.doFilter(request, response);
		// 사후 작업 : 응답 필터 
	}

	@Override
	public void destroy() {
		
	}
}
