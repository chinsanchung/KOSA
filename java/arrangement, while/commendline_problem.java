import java.util.Scanner;

public class Ch05problem01 {

	public static void main(String[] args) {
	//커맨드라인 예제 학번, 이름, 국어, 영어, 수학, 총점, 평균, 등급
	//A001 이기자 88 88 88    A002 김기자 99 99 99
	//0817의 answer01 이용

		String[] num = new String[2]; 
		String[] name = new String[2]; 
		String grade ;
		int[] kor = new int[2];
		int[] eng = new int[2];
		int[] math = new int[2]; 
		int[] total = new int[2];
		double[] avg = new double[2];
		Scanner in = new Scanner(System.in);
		//1 첫번째 사람
		System.out.print("학번 입력 => ");
		num[0] = in.next();
		System.out.print("이름 입력 => ");
		name[0] = in.next();
		System.out.print("국어 입력 => ");
		kor[0] = in.nextInt();
		System.out.print("영어 입력 => ");
		eng[0] = in.nextInt();	
		System.out.print("수학 입력 => ");
		math[0] = in.nextInt();	
		total[0] = kor[0] + eng[0] + math[0];
		avg[0] = total[0] / 3.;
		
		if (avg[0] >= 90)
			grade = "수";
		 else if (avg[0] >= 80) 
			grade = "우";
		 else if (avg[0] >= 70) 
			grade = "미";
		 else if (avg[0] >= 60) 
			grade = "양";
		 else grade = "가";
		//2번째 사람
		Scanner in1 = new Scanner(System.in);
		System.out.print("학번 입력 => ");
		num[1] = in1.next();
		System.out.print("이름 입력 => ");
		name[1] = in1.next();
		System.out.print("국어 입력 => ");
		kor[1] = in1.nextInt();
		System.out.print("영어 입력 => ");
		eng[1] = in1.nextInt();	
		System.out.print("수학 입력 => ");
		math[1] = in1.nextInt();
		total[1] = kor[1] + eng[1] + math[1];
		avg[1] = total[1] / 3.;
		
		in.close();
		in1.close();
		
		if (avg[1] >= 90)
			grade = "수";
		 else if (avg[1] >= 80) 
			grade = "우";
		 else if (avg[1] >= 70) 
			grade = "미";
		 else if (avg[1] >= 60) 
			grade = "양";
		 else grade = "가";
		
		System.out.println("\n\t\t       *** 성적표 ***");
		System.out.println("=========================================================");
		System.out.println("학번     이름    국어    영어    수학    총점    평균    등급");
		System.out.println("=========================================================");
		System.out.printf("%2s    %2s    %3d    %3d    %3d    %3d    %6.2f    %2s\n",
						  num[0], name[0], kor[0], eng[0], math[0], total[0], avg[0], grade);
		System.out.printf("%2s    %2s    %3d    %3d    %3d    %3d    %6.2f    %2s\n",
				  num[1], name[1], kor[1], eng[1], math[1], total[1], avg[1], grade);	
		System.out.println("=========================================================");	
	
	
	
	
	
	
	
	
	}

}
