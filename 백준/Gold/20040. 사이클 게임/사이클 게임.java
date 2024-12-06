import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, tree[], cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        for(int i=0; i<N; i++){tree[i]=i;}
        boolean flag = true;
        for(int i=0; i<M; i++){
            cnt++;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!union(a,b)){
                flag = false;
                break;
            }
        }
        System.out.println(!flag?cnt:0);
    }

    public static int find(int x){
        if(tree[x]==x) return x;
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