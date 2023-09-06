import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] arr; // 입력으로 받은 수 배열 
	static int[] nums;
	static boolean[] visit;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[M]; // 출력할 배열, 크기는 M
		visit = new boolean[N+1]; // 자연수 사용 여부를 체크할 배열
		
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);		
		
		
		sequance(0);
		
		System.out.println(sb);
		
		
	}//main
	
	public static void sequance(int idx) {
		// 기저파트
		if(idx==M) {
			for(int i=0; i<M; i++) {
				sb.append(nums[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		boolean[] used = new boolean[arr[arr.length-1]+1]; // 입력받은 값 중 최대값의 크기+1만큼 배열을 생성
		
		// 재귀파트
		// i : 자연수 사용여부 배열을 돎
		// idx : 출력할 배열의 index
		for(int i=1; i <= N; i++) {
			if(!visit[i]) {
				nums[idx] = arr[i]; // idx번째 배열에 i를 저장 
				
				if(!used[arr[i]]) {
					used[arr[i]] = true; // 중복되는 수를 또 넣지 않기 위해 사용한 수는 true로 바꾸기 
					
					visit[i] = true; // 방문했음을 표시 
					sequance(idx+1); // 다음 배열로 넘어감
					
					visit[i] = false; // 방문하고 돌아오면 다시 초기화
				}
				
			}
		}
		
		
		
	}// sequance
	
	
}