import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			int key = sc.nextInt();
			
			// upperbound에서 lowerbound를 빼면 개수가 나옴 
			sb.append(upperBound(arr,key) - lowerBound(arr,key)).append(' ');
			
					
		}
		
		// 출력
		System.out.println(sb);
		
		
	}//main
	
	private static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		// lo가 hi와 같아질 때까지 반복
		while(lo < hi) {
			int mid = (lo+hi)/2;
			
			// 상한을 내린다
			if(key <= arr[mid]) {
				hi = mid; // hi = mid -1 하면 안됨 
			}
			// 하한을 올린다
			else {
				lo = mid +1;
			}
			
		}
		
		// return hi 해도 똑같음 
		return lo;	
		
	}//lowerBound
	
	
	private static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length; // arr.length-1을 하게 되면 중복된 수 다음 수 자리가 안 구해짐 
		
		// lo가 hi와 같아질 때까지 반복
		while(lo < hi) {
			int mid = (lo+hi)/2;
			
			// 상한을 내림
			if(key < arr[mid]) {
				hi = mid; // hi = mid -1 하면 안됨 
			}
			
			// 하한을 올림
			else {
				lo = mid + 1;
			}
		}
		
		// return hi 해도 똑같음
		return lo;	
		
	}//upperBound

}