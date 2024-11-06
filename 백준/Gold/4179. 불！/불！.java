import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R=sc.nextInt(), C=sc.nextInt(), sec=0;
        int[][] map = new int[R][C], visit = new int[R][C];
        Queue<int[]> fire = new LinkedList<>(), jihoon = new LinkedList<>();
        int[] dr = {0,0,1,-1}, dc = {1,-1,0,0};
        boolean pos = true;

        for(int i=0; i<R; i++){
            String str = sc.next();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='J'){
                    map[i][j] = '.';
                    visit[i][j] = 1;
                    jihoon.add(new int[]{i,j});
                }
                if(map[i][j]=='F') fire.add(new int[]{i,j});
            }
        }

        loopOut :
        while (true){
            sec++;

            // 불 번짐
            int fireSize = fire.size();
            for(int i=0; i<fireSize; i++){
                int[] f = fire.poll();
                for(int d=0; d<4; d++){
                    int nr = f[0] + dr[d];
                    int nc = f[1] + dc[d];

                    if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]=='.'){
                        map[nr][nc] = 'F';
                        fire.add(new int[]{nr, nc});
                    }
                }
            }

            // 지훈이 이동
            int jiSize = jihoon.size();

            // 탈출할 수 없는 경우
            if(jiSize==0){
                pos = false;
                break loopOut;
            }

            for(int i=0; i<jiSize; i++){
                int[] j = jihoon.poll();

                for(int d=0; d<4; d++){
                    int nr = j[0] + dr[d];
                    int nc = j[1] + dc[d];

                    // 탈출한 경우(경계에 도달한 경우)
                    if(nr<0 || nr>=R || nc<0 || nc>=C) break loopOut;

                    if(visit[nr][nc]==0 && map[nr][nc]=='.'){
                        visit[nr][nc] = 1;
                        jihoon.add(new int[]{nr, nc});
                    }
                }
            }

        }// while

        if(pos){
            System.out.println(sec);
        }else{
            System.out.println("IMPOSSIBLE");
        }


    }
}