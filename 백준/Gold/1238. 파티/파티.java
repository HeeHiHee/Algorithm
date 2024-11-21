import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X, go[], come[], tmp[];
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        go = new int[N]; come = new int[N]; tmp = new int[N];
        for(int i=0; i<N; i++){list.add(new ArrayList<>());}
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.get(u).add(new int[]{v,d});
        }
        // 갈 때
        for(int i=1; i<N; i++){
            if(i==X) continue; // 도착 마을과 출발 마을이 같으면 무시
            Dijkstra(i, tmp); // i번 마을에서 출발하여 다른 마을까지 최단 경로 구하기
            go[i] = tmp[X]; // i번 마을에서 X번 마을까지 가는 최단 경로 저장
        }
        // 올 때
        Dijkstra(X, come);
        int time = 0;
        for(int i=1; i<N; i++){time = Math.max(time, go[i]+come[i]);}
        System.out.println(time);

    }
    public static void Dijkstra(int start, int[] result){
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
    }
}