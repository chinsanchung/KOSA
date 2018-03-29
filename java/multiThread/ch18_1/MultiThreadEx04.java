package ch18_1;

public class MultiThreadEx04 {

	public static void main(String[] args) {
		//값이 0.0이 나오는 이유는 스레드1과 2중 2이 먼저 실행될시
		//프린트를 먼저 해버려 0.0이 뜨고 그 다음에 계산을 함
		//그래서 스레드1부터 하도록 강제해야 값이 나옴 p699
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		thread1.start();
		thread2.start();
	}

}
