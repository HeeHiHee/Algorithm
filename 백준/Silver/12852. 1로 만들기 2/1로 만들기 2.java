import java.util.Scanner;

public class Main {
    static int N, dp[][], min;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N+1][2];
        for(int i=2; i<=N; i++){
            min = dp[i-1][1];
            dp[i][0] = i-1;
            if(i%2==0){
                if(min>dp[i/2][1]){
                    min = dp[i/2][1];
                    dp[i][0] = i/2;
                }
            }
            if(i%3==0){
                if(min>dp[i/3][1]){
                    min = dp[i/3][1];
                    dp[i][0] = i/3;
                }
            }
            dp[i][1] = min+1;
        }
        sb.append(dp[N][1]+"\n");
        while(N>0){
            sb. append(N+" ");
            N = dp[N][0];
        }
        System.out.println(sb);
    }
}