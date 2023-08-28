import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String big = sc.next().toUpperCase();
		sc.close();
		
		int[] cnt = new int[26];
		
		for(int i=0; i<big.length(); i++) {
			cnt[big.charAt(i) - 65]++;
		}
		
		int max = -1;
		char cha = ' ';
		
		for(int i=0; i<cnt.length; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
				cha = (char)(i + 65);
			}
			else if(cnt[i] == max) {
				cha = '?';
			}
		}
		
		System.out.println(cha);
		
	}

}