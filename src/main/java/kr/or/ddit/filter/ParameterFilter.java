package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ParameterFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//새로운 파라미터 추가하기위해 
		//chain.doFilter로 다음 요청이 가기전에 
		//리퀘스트 파라미터 추가가 안되니까.. 새로 만든(수정한 리퀘스트 객체, 리퀘스트 인자로하는 ParameterWrapper 사용
		ParameterWrapper pw = new ParameterWrapper((HttpServletRequest) request);
		//이제 새로운 파라미터 추가
		pw.setParameter("newParameter in doFilter", new String[]{"brown","cony","sally"});
		//리퀘스트 파라미터 추가가 안되니까.. 리퀘스트 대신, 새로운 리퀘스트 인자로하는 ParameterWrapper 사용
		chain.doFilter(pw, response);
	}

	@Override
	public void destroy() {
	}

}
