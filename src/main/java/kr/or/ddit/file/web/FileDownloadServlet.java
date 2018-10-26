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

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//brownc 이미지 다운로드 용 
		String userId = request.getParameter("userId");
		UserServiceInf ser = new UserService();
		UserVo userVo = ser.selectUser(userId);
		
		
		File f = new File(userVo.getProfile());
		
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
