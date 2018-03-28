
public class Ch10Exception_Ex03 {
	public static void main(String[] args) {
		Ch10Exception_Account02 account = new Ch10Exception_Account02();
	
	//deposit
	account.deposit(10000);
	System.out.println("deposit: " + account.getBalance());
	
	//withdraw
	try {
		account.withdraw(30000);
	} catch(Ch10Exception01 e) {
		String message = e.getMessage();
		System.out.println();
		e.printStackTrace();
	}
	
	
  }
}
