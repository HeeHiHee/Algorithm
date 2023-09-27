import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝

		/*
		 * 아이디어 1부터 N까지의 조합을 뽑아서 각 팀의 시너지를 계산하고 차이를 변수에 저장한다 위 과정을 반복하면서 시너지 차이를 최솟값으로
		 * 갱신한다.
		 */

		choose(0, 0);

		System.out.println(ans);

	}// main

	// 팀원을 고르는 함수
	// start : 방문배열에서 팀원을 뽑을 매개변수
	// cnt : 지금 사람 몇 명 뽑았니
	static void choose(int start, int cnt) {
		// 기저조건
		// 한 팀의 팀원들을 최대로 뽑았으면 이제 그만!
		if (cnt == N / 2) {
			calculate(); // 뽑힌 팀의 시너지를 계산하는 함수
			return;
		}

		// 재귀영역
		// 조합으로 사람들을 뽑을거임 그래서 i는 start부터 시작해야함 ***
		for (int i = start; i < N; i++) {
			// 방문안했으면 뽑아
			if (!visited[i]) {
				visited[i] = true; // 뽑았다고 표시
				choose(i + 1, cnt + 1); // 다음 친구 뽑기
				visited[i] = false; // 다시 되돌려 놓기

			}

		}

	}// choose

	static void calculate() {
		int start = 0; // 스타트 팀의 능력치 합
		int link = 0; // 링크 팀의 능력치 합

		// 지금 visited 배열이 true반, false 반으로 나뉘어 있따
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 둘 다 true이면 같은 팀임
				if (visited[i] && visited[j]) {
					start += graph[i][j]; // 어차피 i,j 돌면서 j,i도 만나게 됨
				}
				// 둘 다 false이여도 같은 팀
				else if (!visited[i] && !visited[j]) {
					link += graph[i][j];
				}
			}
		}

		int interval = Math.abs(start - link); // 두 팀의 시너지 차이 저장

		ans = Math.min(ans, interval); // 시너지 차이의 최소값을 갱신

	}// calculate

}