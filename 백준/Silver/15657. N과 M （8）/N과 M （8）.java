import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] num, ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        DFS(0,0);
        System.out.print(sb);
    }

    public static void DFS(int depth, int start){
        if(depth == M){
            for(int x : ans){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<N; i++){
            ans[depth] = num[i];
            DFS(depth+1, i);
        }
    }



}