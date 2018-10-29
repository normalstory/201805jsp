<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.util.model.PageVo"%>
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.UserServiceInf"%>
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
	<!-- core tag prefix : c -->
	<h2> core set tags</h2>
	<!-- = pageContext.setAttribute("attribute", "cSetValue"); -->
	<c:set var="attribute" value="cSetValue" scope="request" />
	el : ${attribute}<br>
	pageContext  :  <%= pageContext.getAttribute("attribute")%><br>
	request :  <%= request.getAttribute("attribute")%><br>
	
	
	<h2> core remove tags</h2>
	<!-- = pageContext.removeAttribute("attribute"); -->
	<c:remove var="attribute"/>
	el : ${attribute}<br>
	
	
	<h2> core if tags : 단일조건 비교 </h2>
	<c:set var="code" value="01"/>
	<!-- 코드가 01이면 실행 -->
	<c:if test="${code == '01'}">
		if 내부 도착 2
	</c:if>
	
	
	<h2> core choose tags : JAVA style if </h2>
	<c:set var="code" value="01"/>
	<!-- 코드가 01이면 실행 -->
	<c:choose>
		<c:when test="${code=='00'}">공공</c:when>
		<c:when test="${code=='01'}">공1</c:when>
		<c:when test="${code=='02'}">공2</c:when>
		<c:when test="${code=='03'}">공3</c:when>
		<c:otherwise>else</c:otherwise>
	</c:choose>
	
	
	<h2> core foreach tag : 반복문</h2>
	<!-- 사용자 리스트 1페이지 10건 조회 -->
	<% 
		UserServiceInf userService = new UserService();
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		
		Map<String,Object> resultMap = userService.selectUserPageList(pageVo);
		request.setAttribute("userList", resultMap.get("userList"));
		
	%>
	<%-- <c:set var="user" value=userList의 값 --%>
	<table>
		<tr>
			<th>번호</th>
			<th>사용자 아이디</th>
			<th>사용자 이름</th>
			<th>생일</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr class="userClick">
				<td>${user.rnum }</td>
				<td>${user.userId }</td>
				<td>${user.name }</td>
				<td>${user.birth }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<h2> core foreach 'index loop' tag : 반복문</h2>
	<c:forEach begin="0" end="10" var="i">
		${i }&nbsp;&nbsp;&nbsp;
	</c:forEach><br/>
	<c:forEach begin="0" end="10" var="i" step="3">
		${i }&nbsp;&nbsp;&nbsp;
	</c:forEach>
	
		
	<h2> core foreach 'tag : Map</h2>
	<%
		Map<String, String> strMap = new HashMap<String,String>();
		strMap.put("ranger1", "brown");
		strMap.put("ranger2", "sally");
		strMap.put("ranger3", "james");
		strMap.put("ranger4", "cony");
		request.setAttribute("strMap", strMap);
	%>
	<c:forEach items="${strMap }" var="map">
		${map.key } / ${map.value } <br>
	</c:forEach>
	
	
</body>
</html>