import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int M,N,K;
	static int[][] area;
	
	// 방향 벡터 설정(상, 하, 좌, 우)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 수
		
		for(int tc=0; tc<T; tc++) {
			M = sc.nextInt(); // 열의 크기
			N = sc.nextInt(); // 행의 크기
			K = sc.nextInt(); // 배추 개수
			
			area = new int[N][M]; // N*M 크기의 배열 생성 
			
			// 배추 있는 위치에 1 입력
			for(int i=0; i<K; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				area[r][c] = 1;
			}
			
			
			int cnt = 0; // 필요한 흰지렁이 수
			
			// 배추가 있는 위치이면 탐색하기 
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(area[i][j]==1) {
						cnt++; // 해당 위치에 배추가 있으므로 cnt 하나 증가
						dfs(i,j);
					}
				}
			}
			System.out.println(cnt);
			
		}//tc
		
		
		
		
	}//main
	
	public static void dfs(int row, int col) {
		area[row][col] = 999; // 방문한 자리임을 표시
		
		for(int d=0; d<4; d++) {
			// 상 하 좌 우 순으로 탐색 좌표 
			int nextR = row + dr[d];
			int nextC = col + dc[d];
			
			if(nextR>=0 && nextR<N && nextC>=0 && nextC<M && area[nextR][nextC]==1) {
				dfs(nextR, nextC);
			}
			
		}
		
		
		
	}//dfs
	
	
	

}