import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] dp = new long[101];
        dp[1]=1; dp[2]=1; dp[3]=1; dp[4]=2; dp[5]=2;
        for(int i=6; i<=100; i++){
            dp[i]=dp[i-1]+dp[i-5];
        }
        while(T-->0){
            N = sc.nextInt();
            sb.append(dp[N] + "\n");
        }
        System.out.println(sb);
    }
}