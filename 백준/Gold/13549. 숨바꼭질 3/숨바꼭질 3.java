import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static int[] time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 수빈이가 있는 위치
		K = sc.nextInt(); // 동생이 있는 위치

		time = new int[100001]; // 이동한 시간을 저장
//		for(int i=0; i<100001; i++) {
//			time[i] = -1;
//		}

		bfs();

		System.out.println(time[K]-1);

	}// main

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		time[N] = 1; // 이동안했으니 N에서의 시간은 0초
		q.offer(N); // 현재 수빈이의 위치 큐에 넣기

		while (!q.isEmpty()) {
			int take = q.poll(); // 큐에서 하나 빼

			// -1, +1, *2한 위치가 범위내에 있고
			// 해당 위치로 이동한 적이 있어도 시간이 더 적게 걸리면 방문
			// 그럼 끝내는 조건을 어떻게 하지?
			// 동생을 찾았어도 그게 가장 빠른 시간이 아닐 수 있음
			// 그럼 가장 빠른 시간을 찾으려면 어떻게 하지?

			if (take * 2 >= 0 && take * 2 < 100001) {
				// 2배 이동한 위치가 이동한 적이 있어도 시간이 더 적게 걸리면 더 적게 걸린 시간으로 갱신
				if (time[take * 2] == 0 || time[take * 2] > time[take]) {
					time[take * 2] = time[take]; // 걸린 시간은 그대로
					q.offer(take * 2); // 값이 갱신되었을때만 큐에 넣기
				}

			}

			if (take + 1 >= 0 && take + 1 < 100001) {
				if (time[take + 1] == 0 || time[take + 1] > time[take] + 1) {
					time[take + 1] = time[take] + 1; // 걸린 시간은 그대로
					q.offer(take + 1);
				}
			}

			if (take - 1 >= 0 && take - 1 < 100001) {
				if (time[take - 1] == 0 || time[take - 1] > time[take] + 1) {
					time[take - 1] = time[take] + 1; // 걸린 시간은 그대로
					q.offer(take - 1);
				}
			}

		} // while

	}// bfs

}