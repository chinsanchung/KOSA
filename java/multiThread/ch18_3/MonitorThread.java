package ch18_3;

public class MonitorThread extends Thread {
	Thread thread;
	//생성자
	MonitorThread(Thread thread) {
		this.thread = thread;
	}
	public void run() {
		while (true) {
			Thread.State state = thread.getState();
			System.out.println("쓰레드 상태: " + state);
			if (state == Thread.State.TERMINATED)
				break;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
