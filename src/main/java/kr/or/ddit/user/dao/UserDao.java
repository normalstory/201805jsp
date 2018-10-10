package kr.or.ddit.user.dao;
//UserDao 생성 -> UserDaoTest 생성 
//mapper : user.xml	(alais x -> full package)
//assert 구문에서 데이터 전체 건수를 5와 비교 

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

//jspuser테이블 전체 조회 쿼리 
public class UserDao implements UserDaoinf{
//select query id : selectUserAll  -> method : selectUserAll
	
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		
		//selectOne : 조회 데이터가 한 건일때 
		//selectList : 여러건의 데이터 조회 
		//메소드 인자: 문자열 - 메퍼(xml) 네임스페이스(모듈명).쿼리아이디 
		return session.selectList("user.selectUserAll");
	}
	
	public UserVo selectUser(String param){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		
		//파라미터 추가 
		return session.selectOne("user.selectUser", param);
	}
	
	//오버로딩
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		
		return session.selectOne("user.selectUserByVo", userVo);
	}
	
	
	public List<PageVo> selectUserPageList(PageVo pageVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		
		return session.selectList("user.selectUserPageList", pageVo);
	}
}
