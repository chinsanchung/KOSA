
public class Inherit03 {
	public static void main(String[] args) {
		
		//Inherit02로부터 객체 생성
		Inherit02 inherit02 = new Inherit02("자바폰", "검정", 10);
		
		//Inherit01로부터 상속받은 필드
		System.out.println("모델 " + inherit02.model);
		System.out.println("색상 " + inherit02.color);
		
		//Inherit02의 필드
		System.out.println("채널 " + inherit02.channel);
		
		//Inherit01로부터 상속받은 메소드 호출
		inherit02.powerOn();
		inherit02.bell();
		inherit02.sendVoice("여보세요");
		inherit02.receiveVoice("안녕하세요. 난 길동이다");
		inherit02.sendVoice("아 반가워");
		inherit02.hangUp();
		
		//Inherit02의 메소드 호출
		inherit02.turnOnDmb();
		inherit02.changeChannelDmb(12);
		inherit02.turnOffDmb();
		
		
		
		
		
	}
}
