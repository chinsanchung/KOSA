import java.util.Random;

public class Ch09Random {

	public static void main(String[] args) {
		//Random(); ()안에 수(1356L 등) 넣으면 고정값이 뜸
		Random random = new Random();
		//0 <  random < 100
		System.out.println(random.nextInt(100));
		System.out.println(random.nextInt(100));
		System.out.println(random.nextInt(100));
	}

}
