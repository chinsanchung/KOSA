import java.util.Scanner;

public class Ch06Static01 {
	
	String code, name;
	int price, amount;
	int totalP = 0;
	//정적 필드 추가하기
	static int cnt = 0;
	static int total = 0;
	
	Ch06Static01() {
		
	}
		
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
		
		cnt++;
		//성공시 리턴 false...if문으로 올라간다
		return false;
			}	
	//입력 끝나고 process로 넘어감
	void process() {
		totalP = amount * price;
		total += totalP;
	}
	void output() {
		System.out.printf("%4s     %4s    %6d       %5d      %8d\n",
				code, name, amount, price, totalP);
	}
	//뒤파일의 System.out.println(Ch06Static01.total);를 대신하려고 만든 정적메소드
	static int getTotal() {
		return total;
	}
}
