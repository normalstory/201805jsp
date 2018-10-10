<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>main.jsp</h3>
	
	<% UserVo userVo = (UserVo)session.getAttribute("userVo"); %>
	<%=userVo.getName()+"["+userVo.getAlias()+"]님 안녕하세요" %>
	
	
	userId 	 = <%= request.getParameter("userId") %></br>
	password = <%= request.getParameter("password") %></br>
	
	
	
</body>
</html>