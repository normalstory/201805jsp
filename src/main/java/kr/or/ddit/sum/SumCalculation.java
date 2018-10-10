package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SumCalculation
 */
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		System.out.println(start);
		System.out.println(end);
		
		//2.로직분리
		CalculationLogic logic = new CalculationLogic();
		int sum =logic.sumBetweenTwoNumbers(start,end);
		//1.로직
//		int sum = 0 ;
//		for(int i=start; i<=end; i++){
//			sum+=i;
//		}
		
		//세션에 로직의 결과값 담기 
		HttpSession session= request.getSession();
		session.setAttribute("sumResult", sum);
		//같은거 
		//request.getSession().setAttribute("sumResult", sum);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/sumResult.jsp");
		rd.forward(request, response);
	}

}
