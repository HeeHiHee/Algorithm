import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 4
		int[] money = new int[N];
		for(int i=0; i<N; i++) {
			money[i] = sc.nextInt();
		}
		
		Arrays.sort(money); // 110 120 140 150
		
		int budget = sc.nextInt(); // 485
		
		int lo = 0;
		int hi = money[N-1];
		int mid = 0;
		
		int sum = 0;
		int res = 0;
		
		for(int i=0; i<N; i++) {
			sum += money[i];
		}
		
		// 요청한 예산들의 총합이 배정예산보다 작으면 요청한 예산들 중 최댓값 출력 
		if(sum <= budget) {
			res = money[N-1];			
			System.out.println(res);
		}else {
			
			while(lo <= hi) {
				mid = (lo + hi) / 2; //상한액
				
				// 정혜진 mid 값으로 계산한 예산 배정 총합
				sum = 0;
							
				for(int i=0; i<N; i++) {
					if(money[i] < mid) {
						sum += money[i];
					}else {
						sum += mid;
					}
				}
				
				// sum이 예산보다 크면 hi를 내린다 
				if(budget < sum) {
					hi = mid-1;
				}
				// sum이 예산보다 작으면 lo를 올린다
				else {
					lo = mid+1;
                    res = Math.max(res, mid);
				}
				
			}
			
			System.out.println(res);
		}
		
		
	}//main

}