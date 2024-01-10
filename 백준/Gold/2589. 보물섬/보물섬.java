import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, cnt, ans;
    static int[][] map;
    static int[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static void print(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

    public static class Point{
        private int x;
        private int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void reset(){
        // visited -1로 초기화
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                visited[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new int[R][C];
        ans = 0;

        // map 입력 받기
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                if(str.charAt(j)=='L'){
                    map[i][j] = 1; // 육지
                }else{
                    map[i][j] = 0; // 바다
                }
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]==1){
                    reset(); // 방문 배열 초기화
                    cnt=0; // 이동거리 초기화
                    bfs(i,j);
                }
            }
        }

        System.out.println(ans);


    }//main


    static void bfs(int r, int c){
        // 큐 생성
        Queue<Point> q = new LinkedList<>();
        // 시작 좌표 큐에 넣기
        q.offer(new Point(r,c));
        // 방문 처리
        visited[r][c] = 0;

        // 큐가 빌 때까지 반복 돌리기
        while(!q.isEmpty()){
            // 큐에서 좌표하나 빼고
            Point tmp = q.poll();

            // 4방 탐색 후
            for(int d=0; d<4; d++){
                int nextR = tmp.x + dr[d];
                int nextC = tmp.y + dc[d];

                // 방문하지 않았고, 1(땅)이면 큐에 넣기
                if(nextR>=0 && nextR<R && nextC>=0 && nextC<C && visited[nextR][nextC]==-1 && map[nextR][nextC]==1){
                    q.offer(new Point(nextR, nextC));
                    visited[nextR][nextC] = visited[tmp.x][tmp.y]+1;
                    ans = Math.max(ans, visited[nextR][nextC]);
                }
            }
        }

    }

}