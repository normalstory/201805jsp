<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection conn = null;
	
	try {
		//***db 기본접속정보 
		// 1. JDBC 드라이버 로딩 ==> Class.forName()을 이용한다.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 해당 DB에 접속하기 
		//		==> DriverManager.getConnection()을 이용하고
		//		==> 접속이 성공하면 Connection객체가 생성된다.
		String url = "jdbc:oracle:thin:@localhost:59161:xe";
		String user = "system";  // 등록된 사용자 ID
		String pass = "oracle"; // 등록된 패스워드
		

		//*** 프로파일링 : endTime - startTime
		long startTime = System.currentTimeMillis();
		for(int i=0; i<30; i++){
			//데이터베이스에 대한 커넥션 객체 얻어오기 
			conn = DriverManager.getConnection(url, user, pass);
			
			//*** conn.getSchema() <-안됨...
			out.println("Schema : " + conn.getSchema() + "<br>"); //pc03의 스키마 출력
			try { conn.close(); } catch (Exception e2){}
		}
		long endTime = System.currentTimeMillis();
		out.println("프로파일링 : " + (endTime - startTime) +"ms");
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally{
		// 6. 사용했던 자원을 반납한다.
		if( conn!=null ) try { conn.close(); } catch (Exception e2){}
	}
	
	
%>


</body>
</html>