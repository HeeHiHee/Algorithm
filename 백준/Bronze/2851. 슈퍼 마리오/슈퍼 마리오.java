import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] mush = new int[10];

		for (int i = 0; i < 10; i++) {
			mush[i] = sc.nextInt();
		}

		int sum = 0;
		int now = 0;
		int aft = 0;

		for (int i = 0; i < 10; i++) {
			if (i < 9) {
				sum += mush[i];
				now = sum;
				aft = now + mush[i + 1];

				if (Math.abs(100 - now) < Math.abs(100 - aft)) {
					System.out.println(now);
					break;
				}
			} else {
				sum += mush[i];
				System.out.println(sum);
			}

		}

	}

}
