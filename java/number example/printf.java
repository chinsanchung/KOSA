
public class printf {

	public static void main(String[] args) {
		System.out.printf("%s\n", "MBC");
		System.out.printf("%10s\n", "MBC");
		System.out.printf("%6.2f\n", 123.456);  //6자리 + 소수점 둘째자리까지 하기(000.00으로 6자리)
		//그런데 둘째자리 이상의 수니까..소수셋째자리는 잘리는데 반올림해서 처리한다..
		System.out.printf("%10.2f\n", 123.4567); //0000123.46(반올림)
		System.out.printf("%.2f\n", 123.4567); //정수공간이 없다..정수의 모자란 공간은 자르지 않고
		//알아서 해준다
		System.out.printf("%c\n", 'A');
		System.out.printf("%5c\n", 'A');  //만약 %-5c\n으로 할시 -로인해 기준이 왼쪽에서 오른쪽으로 바뀐다
	}

}
