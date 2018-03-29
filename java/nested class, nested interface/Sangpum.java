import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Sangpum {
	String code, irum;
	int su, dan, price;
	LinkedList<Sangpum> list = new LinkedList<Sangpum>();
	

	Sangpum(String code, String irum, int su, int dan)
	{
		this.code = code;
		this.irum = irum;
		this.su = su;
		this.dan = dan;
	}
	
	Sangpum() {
	
	}

	boolean input(LinkedList<Sangpum> list) {
		
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));

		try {
	
			while (true) {
		
				System.out.print("코드 입력 => ");
				code = in.readLine();
		//상품객체가 들어가야 indexOf 동작함..반복문을 써서 객체를 하나하나 뽑아서 코드를 비교해야한다
		//		int index = list.indexOf(code);
		//리스트에 데이터 없으면 FOR문이 안돌아감. 데이터 있으면 하나 읽어오고
		//아래 IF문에서 OBJ코드하고 이퀄 비교 같으면 리턴 트루
				for (Sangpum obj : list)  {
		// 키값 code 존재하는지 확인. 없으면 null값 반환
					if (obj.code.equals(code)) {
		
						return true;
					}//if	
				}//for
				System.out.print("이름 입력 => ");
				irum = in.readLine();
				System.out.print("수량 입력 => ");
				su = Integer.parseInt(in.readLine());
				System.out.print("단가 입력 => ");
				dan = Integer.parseInt(in.readLine());
				return false;
		}//while
		} catch (IOException e) {
			System.out.println();
		}//catch
		return false;
	}//input

	void process() {
		price = su * dan;
	}
	
	void output() {	
		System.out.printf("%4s   %3s   %4d       %4d     %5d \n",
			code, irum, su, dan, price);
	}

}//end
