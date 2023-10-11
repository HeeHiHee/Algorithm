import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map, seaCnt;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int iceCnt, year; // 빙산 덩어리 개수, 몇 년

	static void print(int[][] graph) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%3d", graph[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}// print

	static class point {
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		seaCnt = new int[N][M]; // 빙산과 인접한 바다가 몇 개인지 세기 위한 배열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		iceCnt = 1; // 처음 빙산 덩어리는 1개로 주어짐
		year = 0;

		// 빙산 덩어리가 한 개일동안만 반복
		while (iceCnt < 2) {
			iceCnt = 0;
			year++;

			// 1. 해당 빙산에 인접한 바다의 수가 몇 개인지 저장하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 해당 칸이 빙산이 있는 칸이면
					if (map[i][j] != 0) {
						int cnt = 0; // 인접한 바다 수를 세기 위한 변수

						for (int d = 0; d < 4; d++) {
							int nextR = i + dr[d];
							int nextC = j + dc[d];

							if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] == 0) {
								cnt++;
							}

						} // d

						seaCnt[i][j] = cnt; // 인접한 바다 수 저장

					} // if
				} // j
			} // i

			// 2. 1년 후 빙산의 높이 구하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] - seaCnt[i][j] >= 0) {
						map[i][j] -= seaCnt[i][j];
					} else {
						map[i][j] = 0;
					}
				}
			}

			visited = new boolean[N][M]; // 방문 배열 초기화

			// 3. 빙산이 몇 덩어리인지 구하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 해당 위치에 빙산이 있다면 bfs 돌리기
					if (map[i][j] != 0 && !visited[i][j]) {
						Queue<Point> q = new LinkedList<>();
						q.offer(new Point(i, j));
						visited[i][j] = true;
						iceCnt++;

						while (!q.isEmpty()) {
							Point take = q.poll();

							for (int d = 0; d < 4; d++) {
								int nextR = take.x + dr[d];
								int nextC = take.y + dc[d];

								if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && !visited[nextR][nextC]
										&& map[nextR][nextC] != 0) {
									q.offer(new Point(nextR, nextC));
									visited[nextR][nextC] = true;
								}
							}

						} // while
					}

				} // j
			} // i
			
			if(iceCnt==0) {
				year = 0;
				break;				
			}
			

		} // while

		System.out.println(year);

	}// main

}