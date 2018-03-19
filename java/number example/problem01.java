import java.util.Scanner;

public class problem01 {

	public static void main(String[] args) {
	/*임의의 두 수를 입력받아 작은 수에서 큰 수까지의 구구단을 출력하시오 
	출력결과: 첫번째 숫자 입력 => 7   두 번째 숫자 입력 => 3
	3단   4단   7단
	큰 수 작은수: if문..마지막 출력은 반복+이중구조*/
	//1. 숫자 입력
	int a = 7;
	int b = 3;
	System.out.println("<출력결과>");
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("첫 번째 숫자 입력 => ");
	a = scanner.nextInt();
	System.out.println("두 번째 숫자 입력 => ");
	b = scanner.nextInt();


	//2. 구구단 입력
	for (int j = 3; j< 8; j++) {
		System.out.print(j + "단" + "\n");	
		for (int i = 1; i < 10; i++) {
			System.out.println(j + " * " + i + " = " + j * i);

			}
		}


	

  
 }
}
