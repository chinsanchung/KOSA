package ch16;

public class SMSSender extends MessageSender {

	String phoneNo;
	String responsePhoneNo;
	SMSSender(String phoneNo, String responsePhoneNo) {
		this.phoneNo = phoneNo;
		this.responsePhoneNo = responsePhoneNo;
	}
	@Override
	void send(String message) {
		System.out.println("phoneNo: " + phoneNo);
		System.out.println("³»¿ë: " + message);
		System.out.println("responsephoneNo: " + responsePhoneNo);

	}

}
