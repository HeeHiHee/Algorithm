import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 간선 담을 리스트
	static boolean[] visited; // 방문 배열
	static int[] dep; // 깊이를 저장할 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		dep = new int[N + 1];
		// 이중 리스트
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		// 간선 입력
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			// 이미 간선 정보가 입력되어 있으면 패쓰
			if (list.get(u).contains(v)) {
				continue;
			} else {
				list.get(u).add(v);
				list.get(v).add(u);

			}
		}

		// 정렬
		for (int i = 0; i < list.size(); i++) {
			Collections.sort(list.get(i));

		}

		int min = (100 * 99) / 2 + 1; // 유저의 수가 최대 100명이므로 1부터 99까지의 합이 가장 큰 베이컨의 수
		int person = 0; // 사람의 번호 저장

		// N번 사람까지 베이컨 수 구하기
		for (int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1]; // 방문배열 초기화
			bfs(i); // i번째 사람부터 시작

			int sum = 0;
			// i번과 j번의 관계 깊이 더하기
			for (int j = 0; j < N + 1; j++) {
				sum += dep[j];
			}

			if (sum < min) {
				min = sum;
				person = i;
			}
		}

		System.out.println(person);

	}// main

	// t : 시작점
	static void bfs(int t) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(t); // 시작점 넣어주기
		visited[t] = true; // 방문했다고 표시
		dep[t] = 0; // 출발점은 깊이가 0

		while (!q.isEmpty()) {
			int take = q.poll(); // 큐에서 하나 꺼내기

			for (int i = 0; i < list.get(take).size(); i++) {
				int tmp = list.get(take).get(i);

				// 방문 안한곳이면 방문하자
				if (visited[tmp] == false) {
					visited[tmp] = true; // 방문했다고 표시
					dep[tmp] = dep[take] + 1; // 꺼낸 노드의 깊이 +1
					q.offer(tmp); // 큐에 넣기
				}

			}

		} // while

	}// bfs

}