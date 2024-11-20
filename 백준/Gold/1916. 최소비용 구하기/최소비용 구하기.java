import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cost[], start, end, visit[]; // cost : 도시까지 가는데 드는 최소 비용을 저장할 배열
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine())+1;
        M = Integer.parseInt(br.readLine());
        cost = new int[N]; visit = new int[N];
        for(int i=0; i<N; i++){cost[i]=Integer.MAX_VALUE;} // 최대 값으로 배열 초기화
        for(int i=0; i<N; i++){list.add(new ArrayList<>());}
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(u).add(new int[]{v,c});
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()); end = Integer.parseInt(st.nextToken());
        Dhstr(start);
        System.out.println(cost[end]);
    }

    public static void Dhstr(int s){
        cost[s] = 0; // 시작 노드는 거리 0으로 초기화

        while(true){
            int next = -1; // 가장 비용이 적은 노드(다음 방문할 노드)
            int d = Integer.MAX_VALUE; // 비용
            for(int i=1; i<N; i++){
                if(visit[i]==0 && cost[i]<d){next=i; d=cost[i];} // 다음 방문할 노드 찾기
            }
            if(next==-1) break; // 더이상 방문할 노드가 없으면 탈출
            visit[next] = 1; // 방문처리
            for(int[] i : list.get(next)){
                // (현재 도시(next)의 비용 + 다음 도시 비용)이 저장된 다음 도시 최소비용보다 적으면 갱신
                if(cost[next]+i[1]<cost[i[0]]){
                    cost[i[0]] = cost[next]+i[1];
                }
            }
        }
    }
}