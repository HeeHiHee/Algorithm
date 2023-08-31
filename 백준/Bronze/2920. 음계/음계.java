import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] ac = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] dc = { 8, 7, 6, 5, 4, 3, 2, 1 };

		boolean bool = false;

		int tmp1 = sc.nextInt();

		if (tmp1 == 1) {
			for (int j = 1; j < 8; j++) {
				int tmp2 = sc.nextInt();
				if (ac[j] != tmp2) {
					bool = false;
					System.out.println("mixed");
					break;
				} else {
					bool = true;
				}

			}
			if (bool) {
				System.out.println("ascending");
			}

		} // 처음 숫자가 1일때
		else if (tmp1 == 8) {
			for (int j = 1; j < 8; j++) {
				int tmp2 = sc.nextInt();
				if (dc[j] != tmp2) {
					bool = false;
					System.out.println("mixed");
					break;
				} else {
					bool = true;
				}
			}
			if (bool) {
				System.out.println("descending");
			}
		}else {
			System.out.println("mixed");
		}
		
		
		
		

	}// main

}