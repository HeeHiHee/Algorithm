import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	
	List<String> fun = new ArrayList<String>();
	for(int i=0; i<n; i++) {
		String word = sc.next();
		if(word.equals("push_back")) {
			n++;
			fun.add(i, word);
		}else if(word.equals("push_front")) {
			n++;
			fun.add(i, word);
		}else {
			fun.add(i, word);
		}
	}
	
	StringBuilder sb = new StringBuilder();
	
	Deque<Integer> deq = new ArrayDeque<>();
	for(int i=0; i<fun.size(); i++) {
		switch(fun.get(i)) {
		
		case "push_front":
			String str1 = fun.get(i+1);
			int a1 = Integer.parseInt(str1);
			deq.addFirst(a1);
			break;
		
		case "push_back":
			String str2 = fun.get(i+1);
			int a2 = Integer.parseInt(str2);
			deq.addLast(a2);
			break;
			
		case "pop_front":
			if(deq.isEmpty() == true) {
				sb.append(-1).append("\n");
			}else {
				sb.append(deq.pollFirst()).append("\n");
			}
			break;
			
		case "pop_back":
			if(deq.isEmpty()) {
				sb.append(-1 + "\n");
			}else {
				sb.append(deq.pollLast()).append("\n");
			}
			break;
			
		case "size":
			sb.append(deq.size()).append("\n");
			break;
			
		case "empty":
			if(deq.isEmpty()) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
			break;
			
		case "front":
			if(deq.isEmpty()) {
				sb.append(-1).append("\n");
			}else {
				sb.append(deq.peekFirst()).append("\n");
			}
			break;
			
		case "back":
			if(deq.isEmpty()) {
				sb.append(-1 + "\n");
			}else {
				sb.append(deq.getLast()).append("\n");
			}
			break;
			
		}
	}
	sc.close();
	System.out.println(sb.toString());
}
}
