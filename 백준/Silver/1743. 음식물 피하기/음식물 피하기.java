import java.util.Scanner;

public class Main {
	static int N, M, K, area;
	static int[][] graph;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 행의 크기
		M = sc.nextInt(); // 열의 크기
		K = sc.nextInt(); // 쓰레기 개수

		graph = new int[N][M];

		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			graph[r - 1][c - 1] = 1; // 쓰레기가 있는 부분은 1로
		}

		int trash = 0; // 쓰레기 개수
		int size = 0; // 쓰레기 크기

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				area = 0; // 쓰레기 크기 초기화

				// 쓰래기가 있는 위치면 dfs 들어가기
				if (graph[i][j] == 1) {
					trash++;
					dfs(i, j);
					if (area > size) {
						size = area; // 더 큰 쓰레기 사이즈로 갱신
					}
				}
			}
		}

		System.out.println(size);

	}// main

	static void dfs(int row, int col) {
		area++; // 쓰레기 크기 하나 증가
		graph[row][col] = 999; // 방문표시

		for (int d = 0; d < 4; d++) {
			int nextR = row + dr[d];
			int nextC = col + dc[d];

			// 범위 내에 있고 쓰래기가 있는 자리이면 이동해
			if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && graph[nextR][nextC] == 1) {
				dfs(nextR, nextC);
			}
		}

	}

}