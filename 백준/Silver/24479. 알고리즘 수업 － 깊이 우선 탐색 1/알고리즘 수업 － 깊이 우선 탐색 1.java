import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N,M,R;
	static int cnt = 1; // 방문 순서 번호 매기기 
	
	static int[] visited; // 방문 배열 
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 2중 리스트 생성 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 정점의 수 : 1~N 까지의 정점
		M = sc.nextInt(); // 간선의 수
		R = sc.nextInt(); // 시작 정점 
		
		visited = new int[N+1]; // 인덱스 1번을 노드 1로 볼거임
		
		// 2중 리스트를 만드는 작업 -> 배열과는 다르다 
		// 1번 리스트에 노드 1과 연결된 노드를 담을 거임 
		// N번 리스트에 노드 N과 연결된 노드를 담을 거기 때문에 총 N+1개를 만듦 
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 연결 노드 넣기 
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			graph.get(u).add(v); // u번째 리스트에 v를 넣기 
			graph.get(v).add(u); // v번째 리스트에 u를 넣기 
		}
		
		// 리스트 정렬하기
		// 오름차순으로 노드에 방문할거기 때문에 정렬함 
		for(int i=1; i<N+1; i++) {
			Collections.sort(graph.get(i));
		}
		
		// R번 노드부터 방문 시작
		dfs(R); 
		
		// 출력
		for(int i=1; i<N+1; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb);
		
		
		
	}// main
	
	
	// dfs 함수 만들기
	// node : 시작 노드 
	public static void dfs(int node) {
		visited[node] = cnt; // node번 노드에 방문한 순번 입력 
		
		for(int x : graph.get(node)) {
			// x번 노드에 방문한 적이 없다면, cnt 증가 시키고 방문해라 
			if(visited[x] == 0) {
				cnt++;
				dfs(x);
			}
		}	
		
	}//dfs
	
	
	

}