import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 카드의 개수
		int M = sc.nextInt(); // M
		
		int[] card = new int[N]; // 카드를 담을 배열 
		
		// 배열에 카드를 담기 
		for(int i=0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		
		List<Integer> list = new ArrayList<>(); // 카드의 합을 담을 배열 
		
		// 모든 경우의 수의 카드 합 구하기
		for(int i=0; i<card.length-2; i++) {
			for(int j=i+1; j<card.length-1; j++) {
				for(int k=j+1; k<card.length; k++) {
					list.add(card[i] + card[j] + card[k]);
				}
			}
		}
		
		int min = 300000;
		int res = 0;
		
		for(int i=0; i<list.size(); i++) {
			if(M-list.get(i)>=0 && M-list.get(i) < min) {
				min = M-list.get(i);
				res = list.get(i);
			}
		}
		
		System.out.println(res);
		
		
		
	}//main

}
