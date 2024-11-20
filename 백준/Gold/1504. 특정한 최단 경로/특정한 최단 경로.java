import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, E, visit[], cost[];
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1; E = Integer.parseInt(st.nextToken());
        visit=new int[N]; cost=new int[N];
        for(int i=0; i<N; i++){cost[i]=Integer.MAX_VALUE; list.add(new ArrayList<>());}
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(u).add(new int[]{v,c});
            list.get(v).add(new int[]{u,c});
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        //case1 : 1-v1-v2-N 순으로 방문
        //case2 : 1-v2-v1-N 순으로 방문
        boolean case1 = true; // 경로가 있는지 확인
        boolean case2 = true; // 경로가 있는지 확인
        Dhstr(1);
        int oneTov1 = cost[v1]; if(oneTov1 == Integer.MAX_VALUE) case1=false;
        int oneTov2 = cost[v2]; if(oneTov2 == Integer.MAX_VALUE) case2=false;

        // 방문배열, 비용배열 초기화
        for(int i=0; i<N; i++){cost[i]=Integer.MAX_VALUE; visit[i]=0;}
        Dhstr(v1);
        int v1Tov2 = cost[v2]; if(v1Tov2 == Integer.MAX_VALUE) case1=false;
        int v1ToN = cost[N-1]; if(v1ToN == Integer.MAX_VALUE) case2=false;

        // 방문배열, 비용배열 초기화
        for(int i=0; i<N; i++){cost[i]=Integer.MAX_VALUE; visit[i]=0;}
        Dhstr(v2);
        int v2ToN = cost[N-1]; if(v2ToN == Integer.MAX_VALUE) case1=false;
        int v2Tov1 = cost[v1]; if(v2Tov1 == Integer.MAX_VALUE) case2=false;

        int ans = -1;
        if(case1 && case2){
            ans = Math.min(oneTov1+v1Tov2+v2ToN, oneTov2+v1ToN+v2Tov1);
        }else if(case1){
            ans = oneTov1+v1Tov2+v2ToN;
        }else if(case2){
            ans = oneTov2+v1ToN+v2Tov1;
        }
        System.out.println(ans);

    }

    public static void Dhstr(int start){
        cost[start] = 0;

        while (true){
            int next = -1; // 다음에 방문할 노드 번호
            int d = Integer.MAX_VALUE; // 최소비용
            for(int i=1; i<N; i++){
                if(visit[i]==0 && cost[i]<d){next = i; d = cost[i];} // 다음에 방문할 노드 찾기
            }
            if(next==-1) break;
            visit[next] = 1; // 방문 처리
            for(int[] i : list.get(next)){
                // 현재 최소비용보다 비용이 더 적다면 최소비용 갱신
                if(cost[next]+i[1] < cost[i[0]]){
                    cost[i[0]] = cost[next]+i[1];
                }
            }
        }

    }
}