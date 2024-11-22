import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, map[][], cost[][];
    static int[] dr={0,0,1,-1}, dc={-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M]; cost = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        Dijkstra(new int[]{0,0});
        System.out.println(cost[N-1][M-1]);
    }
    public static void Dijkstra(int[] start){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[start[0]][start[1]] = 0;
        q.add(new int[]{start[0], start[1], 0});

        while(!q.isEmpty()){
            int[] current = q.poll();
            int curR = current[0];
            int curC = current[1];
            int curCost = current[2];
            if(curCost > cost[curR][curC]) continue;
            for(int d=0; d<4; d++){
                int nextR = curR + dr[d];
                int nextC = curC + dc[d];
                if(nextR>=0 && nextR<N && nextC>=0 && nextC<M){
                    int nextCost = curCost + map[nextR][nextC];
                    if(nextCost < cost[nextR][nextC]){
                        cost[nextR][nextC] = nextCost;
                        q.add(new int[]{nextR, nextC, nextCost});
                    }
                }
            }
        }
    }
}