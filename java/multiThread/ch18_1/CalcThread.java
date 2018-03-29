package ch18_1;

public class CalcThread extends Thread {
	SharedArea sharedArea;
	public void run() {
		double total = 0.0;
		for (int cnt = 1; cnt < 100000; cnt += 2)
			if (cnt / 2 % 2 == 0)
				total += 1.0 / cnt;
			else
				total -= 1.0 / cnt;
		sharedArea.result = total * 4;
		//sharedArea객체의 isReady필드 값을 트루로 설정
		sharedArea.isReady = true;
	}
}
