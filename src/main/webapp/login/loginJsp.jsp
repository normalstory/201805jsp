<%--사용자 아이디랑, 비밀번호 입력 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
request.getContextPath() 		:<%= request.getContextPath() %><br/> 

<h3>loginJsp.jsp</h3>

<%--
	브라우저 주소줄에 입력한 경우 : get 
    <form>의 메서드 속성 : get, post 
--%>

<form method="post" action="/login/loginProcess.jsp">

	사용자 ID : <input type="text" name="userId" value="brown">				<br/>
	사용자 ID : <input type="text" name="userId" value="sally">				<br/>
	사용자 PW : <input type="password" name="password" value="password1234">	<br/>
	
	<input type="submit" value="로그인">
	
</form>

</body>
</html>