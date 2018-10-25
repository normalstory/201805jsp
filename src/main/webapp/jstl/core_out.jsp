<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	request.setAttribute("userid", "brown");
	request.setAttribute("username", "cony");
%>
<label>userid : </label><c:out value="${userid}"></c:out> <br/>
<label>user : </label><c:out value="${user}" default="browndefault"></c:out> <br/>

</body>
</html>