<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>서블릿 이용</h3>
<%--
	1. lang 이라고 이름지어진 파라미터로 locale을 설정
	2. 만약 파라미터가 없으면 ko를 기본값으로 
	3. select box가 변경되면 해당 언어로 페이지 재요청
	4. select box는 형재 요청된 lang으로 선택되어 있어야 함
	
	최초 접속 
	사용자가 select box 선택
	페이지 재요청
--%>

<form action="/selectLang" method="get">
	<select name="locale" >
		<option value="ko" <c:if test="${localeParam =='ko'}">selected</c:if> >한글</option>
		<option value="ja" <c:if test="${localeParam =='ja'}">selected</c:if> >日本語</option>
		<option value="en" <c:if test="${localeParam =='en'}">selected</c:if> >English</option>
	</select>
	<input type="submit" value="select">
</form>
<br>

<c:set var="localeS" value="${localeParam }" ></c:set>
<fmt:setLocale value="${localeS}" />
<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
	<fmt:message key="hello"></fmt:message><br/>
	<fmt:message key="visitor">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>
</fmt:bundle>



</body>
</html>