import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int range = 2;
		int cnt = 1;

		if (N == 1) {
			System.out.println(1);
		} else {
			while (range <= N) {
				range += 6 * cnt;
				cnt++;
			}

			System.out.println(cnt);

		} // else

	}// main

}
