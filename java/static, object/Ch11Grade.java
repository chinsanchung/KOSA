	import java.util.Scanner;

	public class Ch11Grade {
		String hakbun, irum, grade;
		int kor, eng, math, tot;
		double avg;
		
		static int cnt = 0;
		static double total_avg = 0;
		
		Ch11Grade(){
		}
		
		Ch11Grade(String hakbun, String irum, int kor, int eng, int math){
			this.hakbun = hakbun;
			this.irum = irum;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		boolean input()
		{
			Scanner in = new Scanner(System.in);
			
			System.out.print("학번 입력 => ");
			hakbun = in.next();
			if (hakbun.equals("exit"))
				return true;
			
			System.out.print("이름 입력 => ");
			irum = in.next();
			System.out.print("국어 입력 => ");
			kor = in.nextInt();
			System.out.print("영어 입력 => ");
			eng = in.nextInt();
			System.out.print("수학 입력 => ");
			math = in.nextInt();
			cnt++;
			return false;
			
		}
		
		void process()
		{
			tot = kor + eng + math;
			avg = tot / 3.;
			total_avg += avg;

			switch((int)avg/10)
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
			System.out.printf("%4s   %3s   %3d     %3d     %3d     %3d   %6.2f    %2s\n", 
					hakbun, irum, kor, eng, math, tot, avg, grade);
		}
		
		static double get_totalavg()
		{
			return total_avg / cnt;
		}
		//뒤 GradeEquals 의 obj1과 obj2 비교시 주소 말고 안의 값들로 비교해 같도록 만듬
		//object클래스에다 obj를 오버라이딩
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Ch11Grade) {
				Ch11Grade grade = (Ch11Grade) obj;
				if(hakbun.equals(grade.hakbun) &&
				   irum.equals(grade.irum) &&
				   kor == grade.kor &&
				   eng == grade.eng &&
				   math == grade.math) {
					return true;
				}						  				
			}
			return false;
		}
	}


