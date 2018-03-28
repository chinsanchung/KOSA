
public class Ch06Static02 {
	//객체를 쓰던 말던 MAX를 사용가능
	static int MAX = 100;
	public static void main(String[] args) {
	//1 객체주소 저장할 배열 생성
	Ch06Static01 obj[] = new Ch06Static01[MAX];
	int i = 0;
	
	//2 객체
	for (i = 0; i < MAX; i++) {
		//상품 객체 Sangpum01() 만듬.객체주소를 obj[i]에 넣음
		obj[i] = new Ch06Static01();
		//앞의 return true된 것을 의미. if (return true)면 break란 뜻이래
		if (obj[i].input()) {
			break;
		}
		obj[i].process();
		
		System.out.println();
	}
	System.out.println("\n\t       *** 판매현황 ***");
	System.out.println("====================================================");
	System.out.println("제품코드     제품명      수량          단가               금액");
	System.out.println("====================================================");
	for (i = 0; i < Ch06Static01.cnt; i++) {
	obj[i].output(); 
	}
	System.out.println("====================================================");
	System.out.println("\t\t\t\t 총 판매금액: " + Ch06Static01.getTotal());
	}
	

}
