package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class fUserServiceTest_bak2 {

	//jUnit 실행주기 
	//@BeforeClass : 어노테이션이 적용된 메소드 최초 1회
	//@Before : 어노테이션이 적용된 메소드 실행 - 테스트 메소드 실행 전 실행
	//@Test	  :  
	//@After  : 어노테이션이 적용된 메소드 실행 - 테스트 메소드 실행 후 실행
	//@AfterClass  : 어노테이션이 적용된 메소드 최초 1회
	
	//@BeforeClass
	//@Before	-> 	selectUserAllTest()	-> @After
	//@Before	-> 	selectUserTest()	-> @After
	//@Before	-> 	selectUserByVoTest()-> @After
	//@AfterClass
	
	private String test="";
	
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
		System.out.println("[ BeforeClass]");
	}
	
	@After 
	public void after(){
		System.out.println("[ AfterClass]");
	}
	
	
	
	
	
	@Test
	public void selectUserAllTest() {
		/***Given 주어진 상황 : new 연산자를 사용하여 테스트할 객체 생성 ***/
		UserServiceInf userServive= new UserService();
		
		List<UserVo> list=userServive.selectUserAll();
		System.out.println("list.size() : "+ list.size());
		
		/***Then 결과가 어떠해야하는지 정의 : (기대값,결과값) ***/
		assertEquals(5,list.size());
	}
	
	@Test
	public void selectUserTest() {
		/***Given 주어진 상황 : new 연산자를 사용하여 테스트할 객체 생성 ***/
		UserServiceInf userServive= new UserService();
		
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
		UserServiceInf userServive= new UserService();
		
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

}
