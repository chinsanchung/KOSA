import java.util.Scanner;

public class problem02 {


	public static void main(String[] args) {
	/*임의의 두 수를 입력 받아 작은 수에서 큰 수 사이에 존재하는 소수(prime number)를
	 * 구해서 출력하시오
	 * 처리조건: 한 줄에 10개씩 출력, 마지막에 총 소수의 갯수를 출력(count)
	 * 결과: 첫 번째 숫자입력 => 100 두번째 => 10...10~100 사이 소수
	 * i = 10(j 2~9 나눠보기) 11(j 2~10 나눠보기) 12(j 2~11 나눠보기) ..이중루프
	 */
		//1. 임의의 두 수 입력
	int a = 100;
	int b = 10;
	System.out.println("<출력결과>");


		
	Scanner scanner = new Scanner(System.in);
	System.out.println("첫 번째 숫자 입력 => ");
	a = scanner.nextInt();
	System.out.println("두 번째 숫자 입력 => ");
	b = scanner.nextInt();

	//2. 소수 구해서 출력
	
	int i;
	int j;

	for (i = 10; i <= 100; i++) {
		for (j = 2; j < i; j++) {
	
			if (i % j == 0)  {
			
		  }
			System.out.print(i + ", ");
		}
	}
	
  }
}
