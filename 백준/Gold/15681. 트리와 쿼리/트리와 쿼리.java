import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q, u, v, dp[], U;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점
        R = Integer.parseInt(st.nextToken()); // 루트
        Q = Integer.parseInt(st.nextToken()); // 쿼리
        visit = new boolean[N+1]; // 방문 배열
        dp = new int[N+1]; // 서브트리에 속한 정점 수 저장할 배열
        Arrays.fill(dp,1);
        for(int i=0; i<=N; i++){list.add(new ArrayList<>());}
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        DFS(R,0);
        for(int i=0; i<Q; i++){
            U = Integer.parseInt(br.readLine());
            sb.append(dp[U]+"\n");
        }
        System.out.println(sb);
    }
    public static void DFS(int cur, int parent){
        visit[cur] = true;
        for(int nxt : list.get(cur)){
            if(visit[nxt]) continue;
            DFS(nxt, cur);
        }
        dp[parent] += dp[cur];
    }
}