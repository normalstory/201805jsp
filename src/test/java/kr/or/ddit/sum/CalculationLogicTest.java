package kr.or.ddit.sum;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculationLogicTest {

	//순서 보장 안됨. 어떤 메서드를 먼저 실행하더라도 에러여부와 상관 없어야함
	//어노테이션(@test) 필수
	@Test
	public void sumBetweenTwoNumbers() {
		CalculationLogic logic = new CalculationLogic();
		int start=10;
		int end =1;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		//assertEquals(55, sumResult);
		assertEquals(55, sumResult);
	}

	@Test
	public void sumBetweenTwoNumbers2() {
		CalculationLogic logic = new CalculationLogic();
		int start=1;
		int end =10;
		
		int sumResult = logic.sumBetweenTwoNumbers(start+2, end+2);
		
		assertEquals(75, sumResult);
		
	}
}