import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			q.offer(input);
		}
		
		int ans = 0;
		
		while(q.size()>1) {
			int a = q.poll();
			int b = q.poll();
			
			int sum = a+b;
			
			ans += sum;
			q.offer(sum);
		}
		
		System.out.println(ans);
		
	}//main

}