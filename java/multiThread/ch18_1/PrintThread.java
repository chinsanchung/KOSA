package ch18_1;

public class PrintThread extends Thread {
	SharedArea sharedArea;
	public void run() {
	//isReady가 트루될때가지 컨티뉴반복..Busy Waiting
	//true 뜨면 프린트..이 작업으로 인해 시간 길어짐
		while(sharedArea.isReady != true)
			continue;
		System.out.println(sharedArea.result);
			
	}
}
