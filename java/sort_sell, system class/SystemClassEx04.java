
public class SystemClassEx04 {

	public static void main(String[] args) {
		int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	//arr[0]~arr[4]의 값을 arr[3]~arr[7]에 복사한다
		System.arraycopy(arr, 0, arr, 3, 5);
		for (int num:arr)
			System.out.println(num);

	}

}
