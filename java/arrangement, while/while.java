
public class chapter04 {

	public static void main(String[] args) {

//1. 		
//		int i = 1;  //1 초기식
//		while (i <= 10)//2 조건식 
//			{
//			System.out.println(i); //3 반복내용
//			i++; //4 증감식
//		}
//2. 1~10 까지 while문
//		int i = 1;
//		int sum = 0;
//		while (i <= 100) {
//		
//			sum += i;
//			i++;
//		} 
//		System.out.println("i = " + i);
//		System.out.println("sum = " + sum);
//3. do while문
//		int i = 1;
//		int sum = 0;
//		do {
//			sum += i;
//			i++;	
//		} while (i <= 100); 
//		
//		System.out.println("i = " + i);
//		System.out.println("sum = " + sum);
		
//4. do while로 홀수 합과 짝수 합을 출력하기
//		int i = 1;
//		int odd=0; 
//		int even=0;
//		do {
//			
//
//			if (i % 2 == 0) {
//				even += i;
//			} else {
//				odd += i;
//			}
//			i++;
//			
//		} while (i <= 100); 
//
//		System.out.println("i = " + i);
//		System.out.println("odd = " + odd);
//		System.out.println("even = " + even);
//		
//5. continue문
		int i = 1;
		int sum = 0;
		for (i = 1; i <= 100; i++) {
			if (i % 2 == 0)
				continue;
			sum += i;
			
		}
		//짝수면 continue로 sum이 수행안된다.
		System.out.println("i = " + i);
		System.out.println("홀수합 = " + sum);
	}
	
}
