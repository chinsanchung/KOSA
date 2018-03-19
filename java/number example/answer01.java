//import 이유: scanner 클래스가 영역 다른 클래스 참조하기 위해
import java.util.Scanner;

public class answer01 {
//public으로 패키지가 다르더라도 해당 클래스 접근 허용
	public static void main(String[] args) {
		/*임의의 두 수를 입력받아 작은 수에서 큰 수까지의 구구단을 출력하시오 
		출력결과: 첫번째 숫자 입력 => 7   두 번째 숫자 입력 => 3
		3단   4단   7단
		큰 수 작은수: if문..마지막 출력은 반복+이중구조*/

		Scanner in = new Scanner(System.in);
		int num1, num2, min, max; //num1, num2, min, max 변수의 값들은..처음에 
//		System.out.println(num1);
		
		System.out.print("첫 번째 숫자 입력 => ");
		num1 = in.nextInt();  
		System.out.print("첫 번째 숫자 입력 => ");
		num2 = in.nextInt();
		System.out.println();
		//큰 값은 max, 작은건 min
		
		if (num1 < num2) {
			min = num1;
			max = num2;
		} else {
			min = num2;
			max = num1;
		}
		
		for (int i = min; i <= max; i++) {
			System.out.print("*** " + i + "단 *** ");
		}
		System.out.println();
		for (int j = 1; j <= 9; j++) {
			for (int i = min; i <= max; i++) {
				System.out.printf("%d * %d = %2d   ", i, j, i * j);
			}  //%2d 는 두 자리수 정수 입력가능하게 공간만듬
			System.out.println();
		}
	}

}
