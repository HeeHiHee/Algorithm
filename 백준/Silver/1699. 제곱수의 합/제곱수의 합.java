import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];
        // 제곱수가 다 1로 구성되어 있을때, 즉 max값으로 선언
        for(int i=0; i<=N; i++){
            dp[i] = i;
        }

        // dp[0]=0
        for(int i=1; i<=N; i++){
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        System.out.println(dp[N]);


    }
}