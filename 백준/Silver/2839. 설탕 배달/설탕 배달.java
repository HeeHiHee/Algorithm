import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n==4 || n==7) {
			System.out.println(-1);
		}else {
			int sugar = 0;		
			int res = 0;
			
			int n5 = n/5; // n을 5로 나누었을때 몫
			int n3 = n%5; // n을 5로 나누었을때 나머지
			
			switch(n3%3) {
			case 0 :
				res = n3/3;
				sugar = n5 + res;
				break;
			
			case 1 :
				res = (n3+5)/3;
				sugar = (n5-1) + res;
				break;
				
			case 2 :
				res = (n3+10)/3;
				sugar = (n5-2) + res;
				break;
			}
			
			System.out.println(sugar);	
		}	
		
		
	}

}
