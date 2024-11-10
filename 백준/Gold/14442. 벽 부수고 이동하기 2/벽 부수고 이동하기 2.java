import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, K, map[][], visit[][][], r, c, broken, nr, nc;
    static int[] dr={-1, 1, 0, 0}, dc={0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt(); K = sc.nextInt();
        map = new int[N][M]; visit = new int[N][M][K+1];
        for(int i=0; i<N; i++){
            String str = sc.next();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 시작점 큐에 넣고, 방문처리
        q.add(new int[]{0,0,0});
        visit[0][0][0] = 1;

        int ans = BFS();
        System.out.println(ans==7654321?-1:ans);

    }

    public static int BFS(){
        int kan = 7654321;
        while(!q.isEmpty()){
            int[] get = q.poll();
            r = get[0];
            c = get[1];
            broken = get[2]; // 지금까지 벽을 몇 개 부쉈는지

            for(int d=0; d<4; d++){
                nr = r + dr[d];
                nc = c + dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<M){
                    // 벽이고, 지금까지 부순 벽 개수가 K개 미만이고, 방문하지 않았으면 벽 부수기
                    if(map[nr][nc]==1 && broken<K && visit[nr][nc][broken+1]==0){
                        visit[nr][nc][broken+1] = visit[r][c][broken] + 1;
                        q.add(new int[]{nr,nc,broken+1});
                    }
                    // 벽이 아니고, 방문하지 않았으면 이동하기
                    else if(map[nr][nc]==0 && visit[nr][nc][broken]==0){
                        visit[nr][nc][broken] = visit[r][c][broken] + 1;
                        q.add(new int[]{nr,nc,broken});
                    }
                }
            }
        }

        for(int i=0; i<K+1; i++){
            if(visit[N-1][M-1][i] == 0) continue;
            kan = Math.min(kan, visit[N-1][M-1][i]);
        }

        return kan;

    }//BFS
}