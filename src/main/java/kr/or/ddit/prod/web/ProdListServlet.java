package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

/**
 * Servlet implementation class ProdList
 */
@WebServlet(urlPatterns={"/prodList", "/prodDetail"})
public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 URL로 로직 분기 
		String uri = request.getRequestURI();
		System.out.println("doGet() on UserServlet :"+uri);
		
		//사용자 전체 조회
		if(uri.equals("/prodList")){
			prodList(request, response);
		//사용자 페이징 조회
		}else if(uri.equals("/prodDetail")){
			prodDetail(request, response);
		}		
		
		
	}

	private void prodDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here is Prod Detail");

		ProdServiceInf prodService = new ProdService();
		
		String prod_id =request.getParameter("prod_id");
		System.out.println("prod_id : "+ prod_id);
		
		ProdVo prodVo = prodService.prodDetail(prod_id);
		System.out.println("prodVo : "+ prodVo);
		
		request.setAttribute("prodVo", prodVo);
		request.getRequestDispatcher("/prod/prodDetail.jsp").forward(request, response);
	}

	private void prodList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here is ProdList");

		ProdServiceInf prodService = new ProdService();
		
		PageVo pageVo = new PageVo();
		//*** 'page'와 'pageSize' 파라미터가 어디서 오는지  <--  left.jsp에서 임의로 1,1-으로 지정해서 보냈었다 
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		
		Map<String, Object> resultMap = prodService.prodPageList(pageVo);
		//*** 언제 를 'prodList','pageCnt' Map에 put 했는지  <--  dao가 아니라 service를 먼저 추적하며 찾아야한다
		//												 <--  2개의 dao 메서드를 이용해서 선언한 service 메서드가 있었다
		List<ProdVo> prodList = (List<ProdVo>)resultMap.get("prodList");
		int pageCnt = (int)resultMap.get("pageCnt");

		request.setAttribute("prodList", prodList);
		request.setAttribute("pageCnt", pageCnt);
		
		request.getRequestDispatcher("/prod/prodList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
