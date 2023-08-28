import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //색종이 개수
		
		int[][] map = new int[100][100];
		
		for(int i=0; i<N; i++) {
			int srt = sc.nextInt()-1;
			int ed = sc.nextInt()-1;
			
			for(int r=srt; r<srt+10; r++) {
				for(int c=ed; c<ed+10; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		int cnt=0;
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]==1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		
	}//main

}
