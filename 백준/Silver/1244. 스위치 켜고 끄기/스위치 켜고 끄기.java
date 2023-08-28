import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt(); // 스위치 개수
		int[] swi = new int[S]; // 스위치 담을 배열
		
		for(int s=0; s<S; s++) {
			swi[s] = sc.nextInt();
		}
		
		int N = sc.nextInt(); // 사람 수
		for(int n=0; n<N; n++) {
			int gender = sc.nextInt(); // 성별 1, 2
			int num = sc.nextInt(); // 받은 수
			
			// 남자일 때 -> 받은 수의 배수 스위치 바꾸기
			// 여자일 때 -> 받은 수를 기준으로 양 옆 대칭인 만큼 스위치 바꾸기 
			if(gender == 1) {
				// 스위치 배열을 돌면서 
				for(int i=0; i<swi.length; i++) {
					// i번째 스위치의 번호가 num으로 나누어 떨어지면
					if((i+1)%num==0) {
						// 스위치가 0이면 1로, 1이면 0으로 바꾸기 
						if(swi[i]==0) {
							swi[i]=1;
						}else {
							swi[i]=0;
						}
					}
				}
			}else {
				// 여자일때
				int i=0;
				while(num-1-i>=0 && num-1+i<=swi.length-1 && swi[num-1+i] == swi[num-1-i]) {
					// i=0이라는 건 처음 자신 하나임.
					if(i==0) {
						// 0이면 1로, 1이면 0으로 바꾸기
						if(swi[num-1+i]==0) {
							swi[num-1+i]=1;
						}else {
							swi[num-1+i]=0;
						}
					}else {
						if(swi[num-1+i]==0) {
							swi[num-1+i]=1;
							swi[num-1-i]=1;
						}else {
							swi[num-1+i]=0;
							swi[num-1-i]=0;
						}
					}
					i++;
					
				}//while			
				
			}//else
			
					
		}// 사람 한 명씩 반복문
		
		for(int i=0; i<S; i++) {
			if(i>0 && i%20==0) {
				System.out.println();
			}
			System.out.print(swi[i]+" ");
		}
			
		
	}//main

}
