import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, map[][], cost[][], id[][], visit[][];
    static int[] dr={-1,1,0,0}, dc={0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();
    static HashSet<Integer> hs = new HashSet<>();
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M]; cost = new int[N][M]; id = new int[N][M]; visit = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
        // 0이면 DFS 실행
        int idx = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0 && visit[i][j]!=2){
                    int able = BFS1(i,j); // 이동할 수 있는 칸 개수
                    BFS2(i, j, able, idx++); // 이동할 수 있는 칸 개수로 채우기
                }
            }
        }
        // 벽(1)인곳 방문해서 답 구하기
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){sb.append("0");}
                else{
                    int[][] arr = new int[4][2]; // 0:idx, 1:cost
                    for(int d=0; d<4; d++){
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(nr>=0 && nr<N && nc>=0 && nc<M){
                            arr[d][0] = id[nr][nc];
                            arr[d][1] = cost[nr][nc];
                        }
                    }
                    hs.clear();
                    list.clear();
                    for(int[] row : arr){
                        if(!hs.contains(row[0])){
                            hs.add(row[0]);
                            list.add(row);
                        }
                    }
                    int ans = 1;
                    for(int[] get : list){
                        ans+=get[1];
                    }
                    sb.append(ans%10);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static int BFS1(int r, int c){
        visit[r][c] = 1;
        q.add(new int[]{r,c});
        int cnt = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<M && visit[nr][nc]==0 && map[nr][nc]==0){
                    cnt++;
                    visit[nr][nc] = 1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return cnt;
    }
    public static void BFS2(int r, int c, int cnt, int i){
        visit[r][c] = 2;
        cost[r][c] = cnt;
        id[r][c] = i;
        q.add(new int[]{r,c});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<M && visit[nr][nc]==1 && map[nr][nc]==0){
                    visit[nr][nc] = 2;
                    cost[nr][nc] = cnt;
                    id[nr][nc] = i;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}