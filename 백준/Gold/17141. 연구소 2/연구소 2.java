import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 깊은 복사 제거 버전
    static int N, M, ans=54321, emp=0, vLo;
    static int[][] map, virus;
    static int[] pick;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        map = new int[N][N];
        vLo=0; // 바이러스를 놓을 수 있는 자리 개수
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==2){vLo++;}
                if(map[i][j]==0){emp++;} // 빈 칸 개수
            }
        }

        virus = new int[vLo][2]; // 바이러스를 놓을 수 있는 위치를 저장
        int v=0;
        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(map[i][j]==2){virus[v][0]=i; virus[v][1]=j; v++;}
            }
        }
        pick = new int[M];

        if(emp+(vLo-M) == 0){
            System.out.println(0);
            return;
        }

        // 조합으로 virus 행 인덱스를 뽑아
        Combi(0,0);

        if (ans!=54321) System.out.println(ans);
        else System.out.println(-1);

    }

    static void Combi(int depth, int start){
        if(depth==M){
            // 바이러스 놓을 자리 정했으면 퍼트려
            Spread();
            return;
        }

        for(int i=start; i<vLo; i++){
            pick[depth] = i;
            Combi(depth+1, i+1);
        }
    }

    static void Spread(){
        int sec=0, empCopy=emp+(vLo-M); // 걸린시간, 빈 칸 개수 초기화
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};
        int[][] visit = new int[N][N];
        Queue<int[]> q = new LinkedList<>();
        

        // 바이러스를 퍼뜨릴 자리를 3으로
        for(int i=0; i< pick.length; i++){
            int r = virus[pick[i]][0];
            int c = virus[pick[i]][1];

            map[r][c] = 3;
            visit[r][c] = 1;
            q.add(new int[]{r,c}); // 큐에 바이러스 위치 넣기
        }

        while (true){
            sec++;
            int qSize = q.size();

            // 바이러스 퍼뜨림
            for(int i=0; i<qSize; i++){


                int[] get = q.poll();

                for(int d=0; d<4; d++){
                    int nr = get[0] + dr[d];
                    int nc = get[1] + dc[d];

                    if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]!=1 && visit[nr][nc]==0){
                        empCopy--; // 빈 칸 개수 감소
                        visit[nr][nc]=1;
                        q.add(new int[]{nr,nc});

                    }
                }
            }

            // 빈 칸에 다 퍼뜨린 경우
            if(empCopy==0){
                if(sec<ans){ans=sec;}
                break;
            }

            // 더이상 이동할 수 없는데 빈 칸이 남아있는 경우
            if(qSize==0){
                break;
            }

        }

    }

}