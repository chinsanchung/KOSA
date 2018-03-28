import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Ch09Calendar {

	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		TimeZone timeZone = TimeZone.getTimeZone("Europe/London");
		calendar.setTimeZone(timeZone);
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.AM_PM);
		int amPm = calendar.get(Calendar.AM_PM);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.SECOND);
		int sec = calendar.get(Calendar.SECOND);
		String sAmPm = amPm == Calendar.AM ? "오전" : "오후";
		//주어진 포맷으로 연월일시분초 출력
		System.out.printf("%d년 %d월 %d일 %s %d시 %d분 %d초",
				 		year, month, date, sAmPm, hour, min, sec);

	}

}
