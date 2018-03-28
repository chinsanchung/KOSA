import java.util.Scanner;

public class Ch05problem02 {
	static int MAX = 100;
	public static void main(String[] args) {
	//제품코드, 제품명, 수량, 단가, 금액(수량 * 단가) 입력..exit로 탈출
	// *** 판매현황 *** 밑에는 성적표와 동일하게 뜸 마지막에 총 판매금액
	//1	
	String code[] = new String[MAX];
	String name[] = new String[MAX];
	int amount[] = new int[MAX];
	int price[] = new int[MAX];
	int totalP[] = new int[MAX];
	int i, cnt = 0;
	int sum = 0;
	//2
	Scanner in = new Scanner(System.in);	
	
	for(i = 0; i < MAX; i++) {
	System.out.println("제품코드: ");
	code[i] = in.next();
	
	if (code[i].equals("exit")) {
		break;
	}
	System.out.println("제품명: ");
	name[i] = in.next();
	System.out.println("수량: ");
	amount[i] = in.nextInt();
	System.out.println("단가: ");
	price[i] = in.nextInt();
	totalP[i] = amount[i] * price[i];
	cnt++;
	System.out.println();
	}
	in.close();
	//3
	System.out.println("\n\t       *** 판매현황 ***");
	System.out.println("=============================================");
	System.out.println("제품코드     제품명      수량      단가       금액");
	System.out.println("=============================================");
	for (i = 0; i < cnt; i++) {
	System.out.printf("%4s    %3s    %6d     %5d    %8d\n",
					  code[i], name[i], amount[i], price[i], totalP[i]);
	sum += totalP[i];
	}
	System.out.println("=============================================");
	//4 마지막에 총 판매금액을 출력	
	System.out.println("\t\t\t총 판매금액 : " + sum);
	
	
	
	}
}
