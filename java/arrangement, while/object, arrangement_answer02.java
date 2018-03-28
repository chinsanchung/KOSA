import java.util.Scanner;

public class Ch05answer01 {
	//static으로 객체 생성 유무 상관없이 사용가능한 필드 생성, 아래 static void는 메소드가 됨
	//정적 필드..얼마든지 사용이 가능한것 236쪽
	static int MAX = 5;
	public static void main(String[] args) {
	//커맨드라인 예제 학번, 이름, 국어, 영어, 수학, 총점, 평균, 등급
	//A001 이기자 88 88 88    A002 김기자 99 99 99
	//0817의 answer01 이용

		String[] num = new String[MAX]; 
		String[] name = new String[MAX]; 
		String[] grade = new String[MAX];
		int[] kor = new int[MAX];
		int[] eng = new int[MAX];
		int[] math = new int[MAX]; 
		int[] total = new int[MAX];
		double[] avg = new double[MAX];
		int i, cnt = 0;
		//cnt는 입력해왔던 값들 카운트
		Scanner in = new Scanner(System.in);
		
		for (i = 0; i < MAX; i++) {
		System.out.print("학번 입력 => ");
		num[i] = in.next();
		//exit로 break 빠져나오기
		if (num[i].equals("exit")) {
			break;
		}
		System.out.print("이름 입력 => ");
		name[i] = in.next();
		System.out.print("국어 입력 => ");
		kor[i] = in.nextInt();
		System.out.print("영어 입력 => ");
		eng[i] = in.nextInt();	
		System.out.print("수학 입력 => ");
		math[i] = in.nextInt();	
		total[i] = kor[i] + eng[i] + math[i];
		avg[i] = total[i] / 3.;
		
		if (avg[i] >= 90)
			grade[i] = "수";
		 else if (avg[i] >= 80) 
			grade[i] = "우";
		 else if (avg[i] >= 70) 
			grade[i] = "미";
		 else if (avg[i] >= 60) 
			grade[i] = "양";
		 else grade[i] = "가";
		//cnt로 카운트, 입력받은 데이터들 숫자. 밑의 for문에 적용해 입력한 것만큼 나오게함
		cnt++;
		System.out.println();
		}
		in.close();
		System.out.println("\n\t\t       *** 성적표 ***");
		System.out.println("=========================================================");
		System.out.println("학번      이름     국어     영어     수학     총점     평균     등급");
		System.out.println("=========================================================");
		for (i = 0; i < cnt; i++) {
		System.out.printf("%4s    %3s    %3d    %3d    %3d    %3d    %6.2f    %2s\n",
						  num[i], name[i], kor[i], eng[i], math[i], total[i], avg[i], grade[i]);
		}
		System.out.println("=========================================================");	
	}


}
