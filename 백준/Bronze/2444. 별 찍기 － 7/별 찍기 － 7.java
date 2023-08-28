import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-i; j++) {
				sb.append(" ");
			}
			for(int j=1; j<=(2*i)-1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		
		for(int i=1; i<=n-1; i++) {
			for(int j=1; j<=i; j++) {
				sb.append(" ");
			}
			for(int j=1; j<=2*(n-i)-1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}