package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {

	//jUnit 실행주기 
	//@BeforeClass : 어노테이션이 적용된 메소드 최초 1회
	//@Before : 어노테이션이 적용된 메소드 실행 - 테스트 메소드 실행 전 실행
	//			*데이터 초기화 로직을 통해 <- 테스트 중간에 데이터가 추가/삭제되는 경우를 위해 일정하게 유지 시켜줌 
	//@Test	  :  
	//@After  : 어노테이션이 적용된 메소드 실행 - 테스트 메소드 실행 후 실행
	//@AfterClass  : 어노테이션이 적용된 메소드 최초 1회
	
	//@BeforeClass
	//@Before	-> 	selectUserAllTest()	-> @After
	//@Before	-> 	selectUserTest()	-> @After
	//@Before	-> 	selectUserByVoTest()-> @After
	//@AfterClass

	private UserServiceInf userServive;
	
	
	@BeforeClass
	public static void beforeClass(){
		//test="2345";	//static에러 반드시 이어야한다
		System.out.println("[ BeforeClass]");
	}
	
	@AfterClass 
	public static void afterClass(){
		System.out.println("[ AfterClass]");
	}
	
	@Before
	public void before(){
		//test="2345";	//static에러 반드시 이어야한다
		System.out.println("[ Before]");
		userServive = new UserService();
	}
	
	@After 
	public void after(){
		System.out.println("[ After]");
	}
	
	
	
	
	
	@Test
	public void selectUserAllTest() {
		/***Given 주어진 상황 : new 연산자를 사용하여 테스트할 객체 생성 ***/

		/***When 어떤 동작(메소드 호출) ***/
		List<UserVo> list=userServive.selectUserAll();
		System.out.println("list.size() : "+ list.size());
		
		/***Then 결과가 어떠해야하는지 정의 : (기대값,결과값) ***/
		assertEquals(105,list.size());
	}
	
	@Test
	public void selectUserTest() {
		/***Given 주어진 상황 : new 연산자를 사용하여 테스트할 객체 생성 ***/
		
		/***When 어떤 동작(메소드 호출) ***/
		//담지를 안았는데 UserVo
		//대상만 불러오고 
		UserVo userVo=userServive.selectUser("brown");
		System.out.println("1 userVo.getUserId() : "+ userVo.getUserId());
		System.out.println("1 userVo.getName() : "+ userVo.getName());
		
		/***Then 결과가 어떠해야하는지 정의 : (기대값,결과값) ***/
		//지정한 대상이 들고있는 정보를 비교 
		assertNotNull(userVo);
		assertEquals("brown",userVo.getUserId());
		assertEquals("브라운",userVo.getName());
	}
	
	@Test
	public void selectUserByVoTest() {
		/***Given 주어진 상황 : new 연산자를 사용하여 테스트할 객체 생성 ***/
		
		/***When 어떤 동작(메소드 호출) ***/
//		UserVo userVo = new UserVo();
//		userVo.setUserId("brown");
//		userVo=userDao.selectUser(userVo);
		//같은 코드
		UserVo userVo = userServive.selectUser("brown");
		
		System.out.println("2 userVo.getUserId() : "+ userVo.getUserId());
		System.out.println("2 userVo.getName() : "+ userVo.getName());
		
		/***Then 결과가 어떠해야하는지 정의 : (기대값,결과값) ***/
		//지정한 대상이 들고있는 정보를 비교 
		assertNotNull(userVo);
		assertEquals("brown",userVo.getUserId());
		assertEquals("브라운",userVo.getName());
	}

	@Test
	public void selectUserPageListTest() {
		
		PageVo pageVo = new PageVo();
		pageVo.setPage(11);
		pageVo.setPageSize(10);
		
		//List<UserVo> pageList = (List<UserVo>)userServive.selectUserPageList(pageVo);
		Map<String,Object> resultMap = userServive.selectUserPageList(pageVo);
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		
		int pageCnt = (Integer)resultMap.get("pageCnt");		
		System.out.println("3 pageList.size() : "+userList.size());
		
		assertEquals(5,userList.size());
		assertEquals(11,pageCnt);
		
	}
}
