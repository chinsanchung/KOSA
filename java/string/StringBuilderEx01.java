
public class StringBuilderEx01 {

	public static void main(String[] args) {
	StringBuilder sb = new StringBuilder("역사를 하노라고 맨땅을 파다가 ");
	System.out.println(sb);
	//append(~): 문자열 뒤에 ~을 덧붙임
	System.out.println(sb.append("커다란 고인돌을 끄집어 내어놓고 보니"));
	//insert(A, B): 문자열 A위치에 B 삽입
	System.out.println(sb.insert(26,  "하나 "));
	//delete(A, B): A부터 B-1자리까지의 문자열 삭제
	System.out.println(sb.delete(21, 23));
	//deleteChartAt(a): a위치에 있는 하나의 문자 삭제
	System.out.println(sb.deleteCharAt(9));
	}

}
