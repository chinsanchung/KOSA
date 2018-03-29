package ch18;

public class DigitThread extends Thread {
	public void run() {
		for (int cnt = 0; cnt < 10; cnt++) {
			System.out.print(cnt);
		//sleep메소드를 위한 예외처리
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}//catch
		}//for
	}//run
}//end
