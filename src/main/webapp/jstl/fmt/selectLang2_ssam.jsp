<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="lang" value="${param.lang == null ? 'ko' : param.lang }" ></c:set>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/basicLib.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#langselect").val("${lang}");
		$("#langselect").on("change",function(){
			$("#frm").submit();
		});
	});
</script>
</head>
<body>

<h3>jQuery 이용 : selectLang by ssam</h3>
<form id="frm" action="selectLang2_ssam.jsp" method="get">
	<select name="lang" id="langselect">
		<option value="ko" >한글</option>
		<option value="ja" >日本語</option>
		<option value="en" >English</option>
	</select>
</form>
<br>
<fmt:setLocale value="${lang}" />
<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
	<fmt:message key="hello"></fmt:message><br/>
	<fmt:message key="visitor">
		<fmt:param value="brown"></fmt:param>
	</fmt:message>
</fmt:bundle>


</body>
</html>