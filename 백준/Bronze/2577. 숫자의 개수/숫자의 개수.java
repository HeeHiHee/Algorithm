import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int res = A * B * C;
		
		String str = Integer.toString(res);
		
		int[] cnt = new int[10];
		
		for(int i=0; i<str.length(); i++) {
			cnt[str.charAt(i)-'0']++;
		}
		
		for(int i=0; i<cnt.length; i++) {
			System.out.println(cnt[i]);
		}
		
		
	}

}