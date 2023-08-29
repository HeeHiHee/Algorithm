import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n*2; i++) {
			if(i%2 == 1) {
				for(int j=1; j<=n; j++) {
					if(j%2 == 1) {
						sb.append("*");
					}else {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}else {
				for(int j=1; j<=n; j++) {
					if(j%2 ==1) {
						sb.append(" ");
					}else {
						sb.append("*");
					}
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}

}