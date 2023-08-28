import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=(n-i); j++) {
				sb.append(" ");
			}
			
			int m = 2*i-1;
			for(int k=1; k<=m; k++) {
				sb.append("*");
			}
			
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
}