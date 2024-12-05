import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int T, N, num[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            num = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            // 뒤에서 부터 탐색하여 가장 높은 주가를 찾는다.
            int max = 0;
            long ans = 0;
            for(int i=N-1; i>=0; i--){
                if(num[i]>max) max = num[i];
                else ans += max-num[i];
            }
            sb.append(ans).append("\n");
        }// while
        System.out.println(sb);
    }
}