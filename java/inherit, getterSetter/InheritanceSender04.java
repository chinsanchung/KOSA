
class InheritanceSender04 {
	public static void main(String args[]) {
		EMailSender02 obj1 = new EMailSender02("생일을 축하합니다", "고객센터",
				"admin@dukeeshop.co.kr", "10% 할인 쿠폰이 발행되었습니다");
		SMSSender03 obj2 = new SMSSender03("생일을 축하합니다", "고객센터",
				"02-000-0000", "10% 할인 쿠폰이 발행되었습니다");
		//(정적)메인메소드에서 
		send(obj1, "hatman@yeyeye.com");
		send(obj1, "stickman@hhaha.com");
		send(obj2, "010-000-0000");

	}
	//메인이 정적메소드이니 send도 정적으로 해야함
	//sendMessage를 오버라이딩했으니 주소 100인 obj는 
	static void send(MessageSender01 obj, String recipient) {
		//호출 방식은 obj나 obj1, obj2나 같지만 내용은 달라(메소드다형성)이게 되는 이유는 02와 03은 자식타입
		//
		obj.sendMessage(recipient);
	}
}
