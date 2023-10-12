import java.util.Scanner;

public class Main {
	static int N,ans;
	static int[][] map;
	static int[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new int[N][N];
		
		ans = 0;
		
		put(0);
		
		System.out.println(ans);
		
		
	}//main
	
	static void put(int row) {
		// 기저조건
		if(row==N) {
			ans++; // 퀸을 다 놓았으니 카운트 하나 증가
			return;
		}
		
		for(int i=0; i<N; i++) {
			// 방문해도 되는 자리면 방문하기
			if(visited[row][i]==0) {
				mark(row, i);
				put(row+1);
				markBack(row,i);
			}
		}		
		
		
	}//put
	
	static void mark(int row, int col) {
		for(int i=0; i<N; i++) {
			visited[row][i]++; // 가로 방문 표시
			visited[i][col]++; // 세로 방문 표시
			
			// 오른쪽 아래
			if(row+i<N && col+i<N) {
				visited[row+i][col+i]++;
			}
			
			// 왼쪽 아래
			if(row+i<N && col-i>=0) {
				visited[row+i][col-i]++;
			}
			
			// 오른쪽 위
			if(row-i>=0 && col+i<N) {
				visited[row-i][col+i]++;
			}
			
			// 왼쪽 위
			if(row-i>=0 && col-i>=0) {
				visited[row-i][col-i]++;
			}		
			
		}
		
		
		
		
	}//mark
	
	static void markBack(int row, int col) {
		for(int i=0; i<N; i++) {
			visited[row][i]--; // 가로 방문 표시
			visited[i][col]--; // 세로 방문 표시
			
			// 오른쪽 아래
			if(row+i<N && col+i<N) {
				visited[row+i][col+i]--;
			}
			
			// 왼쪽 아래
			if(row+i<N && col-i>=0) {
				visited[row+i][col-i]--;
			}
			
			// 오른쪽 위
			if(row-i>=0 && col+i<N) {
				visited[row-i][col+i]--;
			}
			
			// 왼쪽 위
			if(row-i>=0 && col-i>=0) {
				visited[row-i][col-i]--;
			}		
			
		}
		
	}// markBack

}