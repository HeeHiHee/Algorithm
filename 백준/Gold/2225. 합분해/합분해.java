import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, K, dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        dp = new int[K+1][N+1];
        Arrays.fill(dp[1], 1);
        for(int i=1; i<=K; i++){dp[i][1]=i;}
        for(int i=2; i<=K; i++){
            for(int j=2; j<=N; j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000;
            }
        }
        System.out.println(dp[K][N]);
    }
}