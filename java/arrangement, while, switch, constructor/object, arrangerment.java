
public class chapter05 {

	public static void main(String[] args) {
//1. 객체 생성 관련 예제
		String str1 = "java";
		String str2 = "java";
		//객체 하나를 두 레퍼런스의 주소를 가리켜서 같다표시
		if (str1 == str2 ) {
			System.out.println("1.같다");
		} else {
			System.out.println("1.다르다");
			
		}
		//객체는 별도로 만들어진다
		String str3 = new String("java");
		String str4 = new String("java");
		
		if (str3 == str4 ) {
			System.out.println("2.같다");
		} else {
			System.out.println("2.다르다");
			
		}
		//객체의 문자열 비교
		if (str1.equals(str2)) {
		System.out.println("1.같다");
	} else {
		System.out.println("1.다르다");
		
	}
		if (str3.equals(str4)) {
			System.out.println("2.같다");
		} else {
			System.out.println("2.다르다");
			
		}		
//2 배열 타입 
//		int a[] = new int[5];
//		a[0] = 10; ~~~
//		==> int a[] = {10, ~~};
//2-1 배열 길이
//	int arr[] = {10, 20, 30, 40, 50};
//	int i, sum = 0;
//	for (i = 0; i < arr.length; i++) {
//		
//		sum += arr[i];
//	
//	}
//	System.out.println("sum = " + sum);	

//2-2 1차원배열
		int arr[] = new int[5];
		int i, sum = 0;
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		for (i = 0; i < arr.length; i++) {
			
			sum += arr[i];
		
		}
		System.out.println("sum = " + sum);	
//2-3 1차원배열
	//int arr[] = null;
	//arr = new int[5];
	}

}
