package ch18_Account;

public class PrintThread extends Thread {
	SharedArea sharedArea;
	//생성자
	PrintThread(SharedArea area) {
		sharedArea = area;
	}
	public void run() {
		for (int cnt = 0; cnt < 3; cnt++) {
			//synchronized로 묶기
//			synchronized (sharedArea) {
//			int sum = sharedArea.account1.balance +
//					sharedArea.account2.balance;
			//SharedArea에 만들어놓아서 위의 것 필요 없음
			int sum = sharedArea.getTotal();
			System.out.println("계좌 잔액 합계: " + sum);
			}//for
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}//catch
		}//run
}

