import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {

	public static void main(String[] args) {
	//문제: 사칙연산 계산기
	Scanner scan = new Scanner(System.in);
	
	int result;
	String str, token_str;
//while문에서의 라벨
input_loop:
	while(true) {
		System.out.println("수식 입력 = ");
		//trim으로 불필요한 공백 제거
		str = scan.next().trim();
		scan.close();
		StringTokenizer token = new StringTokenizer(str, "+-*/", true);
		//첫번째 토큰 읽기..token_str은 아직 문자(문자열은 객체로 저장, 문자는 유니코드로 저장)
		token_str = token.nextToken();
		//input_check 토큰이 숫자인지 검사..맨 밑의 75번줄로 이동
		if (input_check(token_str)) {
		//true면 수식입력오류(토큰이 숫자가 아님)
			System.out.println("수식 입력 오류 \n");
		//14행의 while(true)로 이동
			continue;
		}
		//if문이 틀렸을 때 토큰을 숫자로 변환..
		//클래스.메소드 이런 형식은 스테틱 메소드
		result = Integer.parseInt(token_str);
	
		//토큰이 없을 때가지 반복
		while(token.hasMoreTokens()) {
		//짝수번째 토큰 읽음(연산자)
			token_str = token.nextToken();

		//문자열에서 연산자 추출
			char ch = token_str.charAt(0);
			System.out.println(ch);
			if (token.hasMoreTokens())
		//홀수번째 토큰 읽음(숫자)
				token_str = token.nextToken();
			else {
		//연산자로 수식이 끝나는 경우
				System.out.println("수식 입력 오류 \n");
				continue input_loop;
			}
		//input_check 토큰이 숫자인지 검사
			if (input_check(token_str)) {
				System.out.println("수식 입력 오류 \n");
				continue input_loop;
			}
			System.out.println(token_str);
		//p116 switch문
			switch(ch) {
			case '+':
				result += Integer.parseInt(token_str);
				break;
			case '-':
				result -= Integer.parseInt(token_str);
				break;
			case '*':
				result *= Integer.parseInt(token_str);
				break;
			case '/':
				result /= Integer.parseInt(token_str);
				break;
			}  //switch문 끝
		}  //while문 끝
		break;
	}  //while(true)문 끝
	System.out.println(str + "=" + result);		
	}
	
	static boolean input_check(String str) {
		char ch;
		//토큰을 전달 받아 문자열 길이만큼 한 문자씩 검사
		for (int i = 0; i < str.length(); i++) {
		//str( = ch)문자열에서 한 문자씩 추출
			ch = str.charAt(i);
		//ch가 숫자인지 유니코드로 검사 (0 < ch < 9 가 숫자)
			if (ch < '0' || ch > '9')
		//숫자 아닌 문자가 왔을 때-->return true->25줄의 수식 입력 오류 뜨고 continue로 다시 14행 시작
				return true;
		}	
		//숫자가 맞다는 뜻 -> 23~줄의 if 문 실행 안하고 바로 30줄 실행
		return false;
	}
	
}
