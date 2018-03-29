package ch18;

public class MultiThreadEx02 {
	//3개의 스레드를 생성해서 시작합니다
	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new DigitThread();
		Thread thread3 = new AlphabetThread();
	
		thread1.start(); //2번째 스레드 실행
		thread2.start(); //3번째 스레드 실행
		thread3.start(); //4번째 스레드 실행
	}

}
