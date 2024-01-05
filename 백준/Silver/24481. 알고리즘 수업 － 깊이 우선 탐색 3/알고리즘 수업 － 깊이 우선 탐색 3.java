import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N,M,R;
    static boolean[] visited;
    static int[] depth;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt(); // 정점의 수
        M = sc.nextInt(); // 간선의 수
        R = sc.nextInt(); // 시작 정점

        visited = new boolean[N+1];
        depth = new int[N+1];
        // 방문 배열을 -1로 초기화 해주기
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

        // 오름차순으로 방문하기 때문에 오름차순으로 정렬하기
        for(int i=0; i<N+1; i++){
            Collections.sort(list.get(i));
        }


        dfs(R,0);

        for(int i=1; i<N+1; i++){
            sb.append(depth[i]).append("\n");
        }
        System.out.println(sb);

    }//main

    static void dfs(int node, int dep){
        visited[node] = true;
        depth[node] = dep;

        for(int x : list.get(node)){
            if(!visited[x]){
                dfs(x,dep+1);
            }
        }

    }//dfs


}