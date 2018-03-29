package ch16;

public class NestedClassEx09 {

	public static void main(String[] args) {
	//이름 없는 이너 클래스
		MessageSender obj = new MessageSender() {
			void send(String message) {
				System.out.println("From : Midas");
				System.out.println("To: Bill Gates");
				System.out.println("Message: " + message);
				System.out.println();
			}
		}; //이름 없는 이너클래스는 꼭 마지막에 세미콜론
		obj.send("Good morning");
	}

}
