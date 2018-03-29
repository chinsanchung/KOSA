package ch16;

public class NestedClassEx06 {

	public static void main(String[] args) {
	//정적 네스티드 클래스의 객체 생성
		Line.Point point = new Line.Point(100, 200);
		System.out.printf("(%d, %d)", point.x, point.y);

	}

}
