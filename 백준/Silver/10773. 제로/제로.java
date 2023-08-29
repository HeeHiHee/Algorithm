import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> st = new Stack<>(); // int형 스택 선언
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				st.pop();
			}else {
				st.push(num);
			}
		}
		
		// peek()함수는 몇 번을 하던 맨 위에 있는 6만 계속 꺼냄
		int sum = 0;
		while (!st.isEmpty()){
			sum += st.pop();
		}
	
		System.out.println(sum);
		
	}
}