
public class SystemClassEx05 {

	public static void main(String[] args) {
	 //현재 시각 측정
		long time1 = System.currentTimeMillis();
		double total = 0.0;
		
	//원주율 파이의 근사값을 계산하는 부분
		for (int cnt = 1; cnt < 1000000000; cnt += 2) {
			if (cnt / 2 % 2 == 0)
				total += 1.0 / cnt;
			else
				total -= 1.0 / cnt;
		
		}
	//현재 시각 측정
		double pi = total * 4;
		long time2 = System.currentTimeMillis();
		System.out.println("result = " + pi);
		System.out.printf("계산에 %d ms가 소요되었다", time2 - time1);
		
			
	}

}

