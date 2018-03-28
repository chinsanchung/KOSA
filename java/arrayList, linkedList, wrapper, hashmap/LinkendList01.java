import java.util.LinkedList;

public class LinkendList01 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("grape");
		list.add("strawberry)");
		list.add("peach");
		list.add(0, "kiwi");
		list.remove(1);
		list.remove("Å°À§");
		int num = list.size();
		for (int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}
	}

}
