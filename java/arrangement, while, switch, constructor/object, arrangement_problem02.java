
public class Ch05Example {

	public static void main(String[] args) {
	//2차원 배열 연습
	int[][] mathScores = new int[2][3];
	for(int i = 0; i < mathScores.length; i++) {
		for(int k = 0; k < mathScores[i].length; k++) {
			System.out.println("mathScores[" + i + "][" + k + "] = " +mathScores[i][k]);
		}
	}
	System.out.println();
	
	int[][] englishScores = new int[2][];
	englishScores[0] = new int[2];
	englishScores[1] = new int[3];
	for(int i = 0; i < englishScores.length; i++) {
		for(int k = 0; k < englishScores[i].length; k++) {
			System.out.println("englishScores[" + i + "][" + k + "] = " +englishScores[i][k]);
		}
	}
	System.out.println();
	
	int[][] javaScores = { {95, 80}, {92, 96, 80} };
	for(int i = 0; i < javaScores.length; i++) {
		for(int k = 0; k < javaScores[i].length; k++) {
			System.out.println("javaScores[" + i + "][" + k + "] = " +javaScores[i][k]);
		}
	}
	//p170의 향상된 for문..scores안의 {값들}의 횟수만큼 for문을 실행한다.
	int[] scores = {95, 71, 84, 93, 87 };
	String[] data = {"MBC", "KBS", "SBS"};
	int sum = 0;
	for (int score : scores) {
		sum = sum + score;
	}
	System.out.println("점수 총합 = " + sum);
//  일반적인 for문이라면
//	sum = 0;
//	for (int i =0; i < scores.length; i++) {
//		sum = sum + scores[i];
//	}
	double avg = (double) sum / scores.length;
	System.out.println("점수 평균 = " + avg);
	
	for (String dat: data) 
		System.out.println(dat);

	}

}
