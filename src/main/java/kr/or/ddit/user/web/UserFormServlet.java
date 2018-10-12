package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5) //=(5M, 5개)
@WebServlet("/userForm")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//사용자 등록화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. get : /userForm --> userForm.jsp
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}

	//사용자 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2. post : /userForm --> db에 사용자 정보 저장
        //--> userPagingList.jsp  -->  1페이지로 이동
		request.setCharacterEncoding("UTF-8");
		

		
		// + 프로필 읽어오기
		Part profilePart = request.getPart("profile");
		System.out.println("profilePart.getContentType() : "+ profilePart.getContentType());
		
		//파일과 관련된 부가 정보 
		System.out.println("Content-disposition : " + profilePart.getHeader("Content-disposition"));
		
		String contentDispostion = profilePart.getHeader("Content-disposition");
		
		
		//별도 class로 리팩토링
		String fileName = StringUtil.getFileNameFromHeader(contentDispostion);
		
		
		System.out.println("name : "+"D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\"+fileName);
		
		//파일 쓰기 1
		//profilePart.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\"+fileName);

		//파일 쓰기 2
		String path = getServletContext().getRealPath("/profile"); //url정보를 파일경로로 변경해주는 역할 수행
					  // ->  in jsp  = <%= application.getRealPath("/profile") %>		
		
		profilePart.write(path + File.separator + fileName);
		profilePart.delete();	//파일 업로드 과정에서 사용한 디스크 임시영역 부분을 삭제해줌
		
		
		
		
		
		//파라미터 받기
		String userId= request.getParameter("userId");
		String name= request.getParameter("name");
		String pass= request.getParameter("pass");
		String addr1= request.getParameter("addr1");
		String addr2= request.getParameter("addr2");
		String birth= request.getParameter("birth");
		String zipcd= request.getParameter("zipcd");
		String email= request.getParameter("email");
		String tel= request.getParameter("tel");
		String profile = "/profile/"+fileName;
		
		System.out.println(userId+"/"+name+"/"+pass+"/"+addr1+"/"+addr2+"/"+birth+"/"+zipcd+"/"+email+"/"+tel);
		
		
		//dao, service 생성 및 test
				
		
		//파라미터를 userVo로 세팅 
		UserVo userVo = new UserVo();
		userVo.setUserId(userId); 
		userVo.setName(name); 
		userVo.setPass(pass); 
		userVo.setAdd1(addr1); 
		userVo.setAdd2(addr2); 
		userVo.setZipcd(zipcd);
		userVo.setEmail(email); 
		userVo.setTel(tel); 
		//userVo.setProfile(path + File.separator + fileName);
		userVo.setProfile(profile);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			userVo.setBirth(sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//service 호출 <- 사용자등록 서비스(메소드)호출
		UserServiceInf userService = new UserService();
		int insertCnt = userService.insertUser(userVo);
				
		//사용자 리스트로 이동(서버상태 변경:데이터 추가 <- redirect : 재용청시 중복등록 방지 )
		response.sendRedirect("/userPageList?page=1&pageSize=10");
	}

}
