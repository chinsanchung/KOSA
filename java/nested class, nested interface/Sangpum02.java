import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Sangpum02 {
	
	public static void main(String[] args) {
		LinkedList<Sangpum> list = new LinkedList<Sangpum>();
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));

		while(true) {
		
			int menu = 0;
			try {
			System.out.println("\n*** 메뉴 ***");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 성적 조회");
			System.out.println("4. 성적 수정");
			System.out.println("5. 성적 삭제");
			System.out.println("6. 종     료\n");
			
			System.out.print("메뉴 선택(1~6) => ");
			menu = Integer.parseInt(in.readLine());
			
			
				if (menu == 6) {
			
					System.out.println("\n프로그램 종료...");
					break;
				}//if
			
			switch (menu) {
			
				case 1:
					input_sangpum(list);
					break;
				case 2:
					output_sangpum(list);
					break;
				case 3:
					search_sangpum(list);
					break;
				case 4:
					update_sangpum(list);
					break;
				case 5:
					delete_sangpum(list);
					break;
				default:
					System.out.println("\n메뉴를 다시 선택하세요");
					break;
			}//switch
			
			} //try
			catch (IOException e){
				}
			
		}//while
	}//main
	
	static void input_sangpum(LinkedList<Sangpum> list) {
	
		Sangpum obj = new Sangpum();
		
		System.out.println();
		
		if (obj.input(list)) {
		
			System.out.println("\n이미 입력된 상품입니다");
			return;
		}
		
		obj.process();
		list.add(obj);
		
		System.out.println("\n상품 입력 성공");
	}//input
	
	static void output_sangpum(LinkedList<Sangpum> list) {
	
		if (list.size() == 0) {
		
			System.out.println("\n출력할 데이터가 없습니다");
			return;
		}
		
		sort_sel(list);
		
		System.out.println();
		System.out.println("\n\t        *** 상품 ***");
		System.out.println("===================================");
		System.out.println("상품코드    상품명     수량    단가      금액");
		System.out.println("===================================");
		System.out.println();
		for (Sangpum obj : list) {
		
			obj.output();
		}
		System.out.println();
	}//output
	
	static void search_sangpum(LinkedList<Sangpum> list) {
	
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("\n조회할 상품 입력  => ");
			String code = in.readLine();
	
			for (Sangpum obj : list) {
			
				if (code.equals(obj.code)) {
					System.out.println();
					System.out.println("상품코드    상품명     수량    단가      금액 ");
					System.out.println("======================================");
					obj.output();
					System.out.println();
					
					return;
				}//if
			  }//for
		}//try 
		catch (IOException e) {
			System.out.println("\n존재하지 않는 상품입니다");
		}//catch
	}//search
	
	static void update_sangpum(LinkedList<Sangpum> list)
	{
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.print("\n수정할 상품 입력 => ");
		String code = in.readLine();
		
		for (Sangpum obj : list) {
		
			if (code.equals(obj.code)) {
			
				System.out.print("\n수량 입력 => ");
				obj.su = Integer.parseInt(in.readLine());
				System.out.print("단가 입력 => ");
				obj.dan = Integer.parseInt(in.readLine());
				
				obj.process();
			} //if	
				System.out.println("\n" + code + " 상품 수정 완료");
				return;
			} //for
		}//try
		catch (IOException e) {
		System.out.println("\n존재하지 않는 상품입니다");
		}//catch	
	}//update
	static void delete_sangpum(LinkedList<Sangpum> list) {
		
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.print("\n삭제할 상품코드 입력 => ");
		String code = in.readLine(); //입력받은 상품코드
		//하나하나 꺼냈던 객체를 obj에다 저장하게 된다..이것들을 꺼내서 비교하게된다.(리스트)상품객체 안에 있는 코드와 비교
		for (Sangpum obj : list) {
		//equals는 모든 객체에서 사용가능한 것이다 스트링변수.equals
		//상품과 괄호 안에 있는거와 비교하는건데 상품의 데이터 타입이 상품인데 비교대상의 타입이 string이라 안됨
		//상품의 코와 입력받은 것의 코드와 비교를 해야함
		//160줄에서 입력받은 코드와 이미 저장되어 있던 코드와 비교해야함..obj.code쓰면 상품코드로 뜸
			if (code.equals(obj.code)) {
			
				list.remove(obj);
				System.out.println("\n" + code + " 상품 삭제 완료");
				return;
			}//if
		 }//for
		}//try
		catch (IOException e) {
		//여기엔 예외가 발생한 것만 넣어야 한다
			
	
		}//catch
		System.out.println("\n존재하지 않는 상품입니다"); 
	}
	static void sort_sel(LinkedList<Sangpum> list)
	{
		int i, j;
		Sangpum temp;
		
		for (i=0; i<list.size()-1; i++)
		{
			for (j=i+1; j<list.size(); j++)
			{
				if (list.get(i).irum.compareTo(list.get(j).irum) > 0 )
				{
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}//if
			}//for
		}//for
	}//sort

}//end
