package kr.or.ddit.file.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.print.attribute.standard.Severity;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

@WebServlet("/fileDownloadName")
public class FileDownloadNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일 다운로드 용
		
		//파일에 대한 정보 | 파일명 : header 
		//응답에 대한 정보 ㅣ html이 아니라 바이너리라는 것을 알려줘야함 : contentsType
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=git.txt");


		File f = new File("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\git.txt");
		
		FileInputStream fis = new FileInputStream(f);
		byte[] buffer = new byte[512];
		
		//파일을 쓸 객체 
		ServletOutputStream sos = response.getOutputStream();
		int len =0;
		
		//조건에 따라(!=-1) 파일 읽기
		while((len = fis.read(buffer)) !=-1){
			//파일 쓰기 
			sos.write(buffer, 0, len);
		}
		
		//닫기
		sos.close();
		fis.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
