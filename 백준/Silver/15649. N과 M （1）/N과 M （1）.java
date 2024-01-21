import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[M];
        visited = new boolean[N+1]; // 0부터 N까지의 배열

        dp(0);
    }

    static void dp(int idx){
        if(idx==M){
            for(int i=0; i<M; i++){
                System.out.print(nums[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                nums[idx] = i;
                visited[i] = true;
                dp(idx+1);
                visited[i] = false;
            }
        }



    }//dp

}