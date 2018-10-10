package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//사용자가 보낸 파라미터를 전부 화면에 출력 
public class LoginServlet extends HttpServlet {
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//
//		PrintWriter pw  = resp.getWriter();
//		String[] userIdValues =req.getParameterValues("userId");
//		//Map<String,String[]> requestMap = req.getParameterMap();
//		
//		pw.println("<!DOCTYPE html>");
//		pw.println("	<html>");
//		pw.println("	<head>");
//		pw.println("		<meta charset=\"UTF-8\">");
//		pw.println("		<title>Insert title here</title>");
//		pw.println("	</head>");			
//		pw.println("	<body>");	
//		
//		for(String str:userIdValues ){
//			pw.println("	userID   : "+ req.getParameter("userId"));
//			pw.println("	<br>");
//		}
//			pw.println("	password : "+ req.getParameter("password"));	
//		
//		pw.println("	</body>");
//		pw.println("</html>");		
//				
//		pw.flush();
//		pw.close();
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter pw  = resp.getWriter();
		
		String[] userIdValues =req.getParameterValues("userId");
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("	<head>");
		pw.println("		<meta charset=\"UTF-8\">");
		pw.println("		<title>Insert title here</title>");
		pw.println("	</head>");			
		pw.println("	<body>");	
		
		for(String str:userIdValues ){
			pw.println("	userID   : "+ str);
			pw.println("	<br>");
		}
			pw.println("	password : "+ req.getParameter("password"));	
		
		pw.println("	</body>");
		pw.println("</html>");		
				
		pw.flush();
		pw.close();		
	}
}
