
public class SelectionSort_String {

	public static void main(String[] args) {

		String a[] = {"M", "T", "K", "S"};
		String temp;
		int i, j;
		//a.length는 4
		for (i = 0; i < a.length-1; i++) {
			for (j = i + 1; j < a.length; j++) {
			//a[i]가 크면 양수(둘을 교환한다) + 0보다 크면 아래 실행..a[j]가 크면 음수
			//객체의 주소를 바꾸는것
				if (a[i].compareTo(a[j]) > 0) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			for (int k = 0; k< a.length; k++) 
				System.out.printf("%6s", a[k]);
				
				System.out.println();
		}

	}

}
