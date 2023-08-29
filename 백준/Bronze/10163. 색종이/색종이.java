import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 색종이 개수
		
		// 1001*1001 격자 생성 
		int[][] map = new int[1001][1001];
		
		// 1번 색종이는 1, 2번 색종이는 2로 칠하기 
		for(int i=1; i<=N; i++) {
			int sR = sc.nextInt();
			int sC = sc.nextInt();
			int eR = sc.nextInt();
			int eC = sc.nextInt();
			
			for(int r=sR; r<sR+eR; r++) {
				for(int c=sC; c<sC+eC; c++) {
					map[r][c] = i;
				}
			}
			
		}
		
		
		int[] cnt = new int[N+1];
		
		
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				// 해당 격자에 적힌 수를 인덱스로 받아 cnt배열 증가시킴 
				cnt[map[i][j]]++;			
			}//j
		}//i
		
		
		for(int i=1; i<cnt.length; i++) {
			System.out.println(cnt[i]);
		}
	
	}//main

}
