import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static char[][] map;
    static int[][] visited;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static StringBuilder sb = new StringBuilder();

    static void print(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];

        int a = 0;
        int b = 0;
        // 입력받기
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);

                if((i==0 || i==N-1 || j==0 || j==M-1) && map[i][j]=='.'){
                    a = i;
                    b = j;
                }
            }
        }

        dfs(a, b, 1);


    }//main

    static void dfs(int x, int y, int cnt){
        visited[x][y] = cnt;

        if((x==0 || x==N-1 || y==0 || y==M-1) && cnt!=1){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]=='.' && visited[i][j]==0){
                        map[i][j]='@';
                    }
                }
            }
            print();
            System.out.println(sb);
            return;
        }

        for(int d=0; d<4; d++){
            int nr = x + dr[d];
            int nc = y + dc[d];

            if(nr>=0 && nr<N && nc>=0 && nc<M && visited[nr][nc]==0 && map[nr][nc]=='.'){
                dfs(nr,nc,cnt+1);
                visited[nr][nc] = 0;
            }
        }


    }// dfs



}