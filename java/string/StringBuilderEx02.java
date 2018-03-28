import java.util.Scanner;

public class StringBuilderEx02 {

	//주민번호 검사하기 6자리-7자리 총 14자리
	//1 남 2 여 3 남 4 여
	//123456-1234563 주민번호
	//234567 892345_ 가중치
	//합 = 1* 2 + 2* 3 + ~ + 6* 5
	//나머지 = 합 / 11
	//체크디지트: 11 - 나머지..주민번호 맨 끝 3이 체크디지트
	//Integer.parseInt(): 문자열-> 숫자
		String number;
		int p, q;
		int sum;
		int rest;
		int checkdigit;
		StringBuilderEx02(String number) {
			this.number = number;
		}
		
		
		int length = number.length();
		Scanner in = new Scanner(System.in);
		
		void input () {
		System.out.println("주민번호 입력: ");
		number = in.next();
		in.close();	
		if (length == 14) {
			System.out.println(number + "(0)");
		} else {
			System.out.println("주민번호 입력 오류");
			}
		}
		
		void process() {
//		sum = ((Integer.parseInt(a) * 2) + (Integer.parseInt(b) * 3) + (Integer.parseInt(c) * 4) +
//				(Integer.parseInt(d) * 5) + (Integer.parseInt(e) * 6) + (Integer.parseInt(f) * 7) +
//				(Integer.parseInt(g) * 8) + (Integer.parseInt(h) * 9) + (Integer.parseInt(i) * 2) +
//				(Integer.parseInt(j) * 3) + (Integer.parseInt(j) * 4) + (Integer.parseInt(k) * 5));
		
		rest = sum % 11;
		
		checkdigit = 11 - rest;
		
		for (p = 0; p < number.length(); p++) {
			if (p == 6)
				continue;
			System.out.println(Integer.parseInt(number.substring(p, p + 1)));
			for (q = 2; q < 10; q++) {
//				System.out.println(Integer.parseInt(number.substring(p, p + 1) * q);
			}
		
			}
		
		}
}
		
		
		



