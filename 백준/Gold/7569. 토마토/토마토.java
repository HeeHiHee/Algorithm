import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H;
	static int[][][] box;
	static boolean[][][] visited;
	static int[][][] day;
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 열의 수
		N = Integer.parseInt(st.nextToken()); // 행의 수
		H = Integer.parseInt(st.nextToken()); // 높이 수

		box = new int[H][N][M]; // N*M*H
		visited = new boolean[H][N][M];
		day = new int[H][N][M];

		q = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());

					// 지금 자리가 토마토가 있는 자리이면
					if (box[i][j][k] == 1) {
						q.offer(new Point(i, j, k)); // 큐에 넣기
						visited[i][j][k] = true; // 방문 표시
						day[i][j][k] = 0; // 0일 표시
					}

				}
			}
		} // 입력 끝

		bfs();

		int max = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					max = Math.max(max, day[i][j][k]);

					if (box[i][j][k] == 0) {
						System.out.println(-1);
						return;
					} else {
						continue;
					}

				}
			}
		}

		System.out.println(max);

	}// main

	static class Point {
		private int h, r, c;

		public Point() {

		}

		public Point(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}// Point

	static void bfs() {
		// 상, 하, 좌, 우, 위, 아래
		int[] dr = { -1, 1, 0, 0, 0, 0 };
		int[] dc = { 0, 0, -1, 1, 0, 0 };
		int[] dh = { 0, 0, 0, 0, 1, -1 };

		while (!q.isEmpty()) {
			Point take = q.poll(); // 큐에서 하나 꺼내기

			for (int d = 0; d < 6; d++) {
				int nh = take.h + dh[d];
				int nr = take.r + dr[d];
				int nc = take.c + dc[d];

				if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nh][nr][nc] == false
						&& box[nh][nr][nc] == 0) {
					box[nh][nr][nc] = 1; // 익은 토마토로 바꿔주기
					visited[nh][nr][nc] = true; // 방문 표시
					day[nh][nr][nc] = day[take.h][take.r][take.c] + 1; // 방문일수는 전 칸의 + 1일
					q.offer(new Point(nh, nr, nc));

				}
			}

		} // while

	}// bfs

}