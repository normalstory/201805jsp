<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl fmt of number</title>
</head>
<body>

<%-- 
	request.setAttribute("number", 100000);
	request.setAttribute("numberP", 0.1);
--%>
<c:set value="100000" var="number" scope="request"></c:set>
<c:set value="0.1" var="numberP" scope="request"></c:set>

<h3>기본 로케일</h3>
<fmt:formatNumber value="${number }" /><br>
<fmt:formatNumber value="${number }" type="currency" /><br>
<fmt:formatNumber value="${numberP }" type="percent" /><br>

<h3>영문 로케일</h3>
<fmt:setLocale value="en_US"/>
<fmt:formatNumber value="${number }" /><br>
<fmt:formatNumber value="${number }" type="currency" /><br>
<fmt:formatNumber value="${numberP }" type="percent" /><br>

<h3>독일 로케일</h3>
<fmt:setLocale value="de_DE"/>
<fmt:formatNumber value="${number }" /><br>
<fmt:formatNumber value="${number }" type="currency" /><br>
<fmt:formatNumber value="${numberP }" type="percent" /><br>

<hr>
<h3>'문자열' 형태의 숫자를 '숫자'로 전환</h3>
<fmt:setLocale value="ko"/>
<c:set var="parseNumber" value="1,000.99" />
<fmt:parseNumber value="${parseNumber }" />

</body>
</html>