import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited; // 방문 확인
	static int[] dr = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][M]; // 그래프 크기 넣어주기
		visited = new boolean[N][M]; // 방문 크기 넣어주기

		// 입력값 넣어주기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}

		int res = bfs(0, 0);

		System.out.println(res);

	}// main

	public static int bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>(); // Point 타입의 큐 생성
		int cnt = 1;

		// 좌표 값을 큐에 넣기 위해 Point 클래스 사용
		Point point = new Point(row, col);

		q.offer(point); // 큐에 시작점 넣기 (0,0)
		visited[row][col] = true; // 방문했다고 표시
		graph[row][col] = cnt; // 칸을 셀 때 시작위치와 도착위치도 포함이라 1부터 시작

		// 큐가 빌 때까지 반복해야겠당
		while (!q.isEmpty()) {
			Point tmp = q.poll(); // 큐에서 하나 꺼내

			for (int d = 0; d < 4; d++) {
				int nextR = tmp.getX() + dr[d];
				int nextC = tmp.getY() + dc[d];

				// nextR과 nextC가 배열의 범위를 벗어나지 않고, 해당 자리의 값이 1이고, 방문한 자리가 아닐때
				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && graph[nextR][nextC] == 1
						&& visited[nextR][nextC] == false) {
					Point nextPoint = new Point(nextR, nextC); // 포인트에 다음 좌표값 넣어주기
					q.offer(nextPoint); // 큐에 좌표값 넣기

					visited[nextR][nextC] = true; // 방문했다고 표시
					graph[nextR][nextC] = graph[tmp.getX()][tmp.getY()] + 1; // 이전 칸의 값+1
				}
			}

		} // while

		return graph[N - 1][M - 1];

	}// bfs

}// Main

// 포인트 클래스 만들어주기 -> 배열의 좌표를 넣기 위한 클래스
// 중요한 점 : 앞에 public을 붙이면 안됨!!!!
class Point {
	private int x, y;

	public Point() {
	}

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