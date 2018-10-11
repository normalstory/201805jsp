/**
 * 
 */
package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;


public class PageEtcTest {

	/**
	 * Method : tearDownAfterClass
	 * 작성자 : pc03
	 * 변경이력 :
	 * @throws java.lang.Exception
	 * Method 설명 : 
	 */
	
	@Test
	public void pageNaviCalTest() {
		/***Given***/
		int total =105;
		int pageSize =10;

		/***When***/
		//floor, ceil
		int naviSize = (int)Math.ceil((double)total/pageSize);
		
		/***Then***/
		assertEquals(11, naviSize);
	}

}
