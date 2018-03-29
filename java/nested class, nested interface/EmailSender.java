package ch16;

class EmailSender extends MessageSender {
	String sender;
	String receiver;
	EmailSender(String sender, String receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}
	void send(String message) {
		System.out.println("From" + sender);
		System.out.println("To" + receiver);
		System.out.println("³»¿ë: " + message);
		System.out.println();
	}

}
