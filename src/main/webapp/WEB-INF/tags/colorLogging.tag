<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="length" type="java.lang.Integer" required="false" %>
<%@ attribute name="color" type="java.lang.String" required="true" %>

<%-- length 속성이 없을 경우 length 기본값 20 --%>

length : ${length }<br>


<font color="${color}">
	<c:forEach begin="1" end="${length==null?20:length}" >=</c:forEach>
	logging
	<c:forEach begin="1" end="${length==null?20:length}" >=</c:forEach>
</font>

