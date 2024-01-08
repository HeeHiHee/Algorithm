import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] map;
    static boolean[] visit;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visit = new boolean[26];
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }


//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

        dfs(0, 0, 1);
        // (0,0)부터 시작하며, 현재 이동한 위치는 0회

        System.out.println(ans);

    }//main

    static void dfs(int x, int y, int count) {
        visit[map[x][y]] = true; // 방문 처리
        ans = Math.max(ans,count); // 최댓값 갱신

        for (int i = 0; i < 4; i++) {
            int nextR = x + dr[i];
            int nextC = y + dc[i];

            if (nextR >= 0 && nextC >= 0 && nextR < R && nextC < C) {
                if(!visit[map[nextR][nextC]]){
                    dfs(nextR, nextC, count + 1);
                    visit[map[nextR][nextC]] = false; // 빠져나오면 다시 되돌려놓기
                }
            }

        }


    }
}