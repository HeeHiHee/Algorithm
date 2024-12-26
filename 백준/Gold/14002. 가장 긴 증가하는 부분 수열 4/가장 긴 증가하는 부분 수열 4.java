import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N, num[], dp[][], max=0, idx=0;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> st = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N];
        dp = new int[2][N]; // 0행:수열의 길이, 1행:이전 값 인덱스
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
            dp[0][i]=1; dp[1][i]=-1;
            for(int j=i; j>=0; j--){
                if(num[i]>num[j]){
                    dp[0][i] = Math.max(dp[0][j]+1, dp[0][i]);
                    if(dp[0][i]==dp[0][j]+1) dp[1][i] = j;
                }
            }
            max = Math.max(max, dp[0][i]);
            if(max==dp[0][i]) idx=i;
        }
        sb.append(max + "\n");
        while(true){
            if(idx==-1) break;
            st.add(num[idx]);
            idx = dp[1][idx];
        }
        while(!st.isEmpty()){
            sb.append(st.pop() + " ");
        }
        System.out.println(sb);
    }
}