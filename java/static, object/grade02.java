
public class Sungjuk02 {
	static int MAX = 100;
	public static void main(String[] args) {
	//성적 객체 그 자체가 100개 만든게 아니라 성적 객체 주소를 보관할 레퍼런스 타입 배열이 MAX개
		Sungjuk obj[] = new Sungjuk[MAX];
	//밑의 정적메소드들을 출력함..클래스 내부의 메소드라 앞에 객체명 필요없다
		sungjuk_input(obj);
		sungjuk_output(obj);
	}
	
	//입력하는 과정을 정적메소드로 만듬..이때의 obj[]는 obj가 참조할 객체 주소
	//이름은 같아도 이 영역 안에서만 사용함
	static void sungjuk_input(Sungjuk obj[]) {
		int i;
		for (i = 0; i < MAX; i++) {
			obj[i] = new Sungjuk();
			//break로 for문 빠져나옴..입력 끝이남
			if (obj[i].input())
				break;
			
			obj[i].process();
			System.out.println();
		}
	}
	//출력과정을 정적메소드로 만듬..main메소드가 static이니 출력하는거도 static
	static void sungjuk_output(Sungjuk obj[]) {
		int i;
		System.out.println("\n\t\t      *** 성적표 ***");
		System.out.println("===========================================================");
		System.out.println("학번    이름    국어    영어    수학    총점    평균    등급");
		System.out.println("===========================================================");
		//for문으로 입력한 것만큼 나오게함
		for (i = 0; i < Sungjuk.cnt; i++) {
			obj[i].output();
		}
		System.out.println("===========================================================");
		System.out.printf("\t\t\t 총 학생수 = %d, 전체 평균 = %5.2f", Sungjuk.cnt, Sungjuk.getTotal());
	}
}
