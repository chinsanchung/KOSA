
class Account01 {
	String accountNo;
	String ownerName;
	int balance;
	//생성자
	Account01(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	//메소드..입금
	void deposit(int amount) {
		balance += amount;
	}
	//메소드..출금 잔액부족 객체 만들었음
	int withdraw(int amount) throws Exception {
		if (balance < amount)
			throw new Exception("잔액 부족");
		balance -= amount;
		return amount;
	}
}
