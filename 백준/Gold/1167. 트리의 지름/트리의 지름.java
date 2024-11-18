import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, node1=0, d=0;
    static boolean[] visit;
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt()+1;
        visit = new boolean[N];
        for(int i=0; i<N; i++){list.add(new ArrayList<>());}
        // 간선 정보 입력 받기
        for(int i=1; i<N; i++){
            int n = sc.nextInt();
            while(true){
                int v = sc.nextInt();
                if(v==-1) break;
                int s = sc.nextInt();
                list.get(n).add(new int[]{v,s});
            }
        }
        visit[1] = true;
        DFS(1,0);
        visit = new boolean[N];
        visit[node1] = true;
        DFS(node1, 0);
        System.out.println(d);
    }

    public static void DFS(int node, int sum){

        for(int i=0; i<list.get(node).size(); i++){
            int n = list.get(node).get(i)[0];
            int s = list.get(node).get(i)[1];
            if(!visit[n]){
                visit[n] = true;
                DFS(n, sum+s);
            }
        }
        if(d<sum){d=sum; node1=node;}
    }
}