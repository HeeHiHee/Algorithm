import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 사람 수
		int M = sc.nextInt(); // 마지막 받는 횟수
		int L = sc.nextInt(); // L번째 사람에게 던지기
		
		// 사람 수 만큼 배열 만들기
		int[] arr = new int[N];
		
		int cnt=0;
		int i=0;
		// 배열의 값이 M-1이면 stop 
		while(arr[i]!=M-1) {
			arr[i]++;
			// 해당 값이 홀수이면 시계방향으로 L만큼 이동 
			if(arr[i]%2==1) {
				i = (i+L) % N;
			}else {
				// 해당 값이 짝수이면 반시계방향으로 L만큼 이동 
				i = ( N + (i-L) ) % N;
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
