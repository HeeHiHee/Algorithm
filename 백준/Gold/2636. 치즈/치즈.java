import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, time, cheese;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> q;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Integer> list; // 시간당 남아있는 치즈조각 개수

	static class Point {
		int x, y;

		public Point(int x, int y) {
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
		cheese = 0; // 치즈의 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheese++;
			}
		} // 입력 끝

		list = new ArrayList<>();
		time = 0; // 걸리는 시간을 저장할 변수
		list.add(cheese);
		while (cheese > 0) {
			// (0,0)은 무조건 공기이므로 공기인 영역을 99로 채우기
			visited = new boolean[N][M];
			air();

			// 공기(99)랑 접촉된 자리이면 큐에 넣기
			q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						for (int d = 0; d < 4; d++) {
							int nextR = i + dr[d];
							int nextC = j + dc[d];
							if (map[nextR][nextC] == 99) {
								q.offer(new Point(i, j));
								break;
							}
						}
					}
				}
			}

			// 큐에 있는 좌표들은 공기랑 접촉된 자리이므로 공기(99)로 바꿔주기
//			System.out.println(q.size());
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point take = q.poll();
				map[take.x][take.y] = 99;
				cheese--;
			}
			time++;

			// 해당 시간 리스트에 남은 치즈의 수 넣어주기
			list.add(cheese);
		}

		System.out.println(time);

		System.out.println(list.get(list.size() - 2));

	}// main

	static void air() {
		q = new LinkedList<>();
		q.offer(new Point(0, 0));
		map[0][0] = 99;
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Point take = q.poll();

			for (int d = 0; d < 4; d++) {
				int nextR = take.x + dr[d];
				int nextC = take.y + dc[d];

				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M
						&& (map[nextR][nextC] == 0 || map[nextR][nextC] == 99) && !visited[nextR][nextC]) {
					q.offer(new Point(nextR, nextC));
					map[nextR][nextC] = 99;
					visited[nextR][nextC] = true;
				}
			}
		}

	}// air

}