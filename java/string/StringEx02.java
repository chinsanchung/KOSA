
public class StringEx02 {

	public static void main(String[] args) {
	String str1 = "java";
	String str2 = "java";
	//str1 주소와 str2 주소 비교
	if (str1 == str2) 
		System.out.println("same");
		else 
			System.out.println("different");
	//equals 문자열 비교
	if (str1.equals(str2))
		System.out.println("same");
	else
		System.out.println("different");	
	
	}

}
