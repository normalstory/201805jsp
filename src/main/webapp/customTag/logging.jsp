<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>logging Tag : 1-10 출력</h2>

<tags:loggingTag/>
	<c:forEach begin="1" end="10" var="i" step="2" varStatus="5">
	${i }
	<br/>
	</c:forEach>
<tags:loggingTag/>

<h2>color Logging Tag</h2>
<tags:colorLogging color="blue"/><br>
	<c:forEach begin="1" end="10" var="i" >
	${i }
	<br/>
	</c:forEach>
<tags:colorLogging color="red"/>
</body>
</html>
