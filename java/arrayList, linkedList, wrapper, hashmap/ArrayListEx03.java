import java.util.ArrayList;

public class Ch13ArrayListEx03 {

	public static void main(String[] args) {
	ArrayList<String> list = new ArrayList<String>();
	list.add("A");
	list.add("B");
	list.add("C");
	list.add("D");
	list.add("B");
	//데이터 처음서부터 검색
	int index1 = list.indexOf("B");
	//데이터 마지막에서부터 검색
	int index2 = list.lastIndexOf("B");
	
	System.out.println("Frist B: " + index1);
	System.out.println("Last B: " + index2);
	}

}
