import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 배열의 크기 받기
		int N = sc.nextInt();
		
		// 상을 받는 사람의 수
		int k = sc.nextInt();		

		// 배열 
		int[] arr = new int[N];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 버블 정렬로 풀어보기
		// arr.length-1만큼 반복
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		System.out.println(arr[N-k]);		
		
		
		
		
	}// main

}
