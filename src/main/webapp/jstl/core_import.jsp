<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl</title>
</head>
<body>
<%-- jstl 사용 방법 : dependency 추가, jsp에 지시자 추가(taglib), 지시자에 선언한 prefix를 사용하여 jstl 구현 --%>

<h3>hihi jstl import</h3>
<c:import url="timeTableJstl.jsp">
	<c:param name="number" value="5"></c:param>
</c:import>

<h3>naver search </h3>
<c:import url="https://search.naver.com/search.naver">
	<c:param name="query" value="html5"></c:param>
</c:import>

</body>
</html>