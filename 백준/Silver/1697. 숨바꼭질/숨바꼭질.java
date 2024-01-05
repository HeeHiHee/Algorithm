import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 수빈이가 있는 위치
		int K = sc.nextInt(); // 동생이 있는 위치

		int res = bfs(N, K);
		System.out.println(res);

	}// main

	public static int bfs(int n, int k) {
		int[] visited = new int[100001]; // 방문 배열 생성
		for (int i = 0; i < 100001; i++) {
			visited[i] = -1; // 방문 배열 초기화
		}

		Queue<Integer> q = new LinkedList<>(); // 큐 생성
		q.add(n); // 현재 수빈이의 위치를 큐에 넣어줌
		visited[n] = 0; // 현재 위치의 방문 순서를 0으로 넣기

		while (!q.isEmpty()) {
			// 큐에서 하나 꺼내기
			int tmp = q.poll();

			// 동생의 위치와 같으면 그만
			if (tmp == k) {
				return visited[tmp];
			}

			// tmp-1, tmp+1, 2*tmp
			if (tmp - 1 >= 0 && visited[tmp - 1] == -1) {
				visited[tmp - 1] = visited[tmp] + 1; // 방문 횟수
				q.add(tmp - 1); // 큐에 추가
			}

			if (tmp + 1 <= 100000 && visited[tmp + 1] == -1) {
				visited[tmp + 1] = visited[tmp] + 1; // 방문횟수 증가
				q.add(tmp + 1); // 큐에 추가
			}

			if (tmp * 2 <= 100000 && visited[tmp * 2] == -1) {
				visited[tmp * 2] = visited[tmp] + 1;
				q.add(tmp * 2); // 큐에 넣기
			}

		} // while

		return -1;

	}// bfs

}