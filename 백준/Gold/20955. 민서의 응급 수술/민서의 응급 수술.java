import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class Main {
    static int N, M, edge; // edge:사이클 제거하기 위한 간선 수
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        for(int i=0; i<N; i++){list.add(new ArrayList<>());}
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        int compnt = 0; // 컴포넌트 개수
        for(int i=1; i<N; i++){
            if(!visit[i]){
                compnt++;
                DFS1(i, -1);
            }
        }
        System.out.println(edge / 2 + (compnt-1));
    }

    public static void DFS1(int node, int parent){
        visit[node] = true;
        for(int n : list.get(node)){
            if (!visit[n]){
                DFS1(n, node);
            }else if(n != parent){
                edge++;
            }
        }
    }

}