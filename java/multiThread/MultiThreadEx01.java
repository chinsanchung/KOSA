package ch18;

public class MultiThreadEx01 {

	public static void main(String[] args) {
		// DigitThread.java를 사용하기 위해 여기서 객체 생성
		Thread thread = new DigitThread();
		//start로 호출시 run 메소드 동작
		thread.start();
		for (char ch = 'A'; ch <= 'Z'; ch++)
			System.out.print(ch);
		//sleep메소드 예외처리
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}
