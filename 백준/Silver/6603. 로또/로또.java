import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int R = 6;
	public static int[] nums; // 입력받은 N개의 수
	public static int[] choice = new int[R]; // 내가 선택한 R개의 수 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			N = sc.nextInt();
			
			// N에 0 입력 받으묜 탈출 
			if(N==0) {
				break;
			}
			// 0이 아니면 재귀 실행 
			else {
				nums = new int[N];
				
				for(int i=0; i<N; i++) {
					nums[i] = sc.nextInt();
				}					
				
				combination(0,0);
				
			}
			System.out.println();
			
		}
		
		
		
	}//main
	
	// idx : nums의 인덱스
	// sidx : choice의 인덱스 
	public static void combination(int idx, int sidx) {
		// 기저파트
		// sidx가 6이면 다 뽑은거임 
		if(sidx == R) {
			for(int i=0; i<6; i++) {
				System.out.print(choice[i] + " ");
			}
			System.out.println();
			return;
		}
		// idx는 N-1까지만 돌아야 함 
		if(idx == N) return;
		
		// 재귀파트
		choice[sidx] = nums[idx];
		combination(idx+1, sidx+1);
		combination(idx+1, sidx);
		
		
		
		
	}//combination

}