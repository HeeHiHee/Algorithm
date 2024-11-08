import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, K, Z=0, T=0, ans=10000; // Z:0개수, T:2개수
    static int[][] map, visit, virus=new int[10][2];
    static int[] dr={0,0,1,-1}, dc={1,-1,0,0}, pick;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        visit = new int[N][N];
        pick = new int[M]; // 조합으로 뽑은 M개의 바이러스

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                K = sc.nextInt();
                map[i][j] = K;
                if(K==2){virus[T][0]=i; virus[T++][1]=j;}
                if(K==0) Z++;
            }
        }
        if(Z==0){System.out.println(0); return;}
        Combi(0,0);
        System.out.println(ans==10000?-1:ans);

    }

    public static void Combi(int depth, int start){
        if(depth==M){
            Spread(Z);
            return;
        }
        for(int i=start; i<T; i++){
            pick[depth] = i;
            Combi(depth+1, i+1);
        }
    }//Combi

    public static void Spread(int zero){
        visit = new int[N][N];
        int sec=0;
        q.clear();
        // 뽑은 바이러스 방문처리, 큐에 넣기
        for(int i=0; i<M; i++){
            int r = virus[pick[i]][0]; // 뽑은 바이러스의 행 인덱스
            int c = virus[pick[i]][1]; // 뽑은 바이러스의 열 인덱스
            visit[r][c] = 1;
            q.add(new int[]{r,c});
        }

        while (true){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] get = q.poll();
                for(int d=0; d<4; d++){
                    int nr = get[0] + dr[d];
                    int nc = get[1] + dc[d];

                    if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]!=1 && visit[nr][nc]!=1){
                        visit[nr][nc]=1;
                        if(map[nr][nc]==0) zero--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            sec++;
            if(zero==0){ans=Math.min(ans,sec); break;}
            if(size==0) break;
        }

    }//Spread
}