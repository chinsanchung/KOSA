
abstract public class MessageSender01 {
	//필드
	String title;
	String senderName;
	MessageSender01(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}
	//추상메소드(파라미터로 문자 recipient)
	abstract void sendMessage(String recipient);
}
