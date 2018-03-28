import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Ch09SimpleDateFormat {

	public static void main(String[] args) {
		
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년  MM월 dd일 aa hh시 mm분 ss초");
		//문자열로 만듬
		String str = dateFormat.format(calendar.getTime());
		System.out.println(str);
	}

}
