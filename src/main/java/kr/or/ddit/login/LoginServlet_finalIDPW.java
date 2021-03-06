package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;

public class LoginServlet_finalIDPW extends HttpServlet{
	//아이디, 비번을 DB대신 상수로 대체 
	private final String USERID="brown";
	private final String PASSWORD="password1234";
	
	//service  --> request.getMethod() : "POST", "GET" --> doGet, doPost
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 1. 사용자 아이디, 비번을  request객채에서 받아온다 
		// 2. db에서 조회해 온 아이디, 비번을 체크
		// 3-1)일치할 경우		-> main.jsp로 이동 
		//   2)일치하지 않을 경우 -> join.jsp로 이동 
		
		//1
		String userId 	= req.getParameter("userId");
		String password = req.getParameter("password");
		
		//2 아이디, 비번을 DB대신 상수로 대체 
		
			
		
		//3-1)-> main.jsp로 이동 
		if(USERID.equals(userId)&&PASSWORD.equals(password)){
			//*** Redirect 방식
			//resp.sendRedirect("main.jsp");
			//resp.sendRedirect("main.jsp?userId="+userId +"&password="+password);	
				//주소줄이 바뀌어서 다시 보낸다(main.jsp?~~~)    ; F5를 누르면. list만 다시 조회됨 main.jsp
			
			// #1. session에 사용자 정보 설정 
			UserVo userVo = new UserVo();
			userVo.setUserId(userId);
			userVo.setName("브라운");
			userVo.setAlias("곰");
			userVo.setBirth(new Date());
		
//			UserVo userVo = getUser(userId);
//			request.setAttribute("userVo", userVo);  //request 객체 : 개발자가 로직을 통해 저장하는 부분 VS 파라미터 
			//세션객체에 넣기 
			req.getSession().setAttribute("userVo", userVo);
			
			// #2. main.jsp body 영역에 이름[별명]님 안녕하세요 
			
			//*** Dispatch 방식
			RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
			rd.forward(req, resp);													
				//값이 재사용된다(주소줄이 안바뀜) ; F5를 누르면, body가 값을 들고 있어서 새 글이 계속 입력됨
			
		}else{	//3-2)-> join.jsp로 이동 
			resp.sendRedirect("login/login.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//doPost(req, resp);
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw =resp.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		
		//userId : brwon / sally
		String[] userIds = req.getParameterValues("userId");
		for(String userId : userIds)
			pw.println("		userId : " + userId + "<br>");
		pw.println("		password : " + req.getParameter("password") + "<br>");
		pw.println("		</body>");
		pw.println("	</html>");
		
	}
}







