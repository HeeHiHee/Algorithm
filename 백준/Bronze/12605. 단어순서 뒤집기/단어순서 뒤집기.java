import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 선언
		
		// 첫번째 정수 받기
		int n = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer token = new StringTokenizer(bf.readLine());
			String[] bae = new String[25];
			int index = 0;
			while(token.countTokens() != 0) {
				bae[index++] = token.nextToken();
			}
			System.out.print("Case #" + (i+1) +": ");
			for(int j=0; j<index; j++) {
				System.out.print(bae[index-j-1] + " ");
			}
			System.out.println();
		}
		
		
	}

}
