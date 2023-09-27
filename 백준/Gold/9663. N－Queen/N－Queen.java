import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int[][] visited;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 체스판의 크기
		map = new int[N][N]; // N*N크기의 체스판
		visited = new int[N][N]; // 방문배열 : 잘 되돌려 놓기위해 int형으로 함
		ans = 0;

		chess(0);

		System.out.println(ans);

	}// main

	// row : 행, col : 열, cnt : 놓은 퀸의 개수
	static void chess(int row) {
		// 기저 조건
		// 놓은 퀸의 개수가 N개가 됐으면 그만!
		if (row == N) {
			ans++; // 경우의 수 하나 증가시키기
			return;
		}

		// 재귀 영역
		for (int col = 0; col < N; col++) {
			if (visited[row][col] == 0) {
				mark(row, col); // 퀸이 갈 수 있는 방향으로 마크 표시
				chess(row + 1); // 다음 행으로 넘어가서 체스 놓기
				markBack(row, col); // 되돌려놓기
			}
		}

	}// chess

	static void mark(int r, int c) {

		for (int i = 0; i < N; i++) {
			visited[r][i]++; // 행 방문표시
			visited[i][c]++; // 열 방문표시

			if (r + i < N && c + i < N) {
				visited[r + i][c + i]++; // 오른쪽 아래 대각선
			}

			if (r - i >= 0 && c + i < N) {
				visited[r - i][c + i]++; // 오른쪽 위 대각선
			}

			if (r + i < N && c - i >= 0) {
				visited[r + i][c - i]++; // 왼쪽 아래 대각선
			}

			if (r - i >= 0 && c - i >= 0) {
				visited[r - i][c - i]++; // 왼쪽 위 대각선
			}

		}

	}// mark

	static void markBack(int r, int c) {

		for (int i = 0; i < N; i++) {
			visited[r][i]--; // 행 방문표시
			visited[i][c]--; // 열 방문표시

			if (r + i < N && c + i < N) {
				visited[r + i][c + i]--; // 오른쪽 아래 대각선
			}

			if (r - i >= 0 && c + i < N) {
				visited[r - i][c + i]--; // 오른쪽 위 대각선
			}

			if (r + i < N && c - i >= 0) {
				visited[r + i][c - i]--; // 왼쪽 아래 대각선
			}

			if (r - i >= 0 && c - i >= 0) {
				visited[r - i][c - i]--; // 왼쪽 위 대각선
			}

		}

	}// markBack

}