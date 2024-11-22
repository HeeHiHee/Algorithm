import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E, K, cost[];
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken())+1;
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        cost = new int[V];
        for(int i=0; i<V; i++){list.add(new ArrayList<>());}
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new int[]{v,w});
        }
        Dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<V; i++){
            sb.append(cost[i]==Integer.MAX_VALUE?"INF":cost[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void Dijkstra(int start){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        q.add(new int[]{start, 0});

        while (!q.isEmpty()){
            int[] current = q.poll();
            int curNode = current[0];
            int curCost = current[1];
            if(cost[curNode]<curCost) continue;
            for(int[] n : list.get(curNode)){
                int nextNode = n[0];
                int nextCost = curCost + n[1];
                if(nextCost < cost[nextNode]){
                    cost[nextNode] = nextCost;
                    q.add(new int[]{nextNode, nextCost});
                }
            }
        }
    }
}