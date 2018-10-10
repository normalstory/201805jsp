<!-- 지시자 -->
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 스크립틀릿 : 자바코드 작성1 -->
<%  String msg ="first jsp"; %>

<!-- 스크립틀릿 : 자바코드 작성2 -->
<% 

	Date date2 = new Date();
	SimpleDateFormat state = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String datePrint = state.format(date2);
%>


<body>

	<%-- UserVo userVo = (UserVo)session.getAttribute("userVo"); --%>
	<%--=userVo.getName()+"["+userVo.getAlias()+"]님 안녕하세요" --%>
	
	hello,world
	
	<!-- 표현식 : 출력을 표현1 -->  
	<br> <%=msg %>
	
	<!-- 표현식 : 출력을 표현2 -->  
	<br> <%=datePrint %>


</body>
</html>