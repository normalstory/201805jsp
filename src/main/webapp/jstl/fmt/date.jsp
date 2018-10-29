<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>date of jstl fmt </title>
</head>
<body>

<c:set var="date" value="<%=new Date() %>" />

<h2>기본형</h2>
date : ${date }	<br/>

<h2>포멧팅 기본형</h2>
formatDate : <fmt:formatDate value="${date }"/>

<h2>포멧팅 패턴형</h2>
formatDate(pattern) : <fmt:formatDate value="${date }" pattern="yyy-MM-dd"/>

<hr>
<h3>옵션 type(date)</h3>
defualt : <fmt:formatDate value="${date }" type="date"/><br/>
full : <fmt:formatDate value="${date }" type="date" dateStyle="full"/><br/>
medium : <fmt:formatDate value="${date }" type="date" dateStyle="medium"/><br/>
short : <fmt:formatDate value="${date }" type="date" dateStyle="short"/><br/>

<h3>옵션 type(time)</h3>
<fmt:formatDate value="${date }" type="time" />

<hr>
<h3>문자열 날짜를 날짜타입으로 전환</h3>
<c:set var="parseDate" value="2018-10-25"/>
String to parseDate : <fmt:parseDate value="${parseDate }" pattern="yyyy-MM-dd" var="dt"/>${dt }


</body>
</html>