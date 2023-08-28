import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int tc = 0; tc < testCase; tc++) {

			int n = sc.nextInt();
			int[] store = new int[n];

			for (int i = 0; i < store.length; i++) {
				store[i] = sc.nextInt();
			}

			Arrays.sort(store);

			int sum = 0;
			for (int i = 0; i < store.length - 1; i++) {
				sum += store[i + 1] - store[i];
			}

			System.out.println(sum * 2);

		}

	}
}