
public class ExAccount04 {

	public static void main(String[] args) {
		//레퍼런스 변수들 obj1, obj2, obj3. new~~객체들3개
		Account01 obj1 = new Account01("111-22-33333", "Ken", 10000);
		CheckingAccount02 obj2 = new CheckingAccount02("444-55-66666", "May", 20000, "5555-6666-7777-88");
		CreditLineAccount03 obj3 = new CreditLineAccount03("777-88-99999", "Max", 30000, 20000000);
		
		printAccountInfo(obj1);
		printAccountInfo(obj2);
		printAccountInfo(obj3);

	}
	static void printAccountInfo(Account01 obj) {
		System.out.println("계좌번호: " + obj.accountNo);
		System.out.println("예금주 이름: " + obj.ownerName);
		System.out.println("잔액: " + obj.balance);
		System.out.println();
		}
	}

