import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();
		String[] arr = new String[st.length()];
		Stack<String> stack = new Stack<>();

		int cnt = 0; // 여는 괄호(의 개수
		int sum = 0; // 막대기 개수 총 합

		// 배열에 넣기
		for (int i = 0; i < arr.length; i++) {
			// substring(i, i+1) 공부하기
			arr[i] = st.substring(i, i + 1);
		}

		// 하나씩 꺼내서 검사하고 stack에 넣기
		for (int i = 0; i < arr.length; i++) {
			// ( 여는 괄호이면 스택에 넣어라
			if (arr[i].equals("(")) {
				stack.push(arr[i]);
				cnt++;
				// ) 닫는 괄호일 때
			} else {
				// 바로 전 애가 ( 이면 얜 레이저임
				if (arr[i - 1].equals("(")) {
					stack.pop();
					cnt--; // pop한 ( 하나 감소
					sum += cnt; // 여는 괄호 개수 = 잘린 막대기 수
				} else {
					stack.pop();
					cnt--;
					sum += 1; // 레이저가 아닌 닫는 괄호 )이면 닫힐 때마다 막대기 수 하나씩 증가함.
				}
			}

		} // stack

		System.out.println(sum);

	}// main

}
