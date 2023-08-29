import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String st = sc.next();
		
		int sum = 0;
		for(int i=0; i<st.length(); i++) {
			sum += st.charAt(i)-'0';
		}
		
		System.out.println(sum);
		
		
	}

}