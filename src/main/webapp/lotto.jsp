<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% 
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;  

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "pc03"; 
	String pass = "java"; 
	conn = DriverManager.getConnection(url, user, pass);
	
	stmt = conn.createStatement();
	

	int num = (int)(Math.random()*19) + 1; 
	
	// 실행할 SQL명령
	String sql = "select * from jspstudent where no ="+num;  
	
	rs = stmt.executeQuery(sql); 
	
	System.out.println("실행 결과 : " + sql);

%>
</head>
<body>

	<canvas id="myCanvas" width="200" height="200" style="border:1px solid #000000"></canvas>
	
	<%if(rs.next()){%>
	<img id="scream" width="220" height="277" src="<%=rs.getString("pic")%>" alt="The Scream">
	<%}%>
	
</body>
	<script>
		var canvas = document.getElementById("myCanvas");
		var ctx = canvas.getContext("2d");
		ctx.fillStyle = "#FF0000";
		
		// 사각형 그리기 <- 두 점이 필요하다 
		//ctx.fillRect(0,0,150,75);	
		
		// 원 그리기 
		ctx.beginPath();
		ctx.arc(100,100,100,0,2*Math.PI);	//중심 x좌표,중심 y좌표,반지름
		ctx.stroke();
		
		//텍스트 
		ctx.font = "60px Arial";
		
		<%if(rs.next()){%>
			ctx.fillText("<%=rs.getString("name")%>",10,115);
		    var img = document.getElementById("<%=rs.getString("pic")%>");
		    ctx.drawImage(img, 10, 10);
		<%}%>
	</script>
</html>
<%
} catch (SQLException e) {
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	e.printStackTrace();
} finally{
	// 6. 사용했던 자원을 반납한다.
	if( rs!=null ) try { rs.close(); } catch (Exception e2){}
	if( stmt!=null ) try { stmt.close(); } catch (Exception e2){}
	if( conn!=null ) try { conn.close(); } catch (Exception e2){}
}
%>



