import java.util.Scanner;

public class AnsPersonInfo04 extends AnsPerson01 implements AnsPersonable02{
	String phone;
	String addr;
	
	static int cnt = 0;
	
	AnsPersonInfo04() {
		
	}
	//input, output의 출력은 Personable이 아닌 여기에서 출력
	public boolean input() {
	Scanner in = new Scanner(System.in);
	System.out.print("학번 입력 => ");
	number = in.next();
	if (number.equals("exit")) 
		return true;
	System.out.print("이름 입력 => ");
	name = in.next();
	System.out.print("전화번호 입력 => ");
	phone = in.next();
	System.out.print("주소 입력 => ");
	addr = in.next();	
	cnt++;
	return false;	
	}
	
	public void output() {
		System.out.printf("%4s    %8s    %8s         %5s",
				  number, name, phone, addr);
	}

}
