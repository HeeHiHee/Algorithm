import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] parant; // 부모 노드 저장
    static boolean[] visited; // 방문 배열
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        parant = new int[N+1];
        visited = new boolean[N+1];

        // N-1개의 간선 방 만들기
        for(int i=0; i<N+1; i++){
            list.add(new ArrayList<>());
        }

        // 간선 입력
        for(int i=0; i<N-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            list.get(u).add(v);
            list.get(v).add(u);
        }

        // 1번 노드부터 방문
        dfs(1);

        for(int i=2; i<N+1; i++){
            sb.append(parant[i]).append("\n");
        }
        System.out.println(sb);

    }//main

    static void dfs(int node){
        visited[node] = true;

        for(int x : list.get(node)){
            if(!visited[x]){
                parant[x] = node;
                dfs(x);
            }
        }

    }//dfs
}