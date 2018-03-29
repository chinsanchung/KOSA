import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemClassEx02 {

	public static void main(String[] args) {
		//system클래스의 in 필드로 BufferedReader객체 생성함
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		//키보드에서 한 줄 입력받아 출력
		try {
			String str = reader.readLine();
			System.out.println("입력된 문자열: " + str);
		}
		//readLine메소드가 발생하는 IOException을 처리함
		catch (IOException e) {
			System.out.println("키보드 입력 에러");
		}

	}

}
