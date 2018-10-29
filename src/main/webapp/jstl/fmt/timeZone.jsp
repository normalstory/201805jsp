<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timeZone of jstl fmt</title>
</head>
<body>

<c:set var="now" value="<%=new Date() %>" />
formatDate : <fmt:formatDate value="${now }" type="both"/><br/>

<fmt:timeZone value="Pacific/Palau">
formatDate Palau : <fmt:formatDate value="${now }" type="both"/><br/>
</fmt:timeZone>

<fmt:timeZone value="Asia/Bangkok">
formatDate Bangkok : <fmt:formatDate value="${now }" type="both"/><br/>
</fmt:timeZone>

<fmt:timeZone value="America/Santiago">
formatDate Santiago : <fmt:formatDate value="${now }" type="both"/><br/>
</fmt:timeZone>
</body>
</html>