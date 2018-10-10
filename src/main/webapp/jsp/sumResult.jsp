<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 10.05 실습 01  </h3>
	시작 값:  		<%= request.getParameter("start") %><br/>
	종료 값:  		<%= request.getParameter("end") %><br/>
	사이 값들의 합계 : <%= session.getAttribute("sumResult") %><br/>
	
</body>
</html>