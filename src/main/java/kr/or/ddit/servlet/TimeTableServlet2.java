package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeTableServlet2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter pw  = resp.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("		<meta charset=\"UTF-8\">");
		pw.println("		<title>TimeTableServlet 2</title>");
		
		pw.println("<style type=\"text/css\">");
		pw.println("	td{ border: 1px solid pink; }");
		pw.println("</style>");
		
		pw.println("	</head>");			
		pw.println("	<body>");		
		
		pw.println("<table>");

		for(int j=1; j<10; j++){
			pw.println("	<tr>");
			for(int i=2; i<10; i++){
				String times= i+"X"+j+"="+i*j;	
				pw.println("		<td>"+times+"</td>");
			}
			pw.println("	</tr>");
		}
		pw.println("</table>");
		
		pw.println("	</body>");
		pw.println("</html>");		
				
		pw.flush();
		pw.close();
		
	}
	
	
}
