import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] tmp = new int[n][n];
		int[] arr = new int[n*n];
		
		// 2차원 배열에 넣기
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				tmp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 2차원 배열 1차원으로 바꾸기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[(n*i)+j] = tmp[i][j]; 
			}
		}
		
		Arrays.sort(arr);
		
		int res = arr[n*n-n];
		
		System.out.println(res);		
		
		
		
	}// main

}// Main