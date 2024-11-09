import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt(), M=sc.nextInt(), dr[]={-1,1,0,0}, dc[]={0,0,-1,1}, ans=1000000;
        int[][] map = new int[N][M];
        int[][][] visit = new int[N][M][2]; //[r][c][0]:벽 부수지 않고 이동한 경우, [r][c][1]:벽 1개 부수고 이동한 경우
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            String str = sc.next();
            for(int j=0; j<M; j++){
                map[i][j]= str.charAt(j) - '0';
            }
        }
        visit[0][0][0] = 1;
        q.add(new int[]{0,0,0});
        while(true){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] get = q.poll();
                int r = get[0];
                int c = get[1];
                int broken = get[2];

                for(int d=0; d<4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(nr>=0 && nr<N && nc>=0 && nc<M){
                        // 1. 벽이고, 부순 적 없고, 방문한 적 없으면
                        if(map[nr][nc]==1 && broken==0 && visit[nr][nc][1]==0){
                            visit[nr][nc][1] = visit[r][c][0] + 1;
                            q.add(new int[]{nr,nc,1});
                        }
                        // 2. 벽이 아니고, 방문한 적 없으면
                        else if(map[nr][nc]==0 && visit[nr][nc][broken]==0){
                            visit[nr][nc][broken] = visit[r][c][broken] + 1;
                            q.add(new int[]{nr,nc,broken});
                        }
                    }
                }
            }//size

            if(q.isEmpty()){
                int zero = visit[N-1][M-1][0];
                int one = visit[N-1][M-1][1];
                System.out.println((zero+one == 0)?-1:(zero*one==0)?Math.max(zero,one):Math.min(zero,one));
                break;
            }


        }//while


    }
}