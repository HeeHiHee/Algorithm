import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 이진탐색을 위해 배열 정렬하기
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		
		int lo = 0;
		int hi = arr[arr.length-1];
		
		for(int i=0; i<M; i++) {
			int tmp = sc.nextInt();
			
			// 값이 있으면 1, 없으면 0 출력
			if(binarySearch(arr, tmp) >= 0) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}// M번 반복 끝
		
		
	}
	

	public static int binarySearch(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;

		// lo가 hi보다 커지기 전까지 반복
		while (lo <= hi) {
			/*
			 * 1. 중간 인덱스를 구한다. 2. 중간 값과 key값을 비교한다. 3. 비교 값에 따라 범위를 왼쪽, 오른쪽 혹은 값이 같은 경우는 해당
			 * 인덱스를 반환한다.
			 */

			int mid = (lo + hi) / 2;

			// 중간 값 보다 작을 때
			if (key < arr[mid]) {
				hi = mid - 1;

			}
			// 중간 값 보다 클 때
			else if (key > arr[mid]) {
				lo = mid + 1;

			}
			// 중간 값과 같을 때
			else {
				return mid;

			}
		}

		// while안에서 반환 값이 없다는 말은 찾고자 하는 값이 없다는 것임.
		// 찾고자 하는 값이 존재하지 않을 경우
		return -1;

	}

}