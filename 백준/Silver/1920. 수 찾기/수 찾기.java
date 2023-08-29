import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N  = sc.nextInt();
		int[] arrN = new int[N];
		for(int i=0; i<N; i++) {
			arrN[i] = sc.nextInt();
		}
		
		Arrays.sort(arrN); // 오름차순으로 정렬 
		
		int M = sc.nextInt();
		for(int m=0; m<M; m++) {
			int x = sc.nextInt();
			
			int lo = 0;
			int hi = N-1; // 5
			int mid;
			
			int res = 0; // 존재하지 않을 때를 초기 값으로 잡음 
			
			while(lo <= hi) {
				
				mid = (lo + hi) / 2;
				
				// x가 mid보다 왼쪽에 있을 때는 hi를 mid로 내리기
				// x가 mid보다 오른쪽에 있을 때는 lo를 mid로 올리기 
				if(x < arrN[mid]) {
					hi = mid-1;
				}
				else if(x > arrN[mid]) {
					lo = mid+1;
				}else {
					res = 1;
					break;
				}				
				
				
			}//while
			
			System.out.println(res);
			
			
			
			
		}// M
		
		
		
	}//main

}