import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] cost;
    static ArrayList<Point>[] list;
    static boolean[] visited;

    public static class Point implements Comparable<Point> {
        private int r;
        private int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Point n) {
            return this.c - n.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        cost = new int[N+1];
        for(int i=0; i<N+1; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작
            int v = Integer.parseInt(st.nextToken()); // 끝
            int w = Integer.parseInt(st.nextToken()); // 가중치

            list[u].add(new Point(v,w));
            list[v].add(new Point(u,w));
        }

        dikstr(1);
        System.out.println(cost[N]);



    }//main


    static void dikstr(int start) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        cost[start] = 0; // 시작정점의 비용은 0
        q.offer(new Point(1,0));

        while(!q.isEmpty()) {
            Point point = q.poll();

            if(!visited[point.r]) visited[point.r] = true;
            else continue;

            for(int i=0; i<list[point.r].size(); i++) {
                Point next = list[point.r].get(i);

                if(cost[next.r] > cost[point.r] + next.c) {
                    cost[next.r] = cost[point.r] + next.c;
                    q.offer(new Point(next.r, cost[next.r]));
                }
            }
        }

        // 방문하지 않은 정점중 가중치가 가장 작은 값을 고르기
//        for(int i=1; i<N; i++) {
//            int min = Integer.MAX_VALUE;
//            int idx = -1;
//
//            for(int j=1; j<N+1; j++) {
//                if(!visited[j] && cost[j] < min) {
//                    min = cost[j];
//                    idx = j;
//                }
//            }
//
//            if(idx == -1) break; // 선택할 친구가 없는 경우
//            visited[idx] = true; // 방문 처리
//
//            for(int j=0; j<list.get(idx).size(); j++) {
//                Point point = list.get(idx).get(j);
//
//                if(!visited[point.r] && cost[idx]+point.c < cost[point.r]){
//                    cost[point.r] = cost[idx]+point.c;
//                }
//            }
//
//        }


    }//dikstr


}