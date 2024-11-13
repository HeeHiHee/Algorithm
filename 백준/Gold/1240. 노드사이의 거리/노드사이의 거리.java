import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, tree[][], u, v, d, start, end;
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        tree = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i=0; i<N-1; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            d = sc.nextInt();
            tree[u][v] = d;
            tree[v][u] = d;
        }
        for(int i=0; i<M; i++){
            start = sc.nextInt();
            end = sc.nextInt();
            BFS(start);
            visit = new boolean[N+1];
        }
        System.out.println(sb);

    }

    public static void BFS(int start){
        Queue<int[]> q = new LinkedList<>();
        visit[start] = true;
        q.add(new int[]{start, 0});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int n = tmp[0]; // 노드 번호
            int d = tmp[1]; // 지금까지 이동한 거리
            // 현재 노드와 도착점이 연결되어 있다면
            if(tree[n][end]!=0){
                sb.append(d+tree[n][end]).append("\n");
                break;
            }
            // 도착점이랑 연결되어있지 않다면
            for(int i=1; i<N+1; i++){
                if(tree[n][i]!=0 && !visit[i]){
                    visit[i] = true;
                    q.add(new int[]{i, d+tree[n][i]});
                }
            }
        }
    }
}