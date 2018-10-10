<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내장객체 implicit 중 </title>
</head>
<body>
<%-- 내장객체 implicit 중 pageContext를 통해 다른 정보에 접근할 수 있다 --%>

<% 
	pageContext.getOut();
	pageContext.getRequest();
	pageContext.getResponse();
	pageContext.getSession();
	pageContext.getPage();
	pageContext.getServletContext();
%>
	out.equals(pageContext.getOut()) : 			<%=out.equals(pageContext.getOut()) %><br/>
	request.equals(pageContext.getRequest()) : 	<%=request.equals(pageContext.getRequest()) %><br/>
	response.equals(pageContext.getResponse()) :<%=response.equals(pageContext.getResponse()) %><br/>
	session.equals(pageContext.getSession()) : 	<%=session.equals(pageContext.getSession()) %><br/>
	page.equals(pageContext.getPage()) : 		<%=page.equals(pageContext.getPage()) %><br/>
	appication.equals(pageContext.getServletContext()) : <%=application.equals(pageContext.getServletContext()) %><br/>
	
	
</body>
</html>