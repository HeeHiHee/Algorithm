import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dc = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		// 목표지점 찾기(2 좌표값 찾기)
		int targetX = -1;
		int targetY = -1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
				// 2를 찾으면 변수에 좌표값 넣기
				if(graph[i][j]==2) {
					targetX = i;
					targetY = j;
				}
			}
		}
		
		// 갈수 있는 땅인 1인 부분을 -1로 다 바꿔주기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j] == 1) {
					graph[i][j] = -1;					
				}
			}
		}
		
		bfs(targetX, targetY); // 출발점은 2가 있는 곳
		
		// 출력
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
		
		
	}//main
	
	
	public static void bfs(int row, int col) {
		
		// 2가 있는 위치가 시작점
		Queue<Point> q = new LinkedList<>(); // Point 타입의 큐 생성
		Point point = new Point(row, col); // 포인트에 좌표값 한 쌍 넣어주기
		q.offer(point); // 큐에 포인트 넣기
		visited[row][col] = true; // 방문했다고 표시
		graph[row][col] = 0; // 출발 위치는 거리가 0임 
		
		while(!q.isEmpty()) {
			Point tmp = q.poll(); // 큐에서 좌표 하나 꺼내기
			
			for(int d=0; d<4; d++) {
				int nextR = tmp.getX() + dr[d];
				int nextC = tmp.getY() + dc[d];
				
				// 다음 좌표값이 범위를 벗어나지 않고, 값이 1이고, 방문하지 않았으면 
				if(nextR>=0 && nextR<N && nextC>=0 && nextC<M && graph[nextR][nextC]==-1 && visited[nextR][nextC]==false) {
					Point nextPoint = new Point(nextR, nextC); // 포인트에 좌표 넣어주기
					q.offer(nextPoint); // 큐에 좌표 넣어주기
					visited[nextR][nextC] = true; // 방문했다고 표시
					graph[nextR][nextC] = graph[tmp.getX()][tmp.getY()] +1;
				}
 			}			
			
		}//while
		
		
		
	}// bfs
	

}//Main

// 2차원 배열의 좌표를 담아주기 위한 클래스 
class Point{
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}	
	
	
	
}//Point