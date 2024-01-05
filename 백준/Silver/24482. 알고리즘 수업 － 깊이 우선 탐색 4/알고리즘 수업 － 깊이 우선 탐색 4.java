import java.util.*;

public class Main {
    static int N,M,R;
    static int[] depth;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        visited = new boolean[N+1];
        depth = new int[N+1];
        for(int i=0; i<N+1; i++){
            depth[i] = -1;
        }

        for(int i=0; i<N+1; i++){
            list.add(new ArrayList<>());
        }

        // 간선입력받기
        for(int i=0; i<M; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            list.get(u).add(v);
            list.get(v).add(u);
        }

        // 내림차순으로 방문
        for(int i=0; i<N+1; i++){
            list.get(i).sort(Comparator.reverseOrder());
        }

        dfs(R,0);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N+1; i++){
            sb.append(depth[i]).append("\n");
        }

        System.out.println(sb);


    }//main

    static void dfs(int node, int d){
        visited[node] = true;
        depth[node] = d;

        for(int x : list.get(node)){
            if(!visited[x]){
                dfs(x,d+1);
            }
        }
    }


}