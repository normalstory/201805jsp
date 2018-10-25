<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl for format type of bundle</title>
</head>
<body>

<h3>기본 로케일</h3>
<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
	<fmt:message key="hello"></fmt:message>
	<fmt:message key="visitor">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>
</fmt:bundle>

<hr>
<h3>변경 로케일 : en</h3>
<fmt:setLocale value="en"/>
<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
	<fmt:message key="hello"></fmt:message>
	<fmt:message key="visitor">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>
</fmt:bundle>

<h3>변경 로케일 : ja</h3>
<fmt:setLocale value="ja"/>
<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
	<fmt:message key="hello"></fmt:message>
	<fmt:message key="visitor">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>
</fmt:bundle>

<hr>
<h3>setBundle, setLocale value는 가장 마지막에 선언한 값으로 반영됨</h3>
<fmt:setBundle basename="kr.or.ddit.resource.msg.msg" var="msg"/>
<fmt:message key="hello" bundle="${msg }"></fmt:message>
<fmt:message key="visitor" bundle="${msg }">
	<fmt:param value="brown"></fmt:param>
</fmt:message>



</body>
</html>