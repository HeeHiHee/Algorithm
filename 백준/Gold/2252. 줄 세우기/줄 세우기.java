import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 학생 번호
		int M = Integer.parseInt(st.nextToken()); // 간선 개수

		// 인접 리스트
		ArrayList<ArrayList<Integer>> adjArr = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			adjArr.add(new ArrayList<>());
		}

		int[] degree = new int[N + 1]; // 진입차수 저장

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 시작 정점
			int end = Integer.parseInt(st.nextToken()); // 도착 정점

			adjArr.get(start).add(end); // 연결됐음을 표현, 단방향
			degree[end]++; // 진입차수 하나 증가
		} // 입력끝

		Queue<Integer> q = new LinkedList<>();

		// 큐에 진입차수가 0인 애들 다 넣기
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) {
				q.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();

		// 큐가 빌 때까지 반복
		while (!q.isEmpty()) {
			// 1. 큐에서 꺼내기
			int take = q.poll();
			sb.append(take).append(" "); // 꺼냈으면 얘는 고정이므로 출력

			// 2. 연결돼있는 애들 찾기
			for (int i = 0; i < adjArr.get(take).size(); i++) {

				// 3. 연결돼있는 애들 찾았으면 연결 끊기
//					adjArr[take][i] = 0;
				// 4. 진입차수 하나 감소
				degree[adjArr.get(take).get(i)]--;

				// 5. 진입차수가 0이 되었으면 큐에 넣기
				if (degree[adjArr.get(take).get(i)] == 0) {
					q.offer(adjArr.get(take).get(i));
				}

			}

		} // while
		
		System.out.println(sb);

	}

}