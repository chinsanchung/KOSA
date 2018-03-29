package SungjukOracle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sungjuk {

	String hakbun, irum, grade;
	int kor, eng, math, total;
	double avg;
	
	Sungjuk()
	{
	}
	
	void input()
	{
	//finally에서 in.close를 위해 여기서 null 하고 try 안에서 in =~~하기
		BufferedReader in = null;
		try {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("학번 입력 => ");
		hakbun = in.readLine();
		System.out.print("이름 입력 => ");
		irum = in.readLine();
		System.out.print("국어 입력 => ");
		kor = Integer.parseInt(in.readLine());
		System.out.print("영어 입력 => ");
		eng = Integer.parseInt(in.readLine());
		System.out.print("수학 입력 => ");
		math = Integer.parseInt(in.readLine());
		} catch(IOException e) {
			System.out.println("입력 오류 " + e.getMessage());
		} 
	}//input
	
	void process()
	{
		total = kor + eng + math;
		avg = total /3.;
		
		switch ((int)avg/10)
		{
			case 10:
			case 9:
				grade = "수";
				break;
			case 8:
				grade = "우";
				break;
			case 7:
				grade = "미";
				break;
			case 6:
				grade = "양";
				break;
			default:
				grade = "가";
				break;
		}
	}
	
	void output()
	{
		System.out.printf("%4s  %3s   %4d  %4d  %4d  %4d %6.2f %3s\n",
				hakbun, irum, kor, eng, math, total, avg, grade);
	}
}
