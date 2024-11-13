import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M, u, v, d, start, end;
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=0; i<N+1; i++){list.add(new ArrayList<>());}
        visit = new boolean[N+1];
        for(int i=0; i<N-1; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            d = sc.nextInt();
            list.get(u).add(new int[]{v, d});
            list.get(v).add(new int[]{u, d});
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
        if(start==end){
            sb.append(d).append("\n");
            return;
        }
        // 연결된 간선이 없다면
        for(int[] n : list.get(start)){
            if(!visit[n[0]]){
                DFS(n[0], d+n[1]);
            }
        }
    }
}