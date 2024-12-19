import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, dp[], max, next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        max = dp[0];
        for(int i=1; i<N; i++){
            next = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(next, next+dp[i-1]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}