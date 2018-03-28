
public class Inherit01 {
//핸드폰
	//필드
	String model;
	String color;
	
	//생성자 지정해서 만들시 Inherit02의 생성자에 에러 발생. 자식 생성자 만들때 부모 생성자 호출하기에
	//디폴트 생성자를 직접 기입하면 에러 사라짐..디폴트생성자는 무조건 만들어두기
	Inherit01() {
	}
	Inherit01(String model, String color) {
		this.model = model;
		this.color = color;
	}
	//메소드
	void powerOn() {
		System.out.println("전원을 켭니다");
	}
	void powerOff() {
		System.out.println("전원을 끕니다");
	}
	void bell() {
		System.out.println("벨이 울립니다");
	}
	void sendVoice(String message) {
		System.out.println("자기: " + message);
	}
	void receiveVoice(String  message) {
		System.out.println("상대방 : " +  message);
	}
	void hangUp() {
		System.out.println("전화를 끊습니다");
	}
}
