import java.util.Scanner;

public class AnsStringBuilderEx02 {
	public static void main(String[] args) {
		//w는 가중치, remain: 나머지
		int i, w = 2, checkdigit, sum = 0;
		String num;
		
		Scanner scan = new Scanner(System.in);
		
		//01 주민번호 입력 검사 시작
		while(true) {
			System.out.println("주민번호 입력 => ");
			num = scan.next();
			
			if(!input_check(num)) {
				System.out.println("주민번호 입력 오류");
				continue;
			} else 
				break;
		}
		// 검사 끝
		
		//2 합, 나머지, 체크디지트 구하기
		for (i = 0; i < num.length() - 1; i++) {
			//중간의 -를 생략
			if (i == 6)
				continue;
			sum += Integer.parseInt(num.substring(i, i + 1)) * w;
			w++;
			//w 9 다음엔 다시 2부터 시작해서 설
			if (w == 10) 
				w = 2;	 
		//응용 sum += (num.charAt(i) - '0') * w
		}
		
		checkdigit = 11 - sum % 11;
		if (checkdigit == 10)
			checkdigit = 0;
		else if (checkdigit == 11)
			checkdigit = 1;
		
		if (checkdigit == Integer.parseInt(num.substring(13, 14)))
			System.out.println("주민번호: " + num + "(0)");
		else
			System.out.println("주민번호: " + num + "(X)");
	}
	
	static boolean input_check(String str) {
		char ch;
		//입력한 문자열이 14자리인지 검사
		if (str.length() != 14)
			return false;
		//문자열을 전달받아서 문자열 길이만큼 한 문자씩 검사
		for (int i = 0; i < str.length(); i++) {
			//문자열에서 한 문자씩 추출
			ch = str.charAt(i);
			// '-'인지 검사하기
			if (i == 6) {
				if (ch != '-')
					return false;
			}
			//성별 값 검사
			else if (i == 7) {
				if (!(ch == '1' || ch == '2' || ch == '3' || ch == '4'))
					return false;
			//ch가 숫자인지 아닌지 유니코드로 비교
			} else if (ch < '0' || ch > '9'){
				return false;		
			}
		}
		return true;

	}	
}
