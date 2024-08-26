import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] num, ans;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        ans = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num); // 오름차순 정렬

        DFS(0);
        System.out.print(sb);

    }

    static void DFS(int depth){
        if(depth == M){
            for(int x : ans){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                ans[depth] = num[i];
                DFS(depth+1);
                visit[i] = false;
            }
        }
    }


}