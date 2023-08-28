import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int N = str.length(); // 문자열 길이 = 글자 개수

		List<Integer> list = new ArrayList<>(); // 약수를 담을 리스트 생성

		int idx = 0;

		// N의 약수 구하기
		for (int i = 1; i * i <= N; i++) {
			if (N % i == 0) {
				list.add(idx++, i);
				list.add(idx++, N / i);
			}
		}

		// list 뒤에서 2번째가 r이고 1번째가 c이다.
		int r = list.get(list.size() - 2);
		int c = list.get(list.size() - 1);

		// 구한 r,c로 2차원 배열 생성
		char[][] map = new char[r][c];

		// 세로로 글자 삽입
		int index = 0;
		for (int j = 0; j < c; j++) {
			for (int i = 0; i < r; i++) {
				map[i][j] = str.charAt(index++);
			}
		}

		// 가로로 글자 출력
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
		}

	}// main

}
