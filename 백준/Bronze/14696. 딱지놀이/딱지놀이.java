import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			// A의 문자 개수
			int A = sc.nextInt();
			// A의 카드 배열
			int[] ac = new int[A];
			
			for(int i=0; i<A; i++) {
				ac[i] = sc.nextInt();
			}
			
			
			// B의 문자 개수
			int B = sc.nextInt();
			// B의 카드 배열
			int[] bc = new int[B];
			
			for(int i=0; i<B; i++) {
				bc[i] = sc.nextInt();
			}
			
			// 카운트 배열
			int[] cntA = new int[5];
			int[] cntB = new int[5];
			
			// 카운트
			for(int i=0; i<A; i++) {
				cntA[ac[i]]++;
			}
			for(int i=0; i<B; i++) {
				cntB[bc[i]]++;
			}
			
			// 비교
			for(int i=4; i>=1; i--){
				if(cntA[i] > cntB[i]) {
					System.out.println('A');
					break;
				}else if(cntA[i] < cntB[i]) {
					System.out.println('B');
					break;
				}
				
				if(i==1) {
					if(cntA[i]==cntB[i]) {
						System.out.println('D');
					}
				}
			}
	
		}//testcase 5 
		
	
		
	}//main

}
