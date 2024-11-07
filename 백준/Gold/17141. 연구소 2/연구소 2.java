import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, P, ans=54321, Z=0, T=0, pick[], emp; // Z:'0' 개수, T:'2'개수, pick:조합 결과 저장, emp: 빈 공간 개수
    static int[][] map, visit, virus=new int[10][2];
    static int[] dr = {0,0,1,-1}, dc = {1,-1,0,0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        map = new int[N][N];
        visit = new int[N][N];
        pick = new int[M];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                P = sc.nextInt();
                map[i][j] = P;
                if(P==2){virus[T][0]=i; virus[T++][1]=j;}
                if(P==0){Z++;}
            }
        }
        emp = Z+(T-M); // '0'의 개수 + '2'의 개수 - 바이러스 개수
        if(emp == 0){System.out.println(0); return;} // 빈 공간이 없으면 0초 출력
        Combi(0,0);
        System.out.println(ans!=54321?ans:-1);

    }

    static void Combi(int depth, int start){
        if(depth==M){
            // 바이러스 놓을 자리 정했으면 퍼트려
            Spread(emp);
            return;
        }
        for(int i=start; i<T; i++){
            pick[depth] = i;
            Combi(depth+1, i+1);
        }
    }

    static void Spread(int emp){
        visit = new int[N][N];
        q.clear();
        int sec=0; // 걸린 시간

        // 큐에 초기 바이러스 위치 추가
        for(int i=0; i<M; i++){
            int r = virus[pick[i]][0];
            int c = virus[pick[i]][1];
            visit[r][c] = 9; // 방문 처리
            q.add(new int[]{r,c});
        }

        while (true){
            int qSize = q.size();
            sec++;
            // 바이러스 퍼뜨림
            for(int i=0; i<qSize; i++){
                int[] get = q.poll();
                for(int d=0; d<4; d++){
                    int nr = get[0] + dr[d];
                    int nc = get[1] + dc[d];
                    if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]!=1 && visit[nr][nc]!=9){
                        emp--; // 빈 칸 개수 감소
                        visit[nr][nc]=9;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            // 빈 칸에 다 퍼뜨린 경우
            if(emp==0) {ans = Math.min(ans, sec); break;}
            // 빈 칸에 다 퍼뜨리지 않았는데 더이상 퍼트릴 자리가 없는 경우
            if(qSize==0) break;
        }

    }

}