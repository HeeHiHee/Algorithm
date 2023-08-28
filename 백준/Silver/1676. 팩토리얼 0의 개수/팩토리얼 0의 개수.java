import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger fac = new BigInteger("1");
		
		for(int i=1; i<=n; i++) {
			fac = fac.multiply(BigInteger.valueOf(i));
		}
				
		String st = String.valueOf(fac);
		
		for(int i=st.length()-1, cnt=0; i>=0; i--) {
			char ch = st.charAt(i);
			if(ch != '0') {
				System.out.println(cnt);
				break;
			}else {
				cnt++;
			}
		}
	}//main

}
