package kr.or.ddit.sum;

public class CalculationLogic {

	public int sumBetweenTwoNumbers(int start, int end) {
		
		int min = Math.min(start, end);
		int max = Math.max(start, end);
		
		int sum = 0 ;
		for(int i=min; i<=max; i++){
			sum+=i;
		}
		return sum;
	}
	
	//테스트 01 ->jUnit이라는 테스트 프레임워크를 사용 
	public static void main(String[] args) {
		CalculationLogic logic = new CalculationLogic();
		int start=1;
		int end =10;
		
		int result = logic.sumBetweenTwoNumbers(start, end);
		if(result==55){
			System.out.println("정답");
		}else{
			System.out.println("노답");
		}
		
		result = logic.sumBetweenTwoNumbers(start+2, end+2);
		if(result==75){
			System.out.println("정답");
		}else{
			System.out.println("노답");
		}
	}

}
