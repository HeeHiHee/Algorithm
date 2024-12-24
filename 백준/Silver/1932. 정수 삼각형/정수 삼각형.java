import java.util.Scanner;

public class Main {
    static int N, dp[][], res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<=i; j++){
                dp[i][j] = sc.nextInt();
                if(i==0){res = dp[i][j]; continue;}
                if(j==0){dp[i][j] += dp[i-1][0];}
                else if(j==i){dp[i][j] += dp[i-1][i-1];}
                else{dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);}
                res = Math.max(res, dp[i][j]);
            }
        }
        System.out.println(res);
    }
}