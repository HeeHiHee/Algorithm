import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.StringTokenizer;

public class Main {
    static int R,C,K;

    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                if(str.charAt(j)=='T'){
                    map[i][j] = -1;
                }else{
                    map[i][j] = 0;
                }
            }
        }

        dfs(R-1, 0, 1);

        System.out.println(ans);

    }//main

    static void dfs(int x, int y, int k){
        if(x==0 && y==C-1 && k==K){
            ans++;
            return;
        }
        map[x][y] = 1; // 방문표시 : 1인 곳은 방문했다는 뜻

        for(int d=0; d<4; d++){
            int nr = x + dr[d];
            int nc = y + dc[d];

            if(nr>=0 && nr<R && nc>=0 && nc<C){
                if(map[nr][nc]==0){
                    dfs(nr,nc,k+1);
                    map[nr][nc] = 0; // 되돌리기
                }
            }
        }

    }//dfs
}