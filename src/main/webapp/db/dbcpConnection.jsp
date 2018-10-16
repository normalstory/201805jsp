<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
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
		//db connection pooling
		BasicDataSource bd = new BasicDataSource();
		//***db 기본접속정보 
		bd.setUsername("pc03");
		bd.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bd.setPassword("java");
		bd.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		
		//bd connection 초기 사이즈 설정  
		bd.setInitialSize(10);
		
		Connection conn = null;
		long startTime = System.currentTimeMillis();
		for(int i=0; i<30; i++){
			conn= bd.getConnection();
			
			//*** conn.getSchema() <-안됨...
			out.println("getSchema : "+ conn.getSchema() +"<br>");
			conn.close();
		}
		long endTime = System.currentTimeMillis();
		out.println("프로파일링 : " + (endTime - startTime) +"ms");
		
		bd.close();
	%>
</body>
</html>