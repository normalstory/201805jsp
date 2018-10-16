<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--el scope 확인 예제 --%>
	<%
		pageContext.setAttribute("attribute", "pageContextAttribute");
		request.setAttribute("attribute", "requestAttribute");
		session.setAttribute("attribute", "sessionAttribute");
		application.setAttribute("attribute", "applicationAttribute"); 
	%>
	
	pageContext : 	<%=pageContext.getAttribute("attribute") %><br/>
	request : 		<%=request.getAttribute("attribute") %><br/>
	session : 		<%=session.getAttribute("attribute") %><br/>
	application :	<%=application.getAttribute("attribute") %><br/>
	
	<h3>el </h3>
	
	el attribute : ${attribute} <br>   
	> ? 어떤 attribute : 1.범위가 좀은데서 넓은데로 검색해서 출력 <br><br>   
		
	el application.attribute : ${applicationScope.attribute} <br> 
	
	  
	
</body>
</html>