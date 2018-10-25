<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String number = request.getParameter("number"); %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>99dan</title>
</head>
<style>
	td{ border: 1px solid pink; }
</style>
<body>

[<%= number %>] from http://localhost:8081/jstl/core_import.jsp

<h3>99dan</h3>
<table>
	<% for(int j=1; j<10; j++){%>
	<tr>
		<%for(int i=2; i<10; i++){%>
		<% String times= i+"X"+j+"="+i*j;	%>
		<td><%= times%>	<td>
		<%}%>
	</tr>
	<%}%>
</table>


</body>
</html>