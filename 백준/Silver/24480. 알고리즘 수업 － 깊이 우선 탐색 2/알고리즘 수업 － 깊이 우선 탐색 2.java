import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R; // 정점의 수, 간선의 수, 시작 정점
	static ArrayList<ArrayList<Integer>> list; // 간선 정보 담을 리스트
	static int[] visited; // 방문 순서를 담을 배열
	static int cnt = 1; // 방문 순서

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		visited = new int[N + 1]; // 방문 배열 크기는 N+1개
		list = new ArrayList<>();

		// 정점의 수만큼 2차원 리스트 만들기
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		// 양방향 간선 정보 입력하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list.get(u).add(v);
			list.get(v).add(u);
		}

		// 내림차순으로 방문하므로 내림차순 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}

		dfs(R);

		// 출력
		for (int i = 1; i < N + 1; i++) {
			System.out.println(visited[i]);
		}

	}// main

	public static void dfs(int node) {

		// 시작 노드에 방문 순서 입력
		visited[node] = cnt;

		for (int x : list.get(node)) {
			// 방문한 노드가 아니라면 방문하기
			if (visited[x] == 0) {
				cnt++;
				dfs(x);
			}
		}

	}// dfs

}