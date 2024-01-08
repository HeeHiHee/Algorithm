import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T,H,W,ans;

    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++){

            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new int[H][W];

            for(int i=0; i<H; i++){
                String str = br.readLine();
                for(int j=0; j<W; j++){
                    if(str.charAt(j)=='#'){
                        map[i][j] = 1; // 양이 있으면 1
                    }else{
                        map[i][j] = 0;
                    }
                }
            }

            ans = 0;
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    // 양이 있으면 dfs 들어가라
                    if(map[i][j]==1){
                        dfs(i,j);
                        ans++;
                    }
                }
            }

            System.out.println(ans);




        }//t

    }//main

    static void dfs(int x, int y){
        map[x][y] = 2; // 방문처리

        for(int d=0; d<4; d++){
            int nr = x + dr[d];
            int nc = y + dc[d];

            if(nr>=0 && nr<H && nc>=0 && nc<W){
                if(map[nr][nc]==1){
                    dfs(nr,nc);
                }
            }
        }



    }//dfs
}