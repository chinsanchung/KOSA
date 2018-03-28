import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx01 {

	public static void main(String[] args) {
	//집합으로 사용할 HashSet 객체 생성
		HashSet<String> set = new HashSet<String>();
		set.add("java");
		set.add("cappuccino");
		set.add("espresso");
		set.add("java");
		System.out.println("저장된 데이터 수 = " + set.size());
	//집합에 있는 데이터를 모두 가져와 출력
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);	
		}
		//향상된 포문으로
		System.out.println();
		for(String str : set)
			System.out.println(str);
	}

}
