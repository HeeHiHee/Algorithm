import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 사람의 수
		int N = sc.nextInt();
		
		// 2차원 배열
		int[][] person = new int[N][2];
		
		// 등수 저장
		int r = 1;
		int[] rank = new int[N];
		
		// 배열 입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				person[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			// 등수 초기화
			r = 1;
			
			// 비교 기준 몸무게, 키 고정
			int x = person[i][0]; // 몸무게
			int y = person[i][1]; // 키
			for(int j=0; j<N; j++) {
				if(x < person[j][0] && y < person[j][1]) {
					r++;
				}
			}
			rank[i] = r;
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(rank[i] + " ");
		}
		
		
		
		
		
		
	}//main
}
