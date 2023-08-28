import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt(); // 롤 케이크의 길이
		
		int[] roll = new int[len]; // 롤케이크 길이만큼의 배열 생성
		
		int N = sc.nextInt(); // 방청객 수
		
		int[][] arr = new int[N][2];
		
		// 방청객 i가 종이에 적어낸 수 p, k를 배열 arr에 입력 
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호 출력
		int max1 = 0;
		int idx = -1;
		for(int i=0; i<N; i++) {
			int k = arr[i][1] - arr[i][0];
			if(k > max1) {
				max1 = k;
				idx = i;
			}
		}
		System.out.println(idx+1);
		
		// 실제로 가장 많은 조각을 받은 방청객의 번호 출력
		// roll 배열에 방청객의 번호 넣기 
		for(int i=0; i<N; i++) {
			for(int j=arr[i][0]; j<=arr[i][1]; j++) {
				// 해당 칸의 값이 0일때 
				if(roll[j-1] == 0) {
					// 방청객의 번호 넣기 
					roll[j-1] = i+1;					
				}
			}
		}
		
		
		int[] cnt = new int[N+1];
		for(int i=0; i<roll.length; i++) {
			cnt[roll[i]]++;
		}
		
		int max2 = 0;
		int idx2 = -1;
		for(int i=1; i<N+1; i++) {
			if(cnt[i] > max2) {
				max2 = cnt[i];
				idx2 = i;
			}
		}
		
		System.out.println(idx2);
		
		
		
		
		
		
		
	}// main

}
