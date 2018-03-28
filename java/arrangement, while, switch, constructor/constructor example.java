
public class Ch06Car {
	//필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	//생성자01
	Ch06Car() {
	}
	//생성자02
	Ch06Car(String model) {
		this.model = model;
	}
	//생성자03
	Ch06Car(String model, String color) {
		this.model = model;
		this.color =  color;
	}
	//생성자04
	Ch06Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color =  color;
		this.maxSpeed = maxSpeed;
   }
	//this로 생성자 호출..p213
/*	Ch06Car(String model) {
 *		this(model, "silver", 250);
 *	}
 *	
 *	Ch06Car(String model, String color) {
 *		this(model, color, 250); 
 * 	}
 * 	
 * 	Ch06Car(String model, String color, int maxSpeed) {
 * 		this.model = model;
 * 		this.color = color;
 * 		this.maxSpeed = maxSpeed;
 * 	}
 */
}
