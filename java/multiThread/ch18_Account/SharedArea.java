package ch18_Account;

public class SharedArea {
	Account account1; //Lee
	Account account2; //Sung
//두번째 synchronized
	//계좌이체
	void transfer(int amount) {
		synchronized (this) {
			account1.withdraw(1000000);
			System.out.print("Lee account: 100만원 인출, ");
			account2.withdraw(1000000);
			System.out.println("Sung account: 100만원 입금");
		}//synchronized
	}//transfer
	//잔액 합계
	int getTotal() {
		synchronized (this) {
			return account1.balance + account2.balance;
		}//synchronized
	}//getTotal
}//end


