package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

@WebServlet("/userAllList")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
	//db상태가 바뀌지 않는다 (link click) -> doGet 사용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전체 사용자 정보 조회(파라미터x)
		//서비스 인스턴스 생성 
		UserServiceInf userService = new UserService();
		
		List<UserVo> userList= userService.selectUserAll();
		
		//조회된 사용자 정보를 
		//userAllList.jsp에서 userList를 참조하려면?
		//attibute 사용이 가능한 객체
			//- session : 해당 사용자만 접근 가능(사용자 전용 공간) 
			//- application : 모든 사용자가 접근 가능(서버단 하나만 생성) 
			//- request : 해당 요청의 응답이 끝날때 까지. 응답이 도착하면 끝
		
		//application - a사용자가 1페이지 조회하는 동안 b사용자가 5페이지를 조회하면 a 사용자는 5페이지를 보게된다 
			//	-> 설정과 관련된 부분 값을 저장(사용) 
		getServletContext().setAttribute("userList", userList);
		
		//session - 어느 페이지에 가도 사용자의 정보(이름)이 보여야 한다, 상시 자주 참조, 데이터가 많은 경우 과부화(OOM) 발생
			//	-> 프로토컬의 특성상 적어도 30분동안 유효 
		
		//request - 요청이 유효한 기간을 클릭하는 시점으로 한정. 
		request.setAttribute("userList", userList);
		
		
		///위임
		//1. requestDispatch	: 조회만 하는 경우, 보통 일반적인 경우  
		//2. sendRedirect		: 서버에 데이터가 변경되는 경우 <- F5 방지 
									// -> ? 새로고침하면 값이 없어진다 
		
		RequestDispatcher rd = request.getRequestDispatcher("user/userAllList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
