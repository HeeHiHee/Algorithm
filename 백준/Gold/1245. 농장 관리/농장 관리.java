import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0,0,-1,1,-1,-1,1,1};
    static int[] dc = {-1,1,0,0,-1,1,-1,1};
    static int cnt;
    static boolean flag;

    static void print(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    static class Point{
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        cnt = 0;
        flag = false;

        // 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // 방문안한곳이면 들어가
                if(!visited[i][j]){
                    flag = true;
                    bfs(i, j, map[i][j]);
                    if(flag) cnt++; // 봉우리를 찾았으면 개수 증가
                }
            }
        }

        System.out.println(cnt);

    }//main

    static void bfs(int x, int y, int height){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Point tmp = q.poll();

            for(int d=0; d<8; d++){
                int nr = tmp.x + dr[d];
                int nc = tmp.y + dc[d];

                // 범위 내에 들어오면
                if(nr>=0 && nr<N && nc>=0 && nc<M){
                    if(map[nr][nc]>height){
                        flag = false;
                    }else if(!visited[nr][nc] && map[nr][nc]==height){
                        q.offer(new Point(nr,nc)); // 큐에 넣기
                        visited[nr][nc] = true;
                    }
                }
            }
        }



    }//bfs


}