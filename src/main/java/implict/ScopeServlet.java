package implict;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scopeServlet")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageScope = request.getParameter("pageScope");
		String requestScope = request.getParameter("requestScope");
		String sessionScope = request.getParameter("sessionScope");
		String applicationScope = request.getParameter("applicationScope");
		
		//				jsp			/ 	servlet
		//page			page		/ 		x
		//request		request		/	request
		//sessoion		sessoion	/	request.getSession()
		//application	application /	getServletContext()
		
		
		// 속성설정 : setAttribute(String name, Object value)
		// 속성획득 : getAttribute(String name)
		
		//request 영역
		request.setAttribute("requestScope", requestScope+"_attribute");
		
		//sessoion 영역-객체를 먼저 구해야한다 
		HttpSession session  = request.getSession();
		session.setAttribute("sessionScope", sessionScope+"_attribute");
		
		//application 영역 -객체를 먼저 구해야한다 
		ServletContext application= getServletContext();
		application.setAttribute("applicationScope", applicationScope+"_attribute");
		
		
		//forward로 위임 (scopeResult.jsp)
		request.getRequestDispatcher("/implicit/scopeResult.jsp").forward(request, response);
		
		
	}
}
