package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;

/**
* UserDaoTest.java
*
* @author pc03
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* pc03 최초 생성
*
* </pre>
*/
public class UserDaoTest {

	private UserDaoInf userDao;
	
	@Before
	public void setup(){
		userDao = new UserDao();
	}
	
	//운영 메소드이름+Test
	@Test
	public void selectUserAllTest() {
		/***Given 주어진 상황 : new 연산자를 사용하여 테스트할 객체 생성 ***/
		
		/***When 어떤 동작(메소드 호출) ***/
//		Map<String, Object> map = 
//		System.out.println("map.size() : "+ map.size());
		
		// 목표 : UserDao.selectUserAll();   -> 반환타입 확인 후,
		List<UserVo> list=userDao.selectUserAll();
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
		UserVo userVo=userDao.selectUser("brown");
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
		UserVo userVo = userDao.selectUser("brown");
		
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
		
		List<UserVo> pageList = (List<UserVo>)userDao.selectUserPageList(pageVo);
		
		System.out.println("3 pageList.size() : "+pageList.size());
		assertEquals(5,pageList.size());
	}
	
	
	/**
	* Method : getUsetCntTest
	* 작성자 : pc03
	* 변경이력 :
	* Method 설명 : 전체 사용자 수 찾기 
	*/
	@Test 
	public void getUsetCntTest(){
		/***Given***/

		/***When***/
		int totalUserCnt =userDao.getUsetCnt();

		/***Then***/
		assertEquals(105, totalUserCnt);
	}
	
}
