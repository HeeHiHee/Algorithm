import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수
		int tc = sc.nextInt();
		
		
		for(int t=0; t<tc; t++) {
			int r = sc.nextInt(); // 반복 횟수
			String s = sc.next(); // 문자열
			
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				for(int j=0; j<r; j++) {
					System.out.print(c);
				}				
			}
			System.out.println();			
			
		}
		
	}

}