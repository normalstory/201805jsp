<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	td{ border: 1px solid pink; }
</style>
<body>

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