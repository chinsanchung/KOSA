
class Ch12WrapperEx01 {

	public static void main(String[] args) {
		//Integer 객체 생성..12로 하나 "12" + "7", "12" + 7로 해도 값 나옴
		Integer obj1 = new Integer("12");
		Integer obj2 = new Integer("7");
		//12 + 7이 하고 싶지만 객체들로 +는 불가능. 그래서 intValue로
		//객체 안의 int값을 가져옴
		int sum = obj1.intValue() + obj2.intValue();
		System.out.println(sum);
	}

}
