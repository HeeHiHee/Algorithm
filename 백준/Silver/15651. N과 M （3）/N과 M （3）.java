import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[M];
        DFS(0);
        System.out.print(sb);
    }

    public static void DFS(int depth){
        if(depth == M){
            for(int x : ans){
                sb.append(x).append(' ');
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            ans[depth] = i+1;
            DFS(depth+1);
        }
    }


}