
class EMailSender02 extends MessageSender01{
	String senderAddr;
	String emailBody;
	EMailSender02(String title, String senderName, String senderAddr, String emailBody) {
		super(title, senderName);
		this.senderAddr = senderAddr;
		this.emailBody = emailBody;
	}
	//01의 추상메소드 sendMessage를 재정의해서 상속받음
	void sendMessage(String recipient) {
		System.out.println("------------------------");
		System.out.println("제목: " + title);
		System.out.println("보내는 사람: " + senderName + " " + senderAddr);
		System.out.println("받는 사람: " + recipient);
		System.out.println("내용: " + emailBody);
	}
}
