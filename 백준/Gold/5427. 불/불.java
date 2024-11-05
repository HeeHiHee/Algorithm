
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int W = sc.nextInt(); int H = sc.nextInt();
            char[][] map = new char[H][W];
            int[][] visit = new int[H][W]; // 상근이 방문했는지

            Queue<int[]> sangQ = new LinkedList<>(); // 상근이 위치 저장
            Queue<int[]> fireQ = new LinkedList<>(); // 불 위치 저장
            int[] dr = {0, 0, 1, -1}; int[] dc = {1, -1, 0, 0};

            for(int i=0; i<H; i++){
                String str = sc.next();
                for(int j=0; j<W; j++){
                    map[i][j] = str.charAt(j);

                    if(map[i][j]=='@'){
                        map[i][j] = '.'; // 상근이 위치 빈 공간으로 입력
                        visit[i][j] = 1; // 방문 표시
                        sangQ.add(new int[]{i,j});
                    }
                    if(map[i][j]=='*'){
                        fireQ.add(new int[]{i,j});
                    }
                }
            }

            int sec = 0; // 탈출시간
            boolean pos = true; // 탈출가넝?

            loopOut :
            while(true){
                sec++;

                // 불 번지기
                int qsize1 = fireQ.size();
                for(int i=0; i<qsize1; i++){
                    int[] fire = fireQ.poll(); // 불 위치 하나 꺼내
                    for(int d=0; d<4; d++){
                        int nr = fire[0] + dr[d];
                        int nc = fire[1] + dc[d];

                        if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]=='.'){
                            map[nr][nc] = '*';
                            fireQ.add(new int[]{nr, nc});
                        }
                    }
                }

                // 상근이 대피
                int qsize2 = sangQ.size();
                if(qsize2==0) {
                    pos = false;
                    break loopOut;
                }
                for(int i=0; i<qsize2; i++){
                    int[] sang = sangQ.poll(); // 상근이 위치 하나 꺼내
                    // 상근이가 출구로 왔는지 확인
                    if(sang[0]==0 || sang[0]==H-1 || sang[1]==0 || sang[1]==W-1) break loopOut;

                    for(int d=0; d<4; d++){
                        int nr = sang[0] + dr[d];
                        int nc = sang[1] + dc[d];

                        if(nr>=0 && nr<H && nc>=0 && nc<W && visit[nr][nc]==0 && map[nr][nc]=='.'){
                            visit[nr][nc] = 1;
                            sangQ.add(new int[]{nr, nc});
                        }
                    }
                }

            }

            if(pos){
                System.out.println(sec);
            }else{
                System.out.println("IMPOSSIBLE");
            }

        }// 테스트 케이스

    }
}