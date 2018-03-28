import java.util.ArrayList;

public class Ch12ArrayList01 {

	public static void main(String[] args) {
	//ArrayList 객체 생성
	ArrayList<String> list = new ArrayList<String>();
	//데이터 추가하기
	list.add("A");
	list.add("B");
	list.add("C");
	//데이터의 수 출력
	int num = list.size();
	//리스트의 데이터 수만큼 루프 돌며 데이터를 읽어와 출력함
	for (int cnt = 0; cnt < num; cnt++) {
		String str = list.get(cnt);
		System.out.println(str);
	}
	//향상된 for문으로 출력하기
	System.out.println();
	for (String str : list)
		System.out.println(str);
	}

}
