package ch16;

public class NestedClassEx01 {

	public static void main(String[] args) {
	Cart cart = new Cart();
	cart.addItem("초콜릿", 3, 1000);
	cart.addItem("케이크", 1, 25000);
	cart.addItem("샴페인", 1, 7000);
	printCart(cart);
	}//main
	static void printCart(Cart cart) {
		int num = cart.getItemNum();
		System.out.println("      상품명   수량   단가    금액");
		System.out.println("----------------------------------");
		for (int cnt = 0; cnt < num; cnt++) {
		//인클로징 클래스.이너클래스 객체이름..장바구니 상품 항목을 	
			Cart.Item item = cart.getItem(cnt);
			System.out.printf("%3d %5s %5d %7d %7d %n", cnt+1, 
	                   item.name, item.num, item.unitPrice, item.getPrice());
		}//for
		System.out.println("----------------------------------");
		System.out.printf("      총계              %10d %n", cart.getTotalPrice());
	}//printCart
}//end
