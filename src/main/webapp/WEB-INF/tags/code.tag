<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>

<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="code" type="String" required="true"%>

<h3>select code : ${code}</h3>
<br>

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
	
	// 실행할 SQL명령
	String sql = "select prod_id, prod_name from prod where prod_lgu='"+code+"'";  
	System.out.println("sql : "+sql);
	rs = stmt.executeQuery(sql); 
%>

<select>
	<%while(rs.next()){%>
		<option value="<%=rs.getString("prod_id")%>"><%=rs.getString("prod_name")%></option>
	<%} %>
</select>

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
