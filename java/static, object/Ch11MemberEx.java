
public class Ch11MemberEx {

	public static void main(String[] args) {
		Ch11Member obj1 = new Ch11Member("blue");
		Ch11Member obj2 = new Ch11Member("blue");
		Ch11Member obj3 = new Ch11Member("red");
		
		if(obj1.equals(obj2)) {
			System.out.println("obj1 = obj2");
		} else {
			System.out.println("obj1 != obj2");
		}
		
	if(obj1.equals(obj3)) {
		System.out.println("obj1 = obj3");
	} else {
		System.out.println("obj1 != obj3");
		
	}
	
	}

}
