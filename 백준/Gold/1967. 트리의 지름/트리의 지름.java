import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, u, v, d, ans=0;
    static boolean[] visit, child; // child:자식이 있으면(true)
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
//        child = new boolean[N+1];
        for(int i=0; i<N+1; i++){list.add(new ArrayList<>());}
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            list.get(u).add(new int[]{v,d});
            list.get(v).add(new int[]{u,d});
//            child[u] = true; // 노드 u는 자식이 있는 노드
        }

        for(int i=1; i<N+1; i++){
            DFS(i, 0);
            for(int j=0; j<N+1; j++){visit[j]=false;}
        }
        System.out.println(ans);
    }

    public static void DFS(int node, int sum){
        visit[node] = true;

        for(int[] a : list.get(node)){
            int n = a[0]; // 노드 번호
            int d = a[1]; // 가중치
            if(!visit[n]){
                DFS(n, sum+d);
            }
        }

        ans = Math.max(ans, sum);

    }
}