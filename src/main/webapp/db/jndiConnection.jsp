<%@page import="org.apache.catalina.tribes.transport.DataSender"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
	//jndi connection
	Context initialContext = new InitialContext();
	DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/oracleDB");
	
	Connection conn =null;
	
	long startTime = System.currentTimeMillis();
	for(int i=0; i<60; i++){
		conn= ds.getConnection();
		
		//*** conn.getSchema() <-안됨...
		out.println("getSchema : "+ conn.getSchema() +"<br>");
		conn.close();
	}
	long endTime = System.currentTimeMillis();
	out.println("프로파일링 : " + (endTime - startTime) +"ms");
%>

</body>
</html>