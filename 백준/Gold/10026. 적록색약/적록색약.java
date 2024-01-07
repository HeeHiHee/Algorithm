import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] picBlind; // 색약인 사람의 그림
	static int[][] picNormal; // 정상인 사람의 그림

	// 방향 벡터 설정(상, 하, 좌, 우)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 그림의 크기
		picBlind = new int[N][N];
		picNormal = new int[N][N];

		// red는 1, blue는 2, green은 3으로 입력 받기
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'R') {
					picBlind[i][j] = 1;
					picNormal[i][j] = 1;
				} else if (str.charAt(j) == 'B') {
					picBlind[i][j] = 2;
					picNormal[i][j] = 2;
				} else {
					picBlind[i][j] = 1; // 색약인 사람은 red와 같은색으로 봄
					picNormal[i][j] = 3;
				}
			}
		} // 입력 끝

		int cntB = 0; // 색약인 사람의 구역 수
		int cntN = 0; // 정상인 사람의 구역 수

		// 색약인 사람의 구역 수 카운트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (picBlind[i][j] == 1 || picBlind[i][j] == 2) {
					cntB++;
					dfsB(i, j);
				}
				
				if(picNormal[i][j]==1 || picNormal[i][j]==2 || picNormal[i][j]==3) {
					cntN++;
					dfsN(i,j);
				}
			}
		}

		System.out.printf("%d %d", cntN, cntB);
		
		
		
		
		
		
		

	}// main
	
	// 색약일 때
	public static void dfsB(int row, int col) {

		if (picBlind[row][col] == 1) {

			picBlind[row][col] = 999; // 방문했음을 표시

			for (int d = 0; d < 4; d++) {
				int nextR = row + dr[d];
				int nextC = col + dc[d];

				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && picBlind[nextR][nextC] == 1) {
					dfsB(nextR, nextC);
				}

			}
		} else if (picBlind[row][col] == 2) {

			picBlind[row][col] = 999; // 방문했음을 표시

			for (int d = 0; d < 4; d++) {
				int nextR = row + dr[d];
				int nextC = col + dc[d];

				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && picBlind[nextR][nextC] == 2) {
					dfsB(nextR, nextC);
				}
			}

		}
	}//dfsB
	
	// 정상일 때
	public static void dfsN(int row, int col) {

		if (picNormal[row][col] == 1) {

			picNormal[row][col] = 999; // 방문했음을 표시

			for (int d = 0; d < 4; d++) {
				int nextR = row + dr[d];
				int nextC = col + dc[d];

				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && picNormal[nextR][nextC] == 1) {
					dfsN(nextR, nextC);
				}

			}
		} else if (picNormal[row][col] == 2) {

			picNormal[row][col] = 999; // 방문했음을 표시

			for (int d = 0; d < 4; d++) {
				int nextR = row + dr[d];
				int nextC = col + dc[d];

				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && picNormal[nextR][nextC] == 2) {
					dfsN(nextR, nextC);
				}
			}

		}
		else if (picNormal[row][col] == 3) {

			picNormal[row][col] = 999; // 방문했음을 표시

			for (int d = 0; d < 4; d++) {
				int nextR = row + dr[d];
				int nextC = col + dc[d];

				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && picNormal[nextR][nextC] == 3) {
					dfsN(nextR, nextC);
				}
			}

		}
	}//dfsN
	
	
	
}