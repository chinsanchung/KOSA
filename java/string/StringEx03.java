
public class StringEx03 {

	public static void main(String[] args) {
		String str1 = new String("java");
		String str2 = new String("java");
		if (str1 == str2)
			System.out.println("same");
		else
			System.out.println("different");
	//문자열 비교	
		if (str1.equals(str2))
			System.out.println("same");
		else
			System.out.println("different");
	}

}
