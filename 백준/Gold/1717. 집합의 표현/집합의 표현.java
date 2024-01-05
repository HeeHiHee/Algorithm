import java.util.Scanner;

public class Main {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 1부터 N까지
		int M = sc.nextInt(); // 연산의 개수

		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = i;
		}

		for (int m = 0; m < M; m++) {
			int cal = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			// cal이 0이면 두 집합 합치기
			if (cal == 0) {
				union(x, y);
			}
			// 아니면 두 원소가 같은 집합에 포함되어 있는지 확인
			else {
				if (findset(x) == findset(y)) {
					// 같은 집합에 있으면 1출력
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		} // 연산의 개수 m만큼 반복
		System.out.println(sb);

	}// main

	static int findset(int x) {
		// 패스 컴푸레숀
		if (x != arr[x]) {
			arr[x] = findset(arr[x]); // arr[x] -> x
		}
		return arr[x];

	}// findset

	static void union(int x, int y) {
		arr[findset(y)] = findset(x);
	}// union

}