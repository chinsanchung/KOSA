
public class Inherit02 extends Inherit01 {
//기능들
	//필드
	int channel;
	
	//생성자
	Inherit02(String model, String color, int channel) {
		//super(); 자동생성
		//super(model, color); 명시적으로 넣으면 super()는 사라짐
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	//메소드
	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송 수신을 시작합니다.");
	}
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + "번으로 바꿉니다.");
	}
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
}
