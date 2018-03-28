import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList02 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		//Iterator 메소드 호출로Iterator 객체 생성
		Iterator<String> iterator = list.iterator();
		//Iterator 객체를 이용해 리스트의 데이터를 순차적으로 가져와 출력
		

		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
		}
	}

}
