import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int max = 0;

	static int[] dr = { -1, 0, 1, 0 }; // 방향벡터 (상 오 하 좌)
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로크기 = 행
		M = Integer.parseInt(st.nextToken()); // 가로크기 = 열

		graph = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ㅗ모양 빼고 탐색
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true; // 방문했음을 표시
				tetro(i, j, 1, graph[i][j]);
				visited[i][j] = false; // 방문한 자리 다시 초기화
			}
		}
		
		// ㅗ, ㅜ , ㅏ, ㅓ모양 탐색
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int sum = 0;
				
				// ㅜ 모양
				if(j<=M-3 && i<=N-2) {
					sum = graph[i][j] + graph[i][j+1] + graph[i][j+2] + graph[i+1][j+1];
					if(sum > max) {
						max = sum;
					}
				}
				
				// ㅗ 모양
				if(j<=M-3 && i>0) {
					sum = graph[i][j] + graph[i][j+1] + graph[i][j+2] + graph[i-1][j+1];
					if(sum > max) {
						max = sum;
					}
				}
				
				// ㅏ 모양
				if(i<=N-3 && j<=M-2) {
					sum = graph[i][j] + graph[i+1][j] + graph[i+2][j] + graph[i+1][j+1];
					if(sum > max) {
						max = sum;
					}
				}
				
				// ㅓ 모양
				if(i<=N-3 && j>0) {
					sum = graph[i][j] + graph[i+1][j] + graph[i+2][j] + graph[i+1][j-1];
					if(sum > max) {
						max = sum;
					}
				}
				
			}
		}
		
		// ㅏ, ㅓ모양 탐색
		
		System.out.println(max);

	}// main
	
	
	
	

	public static void tetro(int row, int col, int dep, int sum) {
		// 기저부분
		// 깊이는 4번만 들어가
		if (dep == 4) {
			if (sum > max) {
				max = sum;
			}
			return;
		}

		// 재귀 부분
		
		for (int d = 0; d < 4; d++) {
			int nextR = row + dr[d];
			int nextC = col + dc[d];

			if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && visited[nextR][nextC] == false) {
				visited[nextR][nextC] = true; // 방문했음을 표시
				tetro(nextR, nextC, dep+1, sum + graph[nextR][nextC]); // 깊이 하나 증가, sum에 방문할 자리 값 더해주기
				visited[nextR][nextC] = false;
			}
			
		} // d
		
		
		
		
		
		

	}// tetro

}