
public class Ch11ObjectEx {

	public static void main(String[] args) {
		Ch11ObjectStock obj = new Ch11ObjectStock("57293", 100);
		//둘의 결과는 동일
		String str = obj.toString();
		//String str = "재고정보 = " + obj;
		
		//str객체 출력..str.toString()이 나옴
		System.out.println(str);

	}

}
