import java.io.IOException;
import java.io.InputStreamReader;

public class SystemClassEx01 {

	public static void main(String[] args) {
		InputStreamReader  reader = new InputStreamReader (System.in);
		
		try {
		//키보드로부터 한 글자씩 입력받아 출력하는데 . 입력할 때까지 반복
			while(true) {
			//read메소드의 리턴 값이 int타입인데 그 값이 문자 하나를 담아서 char로 캐스트해야함
				char ch = (char) reader.read();
				System.out.println("입력된 문자: " + ch);
				if (ch == '.')
					break;
			}
		}
        catch (IOException e) {
            System.out.println("키보드 입력 에러");
	}
 }
}
