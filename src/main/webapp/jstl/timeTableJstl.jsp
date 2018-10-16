<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:forEach begin="1" end="9" var="i">
	<tr>
		<c:forEach begin="2" end="9" var="j">
			<c:set var="times" value="${j}x${i}=${i*j}"/>
			<td>${times}</td>
		</c:forEach>
	</tr>
</c:forEach>
</table>

</body>
</html>