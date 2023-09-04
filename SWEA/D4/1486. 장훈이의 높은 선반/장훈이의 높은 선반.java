import java.util.Scanner;

public class Solution {
	static int N, B, ans;
	static int[] H;
	static boolean[] sel; // 해당 점원의 탑 사용 유무 
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); // 점원의 수 
			B = sc.nextInt(); // 탑의 높이 
			H = new int[N]; // 점원의 배열
			sel = new boolean[N]; // 해당 탑 사용 여부 
			
			for(int i=0; i<N; i++) {
				H[i] = sc.nextInt();
			}// 점원 입력 끝 
			
			ans = 987654321;
			powerset(0);
			System.out.printf("#%d %d\n", tc, ans-B);
		}// tc
		
		
	}// main
	
	
	public static void powerset(int idx) {
		// 기저부분
		if (idx == N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(sel[i]) {
					sum += H[i];
				}
			}
			
			// 선반 높이보다 높으면 더 작은 값으로 갱신 
			if(sum >= B)
				ans = Math.min(ans, sum);
			return;
		}
		
		
		// 재귀부분
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
		
		
		
	}// powerset
}