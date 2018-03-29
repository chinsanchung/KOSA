package ch18;

public class SmallLetters implements Runnable {
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(ch);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
	}
  }
}