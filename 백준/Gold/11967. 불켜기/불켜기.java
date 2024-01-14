import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;

    // 2차원 배열안에 리스트 넣기
    static ArrayList<Point>[][] map;

    // 스위치가 켜졌는지 꺼졌는지를 저장할 배열
    static boolean[][] swit;
    static boolean[][] visited;
    static boolean[][] isMove;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }//Point

    public static void main(String[] args) throws IOException {
        // key : 이미 지나온 위치에 인접한 곳의 스위치가 켜진다면 다시 어떻게 방문하지?
        // 1. 현재 위치에 안 켜진 방의 스위치가 있다면 다 켜기
        // 2. 스위치 킨 방이 현재 위치에서 이동가능하면 큐에 넣기
        // 3. 스위치 킨 방에서 4방 탐색했는데, 스위치는 켜져있지만 방문하지 않는 위치가 있다면 큐에 넣기
        // 3. 큐에서 좌표를 하나씩 빼면서 1번부터 다시 반복

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        swit = new boolean[N][N];
        visited = new boolean[N][N];
        isMove = new boolean[N][N];
        ans = 0;

        // 배열에 리스트 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        // 스위치 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            map[x][y].add(new Point(a, b));
        }

        bfs();

        System.out.println(ans);


    }//main

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        swit[0][0] = true; // 스위치 켜짐
        ans++;

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            // 갈 수 있는 방 체크하기
            for (int d = 0; d < 4; d++) {
                int nr = tmp.x + dr[d];
                int nc = tmp.y + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    isMove[nr][nc] = true;
                }
            }

            // 큐에서 꺼낸 좌표에 있는 스위치 다 키고, 큐에 넣어
            for (int i = 0; i < map[tmp.x][tmp.y].size(); i++) {
                Point tmp2 = map[tmp.x][tmp.y].get(i);

                // 스위치가 안켜져 있을때만 스위치 켜
                if (!swit[tmp2.x][tmp2.y]) {
                    swit[tmp2.x][tmp2.y] = true;
                    ans++;
                }

                // 이동할 수 있는 방이라면 큐에 추가
                if (isMove[tmp2.x][tmp2.y] && !visited[tmp2.x][tmp2.y]) {
                    visited[tmp2.x][tmp2.y] = true;
                    q.offer(new Point(tmp2.x, tmp2.y));
                }
            }

            // 이미 스위치가 켜진 방이지만, 방문하지 않은 방이 있다면 큐에 넣기
            // 스위치는 이미 세져있기때문에 방문처리만 하면 됨
            for (int d = 0; d < 4; d++) {
                int nr = tmp.x + dr[d];
                int nc = tmp.y + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N &&
                        !visited[nr][nc] && isMove[nr][nc] && swit[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Point(nr, nc));
                }
            }


        }//while


    }//bfs
}