
public class ExAccount04_02 {
	public static void main(String[] args) throws Exception {
		//배열과 다형성으로 해보는 방식
		Account01 obj[] = new Account01[3];
		obj[0] = new Account01("111-22-33333", "Ken", 10000);
		obj[1] = new CheckingAccount02("444-55-66666", "May", 20000, "5555-6666-7777-88");
		obj[2] = new CreditLineAccount03("777-88-99999", "Max", 30000, 20000000);
		
		printAccountInfo(obj);
		
	}
	//i가 0일때 Account01의 accountNo, i가 1일때 CheckingAccount02의 accountNo...
	//같은 이름의 accountNo지만 내용은 다르다..다형
	static void printAccountInfo(Account01 obj1[]) throws Exception {
	  for(int i = 0; i < obj1.length; i++) {
		System.out.println("계좌번호: " + obj1[i].accountNo);
		System.out.println("예금주 이름: " + obj1[i].ownerName);
		System.out.println("잔액: " + obj1[i].balance);
		System.out.println();
		}
	}
}
