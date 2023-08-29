import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String s = sc.next();
			
			int cnt = 0;
			int res = 0;
			
			for(int i=0; i<s.length(); i++) {
				char ch = s.charAt(i);
				
				if(ch == 'O') {
					cnt++;
					res += cnt;
				}else {
					cnt=0;
				}
						
			}// s
			
			System.out.println(res);
					
			
			
		}// t
	}// main

}
