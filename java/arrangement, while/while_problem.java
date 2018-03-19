import java.util.Scanner;

public class problem01_ch04 {

	public static void main(String[] args) {
//	학번, 이름, 국어, 영어, 수학 점수를 입력 받은 후 총점, 평균, 등급을 구해서 출력하기
//	등급은 if문으로 구하기
//	<출력결과> 
//					*** 성적표 ***
//	=====================================				
//	학번	   이름  국어 영어 수학 총점 평균 등급
//	=====================================
//	A001  홍길동  70   80   90  240  80.0 우
	
		//1 출력결과와 성적표 입력
		
		System.out.print("<출력결과>");
		System.out.println();
		System.out.println("\t\t\t\t" + "*** 성적표 ***");
		System.out.println();
		System.out.println("============================================================");
		System.out.println("학번    " + "이름    " + "국어  " + "영어  " + "수학  " + "총점  " + "평균   "+ "등급");		
		System.out.println("============================================================");
		//2...오류
		String num;
		String name;
		int kor;
		int eng;
		int math;
		Scanner scan = new Scanner(System.in);
		System.out.print("학번 : ");
		num = scan.next();
		System.out.print("이름 : ");
		name = scan.next();
		System.out.print("국어 : ");
		kor = scan.nextInt();
		System.out.print("영어 : ");
		eng = scan.nextInt();
		System.out.print("수학 : ");
		math = scan.nextInt();
		System.out.println();
		scan.close();
		//3 학생 정보 입력

		System.out.printf("%s %s %5d %4d %3d", num, name, 70, 80, 90);
		//4 총점과 평균과 등급
		int sum = kor + eng + math;
		int avg = (sum / 3);
		String grade;
		if (avg >= 80) {
			grade = "우";
		

		System.out.printf("   %d %3d %3s", sum, avg, grade);
		}
	}

}
