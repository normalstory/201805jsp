<%@page import="kr.or.ddit.filter.RequestCounterFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3> public + static Map 을 통해 가져온 값 </h3>
countMap : <%-- RequestCounterFilter.countMap --%>

<c:forEach var="map" items="${countMap}" >
	${map.key} :  ${map.value}
</c:forEach>


</body>
</html>