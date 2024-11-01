import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][] rotation;
    static int[] order; // 순서 담을 배열
    static boolean[] visit; // 방문 배열
    static int[][] copyMap; // map 깊은 복사
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int res = 54321;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        rotation = new int[K][3];

        order = new int[K];
        visit = new boolean[K];

        // map 입력
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        // 회전 입력
        for(int i=0; i<K; i++){
            for(int j=0; j<3; j++){
                rotation[i][j] = sc.nextInt();
            }
        }

        // 회전 연산 순서 뽑기
        DFS(0);

        // 최소값 출력
        System.out.println(res);

    }

    static void Print(int[][] graph){
        for(int[] row : graph){
            for(int c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    static void DFS(int depth){
        if(depth == K){
            // map 깊은 복사
            copyMap = new int[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    copyMap[i][j] = map[i][j];
                }
            }

            // 회전 연산 순서 정했다면 회전 함수 실행
//            System.out.println(Arrays.toString(order));
            ROT(order);

            // 행 합계
            for(int[] row : copyMap){
                int sum = 0;
                for(int c : row){
                    sum += c;
                }

                if(sum < res){
                    res = sum;
                }
            }

        }

        for(int i=0; i<K; i++){
            if(!visit[i]){
                visit[i] = true;
                order[depth] = i;
                DFS(depth+1);
                visit[i] = false;
            }
        }

    }

    static void ROT(int[] ord){
        for(int o : ord){
            // 왼쪽 위, 오른쪽 아래 좌표 구하기
            int startRow = rotation[o][0] - rotation[o][2] - 1;
            int startCol = rotation[o][1] - rotation[o][2] - 1;
            int endRow = rotation[o][0] + rotation[o][2] - 1;
            int endCol = rotation[o][1] + rotation[o][2] - 1;
//            System.out.println("o :" + o);
//            System.out.println("startRow :" + startRow);
//            System.out.println("startCol :" + startCol);
//            System.out.println("endRow :" + endRow);
//            System.out.println("endCol :" + endCol);



            int n = 0;
            while(true){
                int startR = startRow + n;
                int startC = startCol + n;
                int endR = endRow - n;
                int endC = endCol - n;

                if(startR == endR && startC == endC) break;

                int tmpB = copyMap[startR][startC];
                int tmpA;
                int nr = startR;
                int nc = startC;

                TDout:
                for(int d=0; d<4; d++){
                    boolean flag = true;

                    while(flag){
                        nr += dr[d];
                        nc += dc[d];

//                        System.out.print("nr :" + nr + ", ");
//                        System.out.println("nc :" + nc);


                        if(nr>=startR && nc>=startC && nr<=endR && nc<=endC){
                            tmpA = copyMap[nr][nc];
                            copyMap[nr][nc] = tmpB;
                            tmpB = tmpA;

                            if(nr == startR && nc == startC) break TDout;
//                            System.out.println("들어왔다1");
                        }else{
                            flag = false;
                            nr -= dr[d];
                            nc -= dc[d];

//                            System.out.println("들어왔다2");
                        }

                    }
                }// TDout

                n++;


            }// 시계방향 회전 끝

//            Print(copyMap);
//            System.out.println("--------------------");



        }
    }
}