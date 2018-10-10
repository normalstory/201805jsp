package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* BasicServlet.java
*
* @author 변찬우
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* 변찬우  최초 생성
*	현재시간을 출혁하는 hrml 생성하는 서블릿 
* </pre>
*/
public class BasicServlet extends HttpServlet {
	//요청 http 메소드에 따라 실행되는 메소드가 달라진다 
	//Get : doGet
	//Post : doPost
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	///--------
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// HttpServletRequest :요청에 관한 정보 
		// HttpServletResponse : 응답에 관한 정보 
		
		resp.setContentType("text/html; charset=utf-8");
		
		
		PrintWriter pw  = resp.getWriter();
//		pw.println("hello,world");
//		
//		//html : url를 통해 파일 위치 지정 
//		//setvlet : web.xml을 통해 -> servlet 정의 및 setvlet-mapping
//
//		Date date = new Date();
//		pw.println(date);
//		
//		//date fotmat을 이용하요 연월일만 화면에 출력 : simpleDateFormat
		Date date2 = new Date();
		SimpleDateFormat state = new SimpleDateFormat("yyyy-MM-dd");
		String datePrint = state.format(date2);
		//pw.println(datePrint);
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("		<meta charset=\"UTF-8\">");
		pw.println("		<title>Insert title here</title>");
		pw.println("	</head>");			
		pw.println("	<body>");	
		pw.println("		hello,world");
		pw.println("		<br>" + datePrint);
		pw.println("	</body>");
		pw.println("</html>");		
				
		pw.flush();
		pw.close();
		
	}
}
