import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, S, X, Y;
    static int[][] map;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static Queue<point> q = new LinkedList<>();

    public static class point {
        private int x;
        private int y;
        private int v;
        private int time;
        public point(int x, int y, int v, int time) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        ArrayList<point> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0) {
                    list.add(new point(i,j,map[i][j],0));
                }
            }
        }

        Collections.sort(list, new Comparator<point>() {
            public int compare(point o1, point o2) {
                return o1.v - o2.v;
            }
        });

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        for(point p : list) {
            q.add(p);
        }

        bfs();
        System.out.println(map[X-1][Y-1]);

    }//main

    static void bfs() {
        while (!q.isEmpty()) {
            point p = q.poll();

            if(p.time==S) {
                return;
            }

            for(int d=0; d<4; d++) {
                int nr = p.x + dr[d];
                int nc = p.y + dc[d];

                if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==0) {
                    map[nr][nc] = p.v;
                    q.add(new point(nr, nc, p.v, p.time+1));
                }
            }

        }//while

    }//bfs

}