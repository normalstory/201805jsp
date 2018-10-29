package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ParameterWrapper extends HttpServletRequestWrapper{

	private Map<String, String[]> newMap;
	
	public ParameterWrapper(HttpServletRequest request) {
		super(request);
		
		// 재정의를 위해 맵객체 가져옮
		newMap =new HashMap<String, String[]>(request.getParameterMap());
	}
	
	//새로운 파라미터 저장
	public void setParameter(String key, String[] values){
		newMap.put(key, values);
	}
	
	//Parameter 관련 메소드 재정의
	//getParameter(String name);
	//getParameterValeus(String name);
	//getParameterMap();
	//getParameterNames();

	@Override
	public Map<String, String[]> getParameterMap() {
		return newMap;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		return newMap.get(name);
	}
	
	@Override
	public String getParameter(String name) {	
		//배열인데 반환이 string이니까.. 문자열 배열에 첫번째만 리턴 but 널 이슈 고려
		String[] values = newMap.get(name);
		if(values ==null){
			return null;
		}
		return values[0];
	}
	
	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(newMap.keySet());
	}

}
