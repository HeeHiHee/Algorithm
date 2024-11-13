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
            DFS(start, 0);
            visit = new boolean[N+1];
        }
        System.out.println(sb);

    }

    public static void DFS(int start, int d){
        visit[start] = true;
        // 도착 노드와 간선이 있다면
        if(tree[start][end]!=0){
            sb.append(d+tree[start][end]).append("\n");
            return;
        }
        // 연결된 간선이 없다면
        for(int i=1; i<N+1; i++){
            if(tree[start][i]!=0 && !visit[i]){
                DFS(i, d+tree[start][i]);
            }
        }
    }
}