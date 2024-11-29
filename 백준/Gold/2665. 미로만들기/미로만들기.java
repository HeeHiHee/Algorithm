import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N], cost = new int[N][N];
        for(int[] r : cost){Arrays.fill(r, Integer.MAX_VALUE);}
        for(int i=0; i<N; i++){
            String s = sc.next();
            for(int j=0; j<N; j++){
                map[i][j] = (s.charAt(j)-'0')==0?1:0;
            }
        }

        int[] dr={-1,1,0,0}, dc={0,0,-1,1};
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        cost[0][0] = 0;
        q.add(new int[]{0,0,0}); // 행, 열, 검은방을 바꾼 개수
        while (!q.isEmpty()){
            int[] current = q.poll();
            int curR = current[0];
            int curC = current[1];
            int curCost = current[2];
            if(curCost>cost[curR][curC]) continue;
            for(int d=0; d<4; d++){
                int nextR = curR + dr[d];
                int nextC = curC + dc[d];
                if(nextR>=0 && nextR<N && nextC>=0 && nextC<N){
                    int nextCost = curCost + map[nextR][nextC];
                    if(nextCost<cost[nextR][nextC]){
                        cost[nextR][nextC] = nextCost;
                        q.add(new int[]{nextR, nextC, nextCost});
                    }
                }
            }
        }
        System.out.println(cost[N-1][N-1]);
    }
}