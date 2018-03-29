import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SungjukHashMap {
	public static void main(String[] args) {
		HashMap<String, Sungjuk> hashmap = new HashMap<String, Sungjuk>();
		Scanner scan = new Scanner(System.in);
		  
		while(true)
		{
			int menu;
				
			System.out.println("\n*** 메뉴 ***");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 조회");
			System.out.println("3. 성적 수정");
			System.out.println("4. 성적 삭제");
			System.out.println("5. 성적 출력");
			System.out.println("6. 종     료\n");
			
			System.out.print("메뉴 선택(1~6) => ");
			menu = scan.nextInt();
			
			if (menu == 6)
			{
				System.out.println("\n프로그램 종료...");
				break;
			}
			
			switch (menu)
			{
				case 1:
					input_sungjuk(hashmap);
					break;
				case 2:
					search_sungjuk(hashmap);
					break;
				case 3:
					update_sungjuk(hashmap);
					break;
				case 4:
					delete_sungjuk(hashmap);
					break;
				case 5:
					output_sungjuk(hashmap);
					break;
				default:
					System.out.println("\n메뉴를 다시 선택하세요!!!");
					break;
			}
		}
	}		
	static void input_sungjuk(HashMap<String, Sungjuk> hashmap)
	{
		Sungjuk obj = new Sungjuk();
		
		System.out.println();
		
		if (obj.input(hashmap))
		{
			System.out.println("\n이미 입력된 학번입니다!!!");
			return;
		}
		
		obj.process();
		hashmap.put(obj.hakbun, obj);
		
		System.out.println("\n성적 입력 성공!!!");
	}
	
	static void search_sungjuk(HashMap<String, Sungjuk> hashmap)
	{
		Scanner scan = new Scanner(System.in);
		Sungjuk obj;
		
		System.out.print("\n조회할 학번 입력  => ");
		String hakbun = scan.next();
		
		obj = hashmap.get(hakbun);
		if (obj != null)
		{
			System.out.println();
			System.out.println("학번    이름     국어    영어    수학    총점    평균    등급");
			System.out.println("============================================================");
			obj.output();
			System.out.println("============================================================");
		}
		else
			System.out.println("\n존재하지 않는 학번입니다!!!");
	}
	
	static void update_sungjuk(HashMap<String, Sungjuk> hashmap)
	{
		Scanner scan = new Scanner(System.in);
		Sungjuk obj;
		
		System.out.print("\n수정할 학번 입력 => ");
		String hakbun = scan.next();
		
		obj = hashmap.get(hakbun);
		if (obj != null)
		{
			System.out.print("\n국어 입력 => ");
			obj.kor = scan.nextInt();
			System.out.print("영어 입력 => ");
			obj.eng = scan.nextInt();
			System.out.print("수학 입력 => ");
			obj.math = scan.nextInt();
				
			obj.process();
			//hashmap.put(obj.hakbun, obj);	
			System.out.println("\n" + hakbun + " 학번 수정 완료!!!");
			}
		else
			System.out.println("\n존재하지 않는 학번입니다!!!");
	}
	
	static void delete_sungjuk(HashMap<String, Sungjuk> hashmap)
	{
		Scanner scan = new Scanner(System.in);
		Sungjuk obj;
		
		System.out.print("\n삭제할 학번 입력 => ");
		String hakbun = scan.next();
		
		obj = hashmap.get(hakbun);
		if (obj != null)
		{
			hashmap.remove(obj.hakbun);
			System.out.println("\n" + hakbun + " 학번 삭제 완료!!!");
		}
		else
			System.out.println("\n존재하지 않는 학번입니다!!!");
	}
	
	static void output_sungjuk(HashMap<String, Sungjuk> hashmap)
	{
		Sungjuk obj;
		
		Set<String> keyset = hashmap.keySet(); // hashmap에 존재하는 키 집합을 구함
		
		if (keyset.size() == 0)  //if (hashmap.isEmpty())
		{
			System.out.println("\n출력할 데이터가 없습니다!!!");
			return;
		}
		
		System.out.println();
		System.out.println("\n                       *** 성적표 ***");
		System.out.println("============================================================");
		System.out.println("학번    이름     국어    영어    수학    총점    평균    등급");
		System.out.println("============================================================");
		
		for (String hakbun : keyset)
		{
			obj = hashmap.get(hakbun);
			obj.output();
		}
		System.out.println("============================================================");
		
		/*
		Set entryset = hashmap.entrySet(); // hashmap에 존재하는 키와 값의 집합을 구함
		
		if (entryset.size() == 0)
		{
			System.out.println("\n출력할 데이터가 없습니다!!!");
			return;
		}
		
		Iterator it_entry = entryset.iterator(); // 순차적인 접근을 위해 Iterator 객체로 변환
		
		System.out.println();
		System.out.println("\n                       *** 성적표 ***");
		System.out.println("============================================================");
		System.out.println("학번    이름     국어    영어    수학    총점    평균    등급");
		System.out.println("============================================================");
		
		while(it_entry.hasNext())
		{
			// 키와 값을 읽기 위해 Map.Entry로 캐스트 연산
			Map.Entry e = (Map.Entry) it_entry.next();
			// e.getValue():데이터 값을 읽어 옴, e.getKey():키 값을 읽어옴
			obj = (Sungjuk)e.getValue(); // e.getValue()의 리턴 타입이 Object이므로 Sungjuk으로 캐스트 연산
			obj.output();
		}
		System.out.println("============================================================");
		*/
	}
}
