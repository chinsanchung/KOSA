
public class StringEx05 {

	public static void main(String[] args) {
		String str1 = "   Let it be.   ";
		//trim: 문자열 앞 뒤 공백 제거
		String str2 = str1.trim();
		System.out.println(str2);
		//concat: 문자열 뒤에 str 연결
		System.out.println(str2.concat(" Speaking words of wisdom."));
		//toUpperCase:문자열 모든 소문자를 대문자로 바꿈
		System.out.println(str2.toUpperCase());
		//toLowerCase(): 문자열 모든 대문자를 소문자로 바꿈
		System.out.println(str2.toLowerCase());
		//replace(a, b): 문자열에 포함된 모든 a를 b로 바꿈 
		System.out.println(str2.replace('e', 'a'));
		System.out.println(str1);
		System.out.println(str2);
	}

}
