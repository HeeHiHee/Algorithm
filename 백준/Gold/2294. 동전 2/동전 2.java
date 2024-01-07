import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 동전 종류 수
		int K = sc.nextInt(); // 줘야하는 거스름돈

		int[] change = new int[N];
		for (int i = 0; i < N; i++) {
			change[i] = sc.nextInt();
		} // 1원, 5원, 12원

		int[] dp = new int[K + 1];
		// dp[0] = 0;

		for (int i = 1; i < K + 1; i++) {
			int min = 987654321;

			for (int j = 0; j < change.length; j++) {
				if (i >= change[j]) {
					min = Math.min(min, dp[i - change[j]] + 1);
				}
			}

			dp[i] = min;

		}

		if (dp[K] == 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}

	}// main

}