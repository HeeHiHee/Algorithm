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
        int case1 = -1, case2 = -1;
        int a1 = Dhstr(1,v1), a2 = Dhstr(v1,v2), a3 = Dhstr(v2,N-1),
                b1 = Dhstr(1,v2), b3 = Dhstr(v1,N-1);
        if(a1>=0 && a2>=0 && a3>=0) case1 = a1+a2+a3;
        if(b1>=0 && a2>=0 && b3>=0) case2 = b1+a2+b3;
        System.out.println(case1!=-1&&case2!=-1?Math.min(case1, case2):Math.max(case1, case2));
    }

    public static int Dhstr(int start, int end){
        // 방문배열, 비용배열 초기화
        for(int i=0; i<N; i++){cost[i]=Integer.MAX_VALUE; visit[i]=0;}
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
        return cost[end]==Integer.MAX_VALUE?-1:cost[end];
    }
}