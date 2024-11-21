import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X, go[], come[];
    static ArrayList<ArrayList<int[]>> list1 = new ArrayList<>();
    static ArrayList<ArrayList<int[]>> list2 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        go = new int[N]; come = new int[N];
        for(int i=0; i<N; i++){list1.add(new ArrayList<>());}
        for(int i=0; i<N; i++){list2.add(new ArrayList<>());}
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list1.get(u).add(new int[]{v,d});
            list2.get(v).add(new int[]{u,d});
        }
        come = Dijkstra(X, list1);
        go = Dijkstra(X, list2);
        int time = 0;
        for(int i=1; i<N; i++){time = Math.max(time, go[i]+come[i]);}
        System.out.println(time);
    }
    public static int[] Dijkstra(int start, ArrayList<ArrayList<int[]>> list){
        int[] result = new int[N];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        q.add(new int[]{start, 0});

        while(!q.isEmpty()){
            int[] current = q.poll();
            int curNode = current[0];
            int curCost = current[1];
            if(curCost > result[curNode]) continue;
            for(int[] n : list.get(curNode)){
                int nextNode = n[0];
                int nextCost = curCost + n[1];
                if(nextCost < result[nextNode]){
                    result[nextNode] = nextCost;
                    q.add(new int[]{nextNode, nextCost});
                }
            }
        }
        return result;
    }
}