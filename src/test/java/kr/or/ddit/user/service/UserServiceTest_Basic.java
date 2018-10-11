package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

import org.junit.Test;

public class UserServiceTest_Basic {

	@Test
	public void selectUserAllTest() {
		/***Given 주어진 상황 : new 연산자를 사용하여 테스트할 객체 생성 ***/
		UserServiceInf userServive= new UserService();
		
		List<UserVo> list=userServive.selectUserAll();
		System.out.println("list.size() : "+ list.size());
		
		/***Then 결과가 어떠해야하는지 정의 : (기대값,결과값) ***/
		assertEquals(105,list.size());
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
