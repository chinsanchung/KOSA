
public class StringEx01 {

	public static void main(String[] args) {
		String str = "자바 커피";
		//length 메소드 호출
		int len = str.length();
		for (int cnt = 0; cnt < len; cnt++) {
			//charAt 메소드 호출
			char ch = str.charAt(cnt);
			System.out.println(ch);
		}
		
	}

}
