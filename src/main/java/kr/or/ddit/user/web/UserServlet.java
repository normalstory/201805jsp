package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.CustomDateHandler;
import kr.or.ddit.util.model.PageVo;

@WebServlet(urlPatterns={"/userAllList", "/userPageList", "/userDetail"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	//db상태가 바뀌지 않는다 (link click) -> doGet 사용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//요청 URL로 로직 분기 
		String uri = request.getRequestURI();
		System.out.println("doGet() on UserServlet :"+uri);

		//사용자 전체 조회
		if(uri.equals("/userAllList")){
			userAllList(request, response);
		//사용자 페이징 조회
		}else if(uri.equals("/userPageList")){
			userPageList(request, response);
		}else if(uri.equals("/userDetail")){
			userDetail(request, response);
		}
	}

	
	/**
	* Method : userDetail
	* 작성자 : pc03
	* 변경이력 :
	* @param request
	* @param response
	* Method 설명 : 사용자 상세 정보 
	 * @throws IOException 
	 * @throws ServletException 
	*/
	private void userDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 요청파라미터로 : (가정) 사용자 아이디 
		String id = request.getParameter("userId");
				
		System.out.println("id : "+id);
		
		// 사용자 아이디에 해당하는 해당 사용자 정보조회
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.selectUser(id);
		System.out.println("userVo : "+userVo);
		System.out.println("date : "+userVo.getBirth());
		
		// jsp로 위임을 위해 사용자 정보를 request에 저장 
		request.setAttribute("userVo", userVo);
		
		// 상세화면으로 위임 
		request.getRequestDispatcher("/user/userDetail.jsp").forward(request, response);
	}


	/**
	* Method : userPageList
	* 작성자 : pc03
	* 변경이력 :
	* @param request
	* @param response
	* Method 설명 : 사용자 페이지 조회
	 * @throws IOException 
	 * @throws ServletException 
	*/
	private void userPageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here is userPageList");
		
		//userService 생성 
		//userPageList 호출 : 메소드 인자 pageVo:page,pageSize
		//request 객체에 저장 
		//forward(userAllList.jsp -> 
		
		UserServiceInf userService = new UserService();
		PageVo pageVo = new PageVo();
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		
		System.out.println("page :"+request.getParameter("page"));
		System.out.println("pageSize :"+request.getParameter("pageSize"));
		
		
		Map<String,Object> resultMap = userService.selectUserPageList(pageVo);
		
		//페이지 리스트
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		
		//페이지 건 수
		int pageCnt = (int)resultMap.get("pageCnt");
		
		request.setAttribute("pagelist", userList);
		request.setAttribute("pageCnt", pageCnt);
		
				
		request.getRequestDispatcher("/user/userPageList.jsp").forward(request, response);
		
	}

	/**
	* Method : userAllList
	* 작성자 : pc03
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 사용자 전체 조회
	*/
	private void userAllList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here is userAllList");
		
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
		//getServletContext().setAttribute("userList", userList);
		
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
