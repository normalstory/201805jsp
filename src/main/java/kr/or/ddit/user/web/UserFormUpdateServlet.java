package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
import sun.util.calendar.LocalGregorianCalendar.Date;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5) //=(5M, 5개)
@WebServlet("/userFormUpdate")
public class UserFormUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. get :
		System.out.println("hi 1");
		String userId= request.getParameter("userId");
		System.out.println("userId : "+ userId);

		UserServiceInf userService = new UserService();
		UserVo userVo = userService.selectUser(userId);

		request.setAttribute("userVo", userVo);
		request.getRequestDispatcher("/user/userFormUpdate.jsp").forward(request, response);

		System.out.println("hi 2");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		System.out.println(" -- here is doPost() on userFormUpdate servlet --");

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
		String profile= request.getParameter("profile");

		// + 프로필 읽어오기
		Part profilePart = request.getPart("profile");
		//파일과 관련된 부가 정보 				
		String contentDispostion = profilePart.getHeader("Content-disposition");
		//별도 class로 리팩토링
		String fileName = StringUtil.getFileNameFromHeader(contentDispostion);

		//*** 사용자가 프로필 사진은 수정하지 않는 경우 
		UserServiceInf userService = new UserService();
		//***
		if(fileName.equals("")) {
			UserVo userVoOnDetail = userService.selectUser(userId);
			profile = userVoOnDetail.getProfile();
			System.out.println("원본 profile : "+profile);

		}else {
			//파일 쓰기 
			String path = getServletContext().getRealPath("/profile"); 
			profilePart.write(path + File.separator + fileName);
			profilePart.delete();	//파일 업로드 과정에서 사용한 디스크 임시영역 부분을 삭제해줌

			//파라미터 받기
			profile = "/profile/"+fileName;
		}
		System.out.println("get userVo :" +userId+"/"+name+"/"+pass+"/"+addr1+"/"+addr2+"/"+birth+"/"+zipcd+"/"+email+"/"+tel);


		//dao, service 생성 및 test


		//파라미터를 userVo로 세팅 
		UserVo userVo = new UserVo();
		userVo.setUserId(userId); 
		userVo.setName(name); 
		userVo.setPass(pass); 
		userVo.setAddr1(addr1); 
		userVo.setAddr2(addr2); 
		userVo.setZipcd(zipcd);
		userVo.setEmail(email); 
		userVo.setTel(tel); 
		userVo.setProfile(profile);

		System.out.println("원본 birth : "+birth);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			System.out.println("ing birth : "+birth);
			userVo.setBirth(sdf.parse(birth));
			System.out.println("등록 birth : "+sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("update set userVo : "+userVo);

		//service 호출 <- 사용자등록 서비스(메소드)호출
		//UserServiceInf userService = new UserService();
		int updateUser = userService.updateUser(userVo);

		//사용자 리스트로 이동(서버상태 변경:데이터 추가 <- redirect : 재용청시 중복등록 방지 )
		response.sendRedirect("/userPageList?page=1&pageSize=10");
	}

}
