package kr.or.ddit.request;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;

@WebServlet("/requestServlet")
public class RequestServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parameter : userId, name 클라이언트가 서버로 보내는 정보   
		String userId = request.getParameter("userId"); 
		String name = request.getParameter("name");
		
		//request정보에 값을 저장 
		UserVo userVo = getUser(userId);
		request.setAttribute("userVo", userVo);  //request 객체 : 개발자가 로직을 통해 저장하는 부분 VS 파라미터 
		
		//Dispatcher 같은 요청을 썼으니까 가능 
//		RequestDispatcher rd = request.getRequestDispatcher("request/requestResult.jsp");
//		rd.forward(request, response);
			
		
		//session은 request보다 범위가 넓다 
		HttpSession session= request.getSession();
		session.setAttribute("userVo", userVo);
		
		//Redirect
		response.sendRedirect("request/requestResult.jsp");
		
	}

	public UserVo getUser(String userId){
		//userId 매개변수를 이용하여 사용자정보를 DB에서 조회
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setName("브라운");
		userVo.setAlias("곰");
		userVo.setBirth(new Date());
		
		return userVo;
	}
	
	
}
