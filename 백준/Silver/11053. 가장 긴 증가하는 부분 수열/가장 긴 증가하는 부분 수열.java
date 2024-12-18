import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N], dp = new int[N];
        int res=0;
        for(int i=0; i<N; i++){
            nums[i]=sc.nextInt();
            dp[i] = 1;
            for(int j=i; j>=0; j--){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}