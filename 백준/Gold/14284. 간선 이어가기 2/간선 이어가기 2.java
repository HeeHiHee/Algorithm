import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cost[];
    static boolean[] visit;
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1; // 정점의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        visit = new boolean[N];
        cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for(int i=0; i<N; i++) list.add(new ArrayList<>());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(u).add(new int[]{v,c});
            list.get(v).add(new int[]{u,c});
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); // 출발점
        int e = Integer.parseInt(st.nextToken()); // 도착점

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        cost[s] = 0;
        q.add(new int[]{s,0});

        while(!q.isEmpty()){
            int[] current = q.poll();
            int curNode = current[0];
            int curCost = current[1];
            if(cost[curNode]<curCost) continue;
            visit[curNode] = true;
            cost[curNode] = curCost;
            if(curNode==e) break;
            for(int[] n : list.get(curNode)){
                int nextNode = n[0];
                int nextCost = curCost + n[1];
                if(nextCost < cost[nextNode]){
                    q.add(new int[]{nextNode, nextCost});
                }
            }
        }
        System.out.println(cost[e]);
    }
}