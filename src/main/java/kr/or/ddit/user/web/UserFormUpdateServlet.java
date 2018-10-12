package kr.or.ddit.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

@WebServlet("/userFormUpdate")
public class UserFormUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. get :
		System.out.println("hi 1");
		request.getRequestDispatcher("/user/userFormUpdate.jsp").forward(request, response);
		System.out.println("hi 2");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId= request.getParameter("userId");
		System.out.println("userId : "+ userId);
		
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.selectUser(userId);
		
		request.setAttribute("userVo", userVo);
		request.getRequestDispatcher("/user/userFormUpdate.jsp").forward(request, response);
	}

}
