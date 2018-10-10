package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MulCalculation
 */
@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get 
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumInput.jsp");
		rd.forward(request, response);		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		
		System.out.println("param1 X param2 :" +param1*param2);
		
		int mul=1;
		
		if(param1>param2){
			for(int i=param2; i<=param1; i++){
				mul*=i;
			}
		}else{
			for(int i=param1; i<=param2; i++){
				mul*=i;
			}
		}		
		
		request.getSession().setAttribute("mulResult", mul);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/mulResult.jsp");
		rd.forward(request, response);		
	}

}
