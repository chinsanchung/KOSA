
public class Ch11GradeEquals {

	public static void main(String[] args) {
	
		Ch11Grade obj1 = new Ch11Grade("A001", "jim", 70, 80, 90);
		Ch11Grade obj2 = new Ch11Grade("A001", "jim", 70, 80, 90);
		//내용이 아니라 주소를 비교해서 다르다 출력
		if(obj1.equals(obj2)) {
			System.out.println("same");
		} else {
			System.out.println("different");
		}
		//
		System.out.println(obj1.toString());
	}
	
}
