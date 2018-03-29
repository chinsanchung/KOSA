
public class SelectonSort_Int {

	public static void main(String[] args) {

		int a[] = {5, 7, 1, 3};
		
		int i, j, temp;
		//a.length는 4
		for (i = 0; i < a.length-1; i++) {
			for (j = i + 1; j < a.length; j++) {
			//오름차순으로 정리함
			//1. a[i] = 20, a[j] = 10에서 a[i] => temp..temp = 20
			//2. temp=> a[j], a[j] => a[i]...a[i] = 10, a[j] = 20
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			for (int k = 0; k< a.length; k++) 
				System.out.printf("%5d", a[k]);
				
				System.out.println();
		}
	}

}
