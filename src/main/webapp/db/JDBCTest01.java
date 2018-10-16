package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest01 {
	
	public static void main(String[] args) {
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
			
			
			String sql = "select * from lprod";  // 실행할 SQL명령
			
			rs = stmt.executeQuery(sql); 
			
			System.out.println("실행 쿼리문 : " + sql);
			System.out.println(" == 쿼리문 실행 결과 == ");
			
			while(rs.next()){
				System.out.println("lprod_id : " + 
							rs.getInt("lprod_id"));  // 컬럼명 이용
				System.out.println("lprod_gu : " +
							rs.getString(2)); // 컬럼의 순번 이용
				System.out.println("lprod_nm : " +
							rs.getString("lprod_nm"));
				System.out.println("-----------------------");
			}
			
			System.out.println();
			System.out.println("출력 끝...");
			
			
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
		
		
		

	}

}












