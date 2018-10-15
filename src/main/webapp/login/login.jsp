<%--사용자 아이디랑, 비밀번호 입력 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- basicLib -->
<%@ include file="/common/basicLib.jsp"%>

<link href="/css/signin.css" rel="stylesheet">
</head>
<body>

	<%--
	브라우저 주소줄에 입력한 경우 : get 
    <form>의 메서드 속성 : get, post 
--%>
	<div class="container">
		<form class="form-signin" method="post" action="/loginServlet">
			<h2 class="form-signin-heading">Please sign in</h2>
			
			<label for="inputId" class="sr-only">UserId</label>
			<input type="text" name="userId" value="brown"
				class="form-control" placeholder="아이디를 입력하세요"> <br />
			
			<input type="password" name="password" value="brownpass"
				class="form-control" placeholder="비밀번호를 입력하세요"> <br />
				
			<label for="inputPassword" class="sr-only">Password</label>	
			<!-- div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div-->
			<button type="submit" value="로그인"
				class="btn btn-lg btn-primary btn-block">Sign in</button>
		</form>
	</div>
</body>
</html>