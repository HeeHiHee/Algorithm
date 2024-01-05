import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N, cnt;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 노드의 개수

		visited = new boolean[N]; // 방문배열

		int[] parents = new int[N]; // 노드의 부모를 저장할 배열
		// 부모배열 초기화
		for (int i = 0; i < N; i++) {
			parents[i] = 999;
		}

		// 간선을 넣을 리스트 생성
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}

		int start = -1; // 시작노드 저장할 변수
		// 간선 저장
		for (int i = 0; i < N; i++) {
			int p = sc.nextInt();

			parents[i] = p; // i번 노드의 부모는 p

			if (p == -1) {
				start = i; // 시작 노드 저장
			} else {
				list.get(p).add(i); // p+1번 리스트에 노드 i번을 저장
			}
		}

//		for(int i=0; i<N; i++) {
//			System.out.println(list.get(i));
//		}

		boolean T = false; // T가 true이면 시작 노드를 지웠다는 뜻

		int cutNode = sc.nextInt(); // 지울 노드 번호
		if (parents[cutNode] != -1) {
			// 지울 노드 번호의 부모 노드 리스트에서 지울 노드 번호 제거
			list.get(parents[cutNode]).remove(Integer.valueOf(cutNode));
		}
		// 지울 노드 번호의 부모가 없으면 = 시작 노드 이면
		else {
			T = true;
		}

		if (T) {
			// 시작 노드가 지워졌으면 0출력
			System.out.println(0);
		} else {
			cnt = 0;
			dfs(start);
			System.out.println(cnt);

		}

	}// main

	static void dfs(int node) {
//		System.out.println(node);
		visited[node] = true; // 방문표시

		if (list.get(node).size() == 0) {
			cnt++;
		}
		for (int x : list.get(node)) {
			// 방문한적 없다면 방문
			if (!visited[x]) {
				dfs(x);
			}
		}

	}// dfs

}