import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static ArrayList<ArrayList<Integer>> list;
	static int[] visited;
	static int cnt;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 정점의 번호

		// 정점의 개수+1만큼 리스트 넣어주기
		list = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		// 리스트에 간선 넣어주기
		// 간선의 개수만큼 for문 돌리기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// 해당 간선이 없으면 넣기
			if (!list.get(u).contains(v)) {
				// u번 정점에 v값 넣어주기
				list.get(u).add(v);
				list.get(v).add(u);
			}

		}

		// 정점 번호가 작은 거부터 방문하므로 오름차순 정렬
		for (int i = 0; i < list.size(); i++) {
			Collections.sort(list.get(i));
		}

		sb = new StringBuilder();
		cnt = 1;

		// DFS 출력
		visited = new int[N + 1]; // 1~N까지의 방문배열
		DFS(V);

		sb.append("\n");

		// BFS 출력
		visited = new int[N + 1]; // 방문배열 초기화
		BFS();

		System.out.println(sb);

	}// main

	static void DFS(int node) {
		visited[node] = cnt; // 방문 처리, 방문 순서 입력
		sb.append(node).append(" ");

		for (int x : list.get(node)) {
			if (visited[x] == 0) {
				cnt++;
				DFS(x);
			}
		}

	}// DFS

	static void BFS() {
		Queue<Integer> q = new LinkedList<>();

		q.offer(V);
		visited[V] = cnt++;
		sb.append(V).append(" ");

		while (!q.isEmpty()) {
			int node = q.poll();

			for (int x : list.get(node)) {
				if (visited[x] == 0) {
					q.offer(x);
					visited[x] = cnt++;
					sb.append(x).append(" ");
				}
			}

		} // while

	}// BFS

}