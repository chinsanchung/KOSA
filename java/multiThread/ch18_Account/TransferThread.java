package ch18_Account;

public class TransferThread extends Thread {
	SharedArea sharedArea;
	//생성자
	TransferThread(SharedArea area) {
		sharedArea = area;
	}
	public void run() {
		for (int cnt = 0; cnt < 12; cnt++) {
//			//synchronized로 묶기
//			synchronized (sharedArea) {
//			sharedArea.account1.withdraw(1000000);
//			System.out.print("Lee account: 100만원 인출, ");
//			sharedArea.account2.withdraw(1000000);
//			System.out.println("Sung account: 100만원 입금");
//			}
			//SharedArea에 만들어놓아서 위의 것 필요 없음
			sharedArea.transfer(100);
			}
	}
}
