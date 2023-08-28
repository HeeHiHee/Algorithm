import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 문자열 받기
		String str = sc.next();
		
		// 문자 L의 개수를 세기 위한 변수
		int cnt=0;
		
		// 문자열을 하나씩 돌면서 L의 개수를 센다 
		for(int i=0; i<N; i++) {
			if(str.charAt(i) == 'L') {
				cnt++;
			}
		}
		
		// 컵홀더의 개수는 문자열 길이(좌석개수) + 1 - 커플석의 개수(cnt/2)
		int cup = N+1-(cnt/2); //컵홀더 개수
		
		// 컵홀더의 개수가 좌석개수 보다 많으면 좌석 개수 출력
		// 컵홀더의 개수가 좌석개수 보다 적으면 컵홀더 개수 출력 
		if(cup>=N) {
			System.out.println(N);
		}else {
			System.out.println(cup);
		}
		
		
	}

}
