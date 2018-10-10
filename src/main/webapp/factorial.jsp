<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
public String msg(){
	return "hello world";
}
%>
<%=msg() %>

<%--
int result;
String str;
public String factorial(int num){
	for(int i=num; i<=num;i++){	
		result= num*i;
		str= i +"!=" + result;
	}
}	
--%>
<%!
private int factorial(int num){
	int result=0;
	if(num<1){
		result=0;
	}else{
		int tmp=1;
		for(int i=1; i<=num;i++){	
			tmp=1*tmp;
		}
		result=tmp;
	}	
	return result;
}
%>
<br>
<% for(int i =1 ; i<9; i++){ %>
	factorial(<%=i %>)=<%= factorial(i)%><br>
<%}%>



</body>
</html>