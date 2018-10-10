package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TempDaoTest {
	
//	@Test
//	public Map<String, Object> getTemp(){
//		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
//		SqlSession session= factory.openSession();
//		
//		return session.selectOne("temp.temp");
//	}

	//테스트메소드 명명 규칙 : 운영코드 메소드 이름(getTemp + Test)
	@Test
	public void getTempTest(){
		/***Given 주어진 상황 ***/
		TempDao tempDao= new TempDao();

		/***When 어떤 동작(메소드 호출) ***/
		//tempDao.getTemp();
		Map<String, Object> map = tempDao.getTemp();
		System.out.println("map : "+map);

		//참고 : //temp.xml <- select 'X' result from dual
		//예상 : //result : x
		 
		/***Then 결과가 어떠해야하는지 정의 ***/
		assertEquals("X", map.get("result"));
	}


}
