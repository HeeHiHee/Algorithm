import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        ans = new int[M];
        DFS(N,M,0);
        System.out.println(sb);
    }

    static void DFS(int N, int M, int depth) {
        // depth와 M이 같으면 return
        if(depth == M){
            for(int i : ans){
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                ans[depth] = i+1;
                DFS(N, M, depth+1);
                visited[i] = false;
            }
        }
    }
}