import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static Long cost[];
    // 우선순위 큐에 Long을 비교하는 방식으로 수정
    static PriorityQueue<long[]> q = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cost = new Long[N];
        Arrays.fill(cost, Long.MAX_VALUE); // Long.MAX_VALUE로 초기화
        for(int i=0; i<N; i++){list.add(new ArrayList<>());}
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(v).add(new int[]{u,c}); // 역방향 그래프 생성
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int k = Integer.parseInt(st.nextToken());
            q.add(new long[]{k,0L}); // 다익스트라 시작점으로 큐에 추가
            cost[k] = 0L;
        }
        while(!q.isEmpty()){
            long[] current = q.poll();
            int curNode = (int) current[0]; // cost 배열에 인덱스로 들어가야해서 int형
            long curCost = current[1];
            if(curCost>cost[curNode]) continue;
            for(int[] e : list.get(curNode)){
                int nextNode = e[0];
                long nextCost = curCost + e[1];
                if(nextCost<cost[nextNode]){
                    cost[nextNode] = nextCost;
                    q.add(new long[]{nextNode, nextCost});
                }
            }
        }
        int town = 0; // 거리가 가장 먼 도시
        long max = 0; // 거리
        for(int i=1; i<N; i++){
            if(cost[i]>max){max=cost[i]; town=i;}
        }
        System.out.println(town);
        System.out.println(max);
    }
}