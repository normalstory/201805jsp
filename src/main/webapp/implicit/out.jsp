<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		jsp가 내장 객체(implict 객체) : jsp 가 servlet으로 변환하는 과정에서 생성되는 변수 
		별도로 만들지 않아도 쓸 수 있는 묵시적 객체 
		request, response, session, out
	 -->

	<% out.write(" 아웃객체에서 출력한 내용 "); %>
	
</body>
</html>