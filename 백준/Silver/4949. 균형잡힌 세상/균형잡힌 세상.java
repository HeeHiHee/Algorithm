import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문장을 받아올 변수 
		String sen;
		
		Stack<Character> stack = new Stack<>();
		

		while(true) {
			stack.clear();
			
			sen = sc.nextLine();
			
			// .이 나오면 반복문 종료 
			if(sen.equals(".")) {
				break;
			}
			
			for(int i=0; i<sen.length(); i++) {
				char tmp = sen.charAt(i);
				
				// (, [ 는 push
				if(tmp == '(' || tmp == '[') {
					stack.push(tmp);
				}else if(tmp == ')') {
					if(stack.empty()) {
						stack.push(tmp);
					}else if(stack.peek() == '(') {
						stack.pop();
					}else {
						stack.push(tmp);
					}
				}else if(tmp == ']') {
					if(stack.empty()) {
						stack.push(tmp);
					}else if(stack.peek() == '[') {
						stack.pop();
					}else {
						stack.push(tmp);
					}
				}
			}
			
			if(!stack.empty()) {
				System.out.println("no");
			}else {
				System.out.println("yes");
			}
			
		}// while
		
		
		
		
	}//main

}
