import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, u, v, d, ans=0, node1=0;
    static boolean[] visit;
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visit = new boolean[N+1];
        for(int i=0; i<N+1; i++){list.add(new ArrayList<>());}
        for(int i=0; i<N-1; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            d = sc.nextInt();
            list.get(u).add(new int[]{v,d});
            list.get(v).add(new int[]{u,d});
        }
        DFS(1, 0);
        for(int j=0; j<N+1; j++){visit[j]=false;}
        DFS(node1, 0);
        System.out.println(ans);
    }

    public static void DFS(int node, int sum){
        visit[node] = true;
        for(int[] a : list.get(node)){
            int n = a[0]; // 노드 번호
            int d = a[1]; // 가중치
            if(!visit[n]){
                DFS(n, sum+d);
            }
        }
        if(ans<sum){ans = sum; node1 = node;}
    }
}