import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 색종이 개수 4

		int[][] map = new int[102][102];

		// 색종이 붙이기
		for (int n = 0; n < N; n++) {

			int s = sc.nextInt(); // 3
			int e = sc.nextInt(); // 7

			// 색종이 영역 1로 칠하기
			for (int r = s; r < s + 10; r++) {
				for (int c = e; c < e + 10; c++) {
					map[r][c] = 1;
				}
			}

		} // 색종이 개수

		// 상 우 하 좌 탐색
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int round = 0; // 둘레를 구하기 위한 변수

		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				// 현재 위치의 값이 1일 때 (색종이가 붙여져 있을 때)
				if (map[i][j] == 1) {
					// 상 우 하 좌 순으로 탐색하기 위한 반복문
					for (int k = 0; k < 4; k++) {
						// 4방향 탐색하는데 범위가 0보다 크거나 같고 100보다는 작은 범위에서 그리고 4방향 돌면서 값이 0인 부분만 카운트
						if (map[i + dr[k]][j + dc[k]] == 0) {
							round++;
						}
					}

				}

			} // j
		} // i

		System.out.println(round);

	}// main

}
