
public class HashCodeEx02 {

	public static void main(String[] args) {
	//두 개의 네임 객체 생성
		Name obj1 = new Name("헤르미온느", "그레인져");
		Name obj2 = new Name("헤르미온느", "그레인져");
	//각각의 객체에 대해 해쉬코드 메소드 호출하기
	int hash1 = obj1.hashCode();
	int hash2 = obj2.hashCode();
	//해쉬코드 메소드의 리턴 값 출력하기
	System.out.println(hash1);
	System.out.println(hash2);
	}
	//다른 해쉬코드 나오는 이유는
	//Name클래스가 Object클래스로부터 상속받은 해쉬코드 메소드를 그대로 사용하고 있기 때문
	

}
