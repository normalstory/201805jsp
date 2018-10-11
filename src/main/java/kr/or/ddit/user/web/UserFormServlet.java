package kr.or.ddit.user.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userForm")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. get : /userForm --> userForm.jsp
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2. post : /userForm --> db에 사용자 정보 저장
        //--> userPagingList.jsp  -->  1페이지로 이동
	}

}
