import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr={-1,1,0,0,-1,-1,1,1};
    static int[] dc={0,0,-1,1,-1,1,-1,1};

    static void print(){
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
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

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        // map 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    bfs(i,j);
                    ans++;
                }
            }
        }

        System.out.println(ans);


    }//main

    static void bfs(int r, int c){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r,c));
        visited[r][c] = true;

        while (!q.isEmpty()){
            Point tmp = q.poll();

            for(int d=0; d<8; d++){
                int nr = tmp.x + dr[d];
                int nc = tmp.y + dc[d];

                if(nr>=0 && nr<M && nc>=0 && nc<N && map[nr][nc]==1 && !visited[nr][nc]){
                    q.offer(new Point(nr,nc));
                    visited[nr][nc] = true;
                }
            }



        }//while


    }//bfs




}