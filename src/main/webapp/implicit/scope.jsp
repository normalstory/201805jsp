<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scope</title>
</head>
<body>

<h3>scope.jsp</h3>
<form method="post" action="/scopeServlet">
	pageScope :<input type="text" name="pageScope" value="james"><br/>
	requestScope :<input type="text" name="requestScope" value="brown"><br/>
	sessionScope :<input type="text" name="sessionScope" value="sally"><br/>
	applicationScope :<input type="text" name="applicationScope" value="cony"><br/>
	<input type="submit" value="전송"><br/>
</form>
</body>
</html>