import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 인덱스가 0~41까지인 크기가 42 배열 생성
		int[] cnt = new int[42];
		
		for(int i=0; i<10; i++) {
			cnt[sc.nextInt()%42]++;
		}
		
		
		int res = 0;
		
		for(int i=0; i<42; i++) {
			if(cnt[i]!=0) {
				res++;
			}
		}
		
		System.out.println(res);
	}

}
