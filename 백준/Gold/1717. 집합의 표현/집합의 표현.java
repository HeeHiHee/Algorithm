import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, tree[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        Arrays.fill(tree, -1);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (o == 0) uni(a, b); // 합집합
            else check(a, b); // 같은 집합인지 확인
        }
        System.out.println(sb);
    }
    public static void check(int u, int v){
        int a = find(u);
        int b = find(v);
        sb.append(a==b?"yes":"no").append("\n");
    }

    public static int find(int x){
        if(tree[x]<0) return x;
        // 경로 압축 최적화
        return tree[x] = find(tree[x]);
    }

    public static void uni(int u, int v){
        int a = find(u);
        int b = find(v);
        if(a==b) return;
        // union by rank 최적화
        if(tree[b] < tree[a]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(tree[a]==tree[b]) tree[a]--;
        tree[b] = a;
    }

}