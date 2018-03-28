import java.util.HashMap;

public class HashMapEx01 {

	public static void main(String[] args) {
	//해쉬 테이블로 사용할 해쉬맵 객체 생성
		HashMap<String, Integer> hashtable = new HashMap<String, Integer>();
		hashtable.put("해리", new Integer(95));
		hashtable.put("헤르미온느", new Integer(100));
		hashtable.put("론", new Integer(85));
		hashtable.put("말포이", new Integer(93));
		hashtable.put("네빌", new Integer(70));
	//키 값으로 해쉬 테이블의 데이터 찾아 출력
		Integer num = hashtable.get("헤르미온느");
		System.out.println("헤르미온느의 성적은? " + num);

	}

}
