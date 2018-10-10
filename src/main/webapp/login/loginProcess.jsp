<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>loginProcess.jsp</h3>
	
	<%--login.jsp에서 전송한 파라미터 --%>
	<%--
		request.getParameter 관련 메소드 
			getParameter()
			getParameterValues() 
			getParameterMap()
			getParameterNames()
	--%>
	
	<%
		String[] userIdValues =request.getParameterValues("userId");
	
		Map<String,String[]> requestMap = request.getParameterMap();
		
		//파라미터의 이름 확인 
		Enumeration<String> parameterNames= request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String parameterName = parameterNames.nextElement();
			System.out.println("parameterName :"+parameterName);
		}
	%>
	
		request.getParameter("usserId") : <%= request.getParameter("userId") %><br/>
		request.getParameterValues("usserId") : 
		
		
		<%for(String str:userIdValues ){
			out.write("userId"+str+"<br>");
		}%>
	
	request.getParameter("password"): <%= request.getParameter("password") %><br/>
	
	<h3>requestMap</h3>
	<%for(String strId : requestMap.get("userId")){ %>
		strId: <%=strId%> <br>
	<%} %>
	
	<%-- requestMap.get("password") : <%=requestMap.get("password") %>--%>
	<%for(String strPW : requestMap.get("password")){ %>
		strPW: <%=strPW%> <br>
	<%} %>

</body>
</html>