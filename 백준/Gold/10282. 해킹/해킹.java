import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T, N, D, C, cost[], cnt, time;
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[1]-b[1]));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken())+1; // 컴퓨터 개수
            D = Integer.parseInt(st.nextToken()); // 의존성 개수
            C = Integer.parseInt(st.nextToken()); // 행킹당한 컴퓨터
            list.clear();
            for(int i=0; i<N; i++){list.add(new ArrayList<>());}
            cost = new int[N]; // 감염 시간 저장
            Arrays.fill(cost, Integer.MAX_VALUE);
            for(int i=0; i<D; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.get(v).add(new int[]{u,c}); // 단방향
            }
            cnt=0; time=0; // cnt:감염 컴퓨터 수, time:감염 걸리는 시간
            q.clear();
            cost[C] = 0;
            q.add(new int[]{C,0});
            while (!q.isEmpty()){
                int[] current = q.poll();
                int curNode = current[0];
                int curCost = current[1];
                if(curCost>cost[curNode]) continue;
                cnt++; time=curCost;
                for(int[] e : list.get(curNode)){
                    int nextNode = e[0];
                    int nextCost = curCost + e[1];
                    if(nextCost<cost[nextNode]){
                        cost[nextNode] = nextCost;
                        q.add(new int[]{nextNode, nextCost});
                    }
                }
            }
            sb.append(cnt).append(" ").append(time).append("\n");
        }
        System.out.println(sb);
    }
}