package ch18;

public class MultiThreadEx03 {

	public static void main(String[] args) {
	//thread 생성
		Thread thread = new Thread(new SmallLetters());
	//thread 시작
		thread.start();
		char arr[] = { 'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ', 
					'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' };
		for (char ch : arr) {
			System.out.print(ch);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	  }
	}
}
