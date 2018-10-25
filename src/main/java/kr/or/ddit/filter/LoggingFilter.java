package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoggingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("1전처리 ");
		
		// 적용할 다른 필터가 있으면
		// 1. 해당 필터로 요청을 넘기고
		// 2. 없으면 원래 요청한 서블릿/jsp로 요청을 이관
		chain.doFilter(request, response);
		
		System.out.println("3후처리 ");
	}

	@Override
	public void destroy() {
	}
	
}
