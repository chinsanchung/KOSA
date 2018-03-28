
public interface Ch08RemoteControl01 {
	//상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//추상 메소드
	void turnON();
	void turnOff();
	void setVolume(int volume);
	
	//디폴트 메소드
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("Mute");
		} else {
			System.out.println("Cancel Mute");
		}
	}
	
	//정적 메소드
	static void changeBattery() {
		System.out.println("Changing battery");
	}
}
