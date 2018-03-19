import java.util.Scanner;

public class answer01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num, name, grade;
		int kor, eng, math, total;
		double avg;
		Scanner in = new Scanner(System.in);
		
		System.out.print("학번 입력 => ");
		num = in.next();
		System.out.print("이름 입력 => ");
		name = in.next();
		System.out.print("국어 입력 => ");
		kor = in.nextInt();
		System.out.print("영어 입력 => ");
		eng = in.nextInt();	
		System.out.print("수학 입력 => ");
		math = in.nextInt();	
		in.close();
		total = kor + eng + math;
		//3.으로 더블타입으로 전환하게 된다(나누기는 소수점도 나오니까)
		avg = total / 3.;
		
		if (avg >= 90)
			grade = "수";
		 else if (avg >= 80) 
			grade = "우";
		 else if (avg >= 70) 
			grade = "미";
		 else if (avg >= 60) 
			grade = "양";
		 else grade = "가";
		
		System.out.println("\n\t\t       *** 성적표 ***");
		System.out.println("=========================================================");
		System.out.println("학번     이름    국어    영어    수학    총점    평균    등급");
		System.out.println("=========================================================");
		System.out.printf("%2s    %2s    %3d    %3d    %3d    %3d    %6.2f    %2s\n",
						  num, name, kor, eng, math, total, avg, grade);
	}

}
