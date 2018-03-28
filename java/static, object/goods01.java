import java.util.Scanner;

public class Sangpum01 {
	//code 제품코드 name 제품명 price 단가 amount 수량 totalP 금액
	//input() 제품코드, 제품명, 단가, 수량 입력
	//process() 금액= 수량*단가
	//output() 제품코드, 제품명, 단가, 수량, 금액 출력
	//1
	String code, name;
	int price, amount;
	int totalP = 0;
	
	//2 생성자
	Sangpum01() {
		
	}
	
	//3 메소드
	boolean input() {	
		Scanner in = new Scanner(System.in);
		System.out.println("제품코드: ");
		code = in.next();
		
		if (code.equals("exit")) {
			return true;
		}
		System.out.println("제품명: ");
		name = in.next();
		System.out.println("수량: ");
		amount = in.nextInt();
		System.out.println("단가: ");
		price = in.nextInt();
		
		System.out.println();
		//성공시 리턴 false
		return false;
			}	
	void process() {
		totalP = amount * price;
	}
	void output() {
		System.out.printf("%4s     %4s    %6d       %5d      %8d\n",
				code, name, amount, price, totalP);
	}
	
}
