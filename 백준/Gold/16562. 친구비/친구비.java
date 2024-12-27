import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, cost[], tree[];
    static ArrayList<HashSet<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cost = new int[N];
        tree = new int[N];
        for(int i=1; i<N; i++){tree[i]=i;}
        for(int i=0; i<N; i++){list.add(new HashSet<>());}
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(v==w) continue;
            list.get(v).add(w);
        }
        for(int i=1; i<N; i++){
            for(int f : list.get(i)){
                union(i,f);
            }
        }
        int res = 0;
        for(int i=1; i<N; i++){
            if(i==tree[i]) res += cost[i];
        }
        System.out.println(res<=K?res:"Oh no");
    }

    public static int find(int x){
        if(tree[x]==x) return x;
        return tree[x] = find(tree[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            tree[b] = a;
            cost[a] = Math.min(cost[a],cost[b]);
        }
    }
}