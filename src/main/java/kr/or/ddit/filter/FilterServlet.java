package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filterServlet")
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-- 2filter on the doGet() --");
		request.getRequestDispatcher("/filter/view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 -> filter로 이관 
		//request.setCharacterEncoding("UTF-8");
		
		
		//파라미터받기
		String userNm = request.getParameter("userNm");
		//속성설정
		request.setAttribute("userNm", userNm);
		//전달
		request.getRequestDispatcher("/filter/view.jsp").forward(request, response);	
		
	}

}
