import java.util.Scanner;

public class Main {
    static int N, res;
    static int[] arr, ans;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        ans = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        res = 0;
        dfs(0);
        System.out.println(res);

    }//main

    static void dfs(int node) {
        if(node==N) {
            // 계산 진행
            int tmp = 0;
            for(int i=0; i<N-1; i++) {
                tmp += Math.abs(ans[i]-ans[i+1]);
            }
            res = Math.max(res, tmp);
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                ans[node] = arr[i];
                visited[i] = true;
                dfs(node+1);
                visited[i] = false;
            }
        }


    }//dfs
}