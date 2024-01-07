import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M, N;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); // 열의 수
		N = sc.nextInt(); // 행의 수

		graph = new int[N][M]; // N*M크기의 배열
		visited = new boolean[N][M];

		int one = 0; // 익은 토마토의 개수
		int zero = 0; // 익지 않은 토마토의 개수
		int maone = 0; // 토마토가 없는 칸의 개수

		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				graph[i][j] = sc.nextInt();

				if (graph[i][j] == 1) {
					one++;
					Point point = new Point(i, j); // 1의 좌표값
					q.offer(point); // 큐에 좌표값 넣기
					visited[i][j] = true; // 익은 토마토 자리는 방문했다고 미리 표시하기

				} else if (graph[i][j] == 0) {
					zero++;
				} else {
					maone++;
				}
			}
		}

		// 모든 토마토가 익지 못하는 상황, 모든 토마토가 익어 있는 상황
		if (maone + zero == N * M) {
			System.out.println(-1); // 모든 토마토가 익지 못하는 상황
		} else if (maone + one == N * M) {
			System.out.println(0); // 모든 토마토가 익어 있는 상황
		} else {

			int day = 0;

			while (!q.isEmpty()) {
				Point tmp = q.poll(); // 큐에서 하나 꺼내기

				for (int d = 0; d < 4; d++) {
					int nextR = tmp.getX() + dr[d];
					int nextC = tmp.getY() + dc[d];

					if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && graph[nextR][nextC] == 0
							&& visited[nextR][nextC] == false) {
						Point nextPoint = new Point(nextR, nextC); // 포인트에 다음 좌표 넣기
						q.offer(nextPoint); // 큐에 좌표 넣어주기
						visited[nextR][nextC] = true; // 방문했다고 표시
						graph[nextR][nextC] = graph[tmp.getX()][tmp.getY()] + 1;
						day = graph[nextR][nextC];
					}
				}

			} // while

			boolean zerois = false;
			// 탐색이 끝나고 익지 않은 토마토가 있는지 확인
			Out: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (graph[i][j] == 0) {
						zerois = true;
						break Out;
					}
				}
			}

			if (zerois) {
				System.out.println(-1);
			} else {
				System.out.println(day - 1);

			}

		}

	}// main

}

// 2차원 배열의 좌표를 담아주기 위한 클래스

class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}// Point