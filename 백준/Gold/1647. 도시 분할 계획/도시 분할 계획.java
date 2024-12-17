import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, tree[];
    static PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        Arrays.fill(tree, -1);
        int cost=0, edge=0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            q.add(new int[]{c, u, v});
        }
        for(int i=0; i<M; i++){
            int[] get = q.poll();
            if(!union(get[1], get[2])) continue;
            cost += get[0];
            edge++;
            if(edge==N-3) break;
        }
        System.out.println(N==3?0:cost);
    }

    public static int find(int x){
        if(tree[x]<0) return x;
        return tree[x] = find(tree[x]);
    }

    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return false;
        tree[b] = a;
        return true;
    }
}