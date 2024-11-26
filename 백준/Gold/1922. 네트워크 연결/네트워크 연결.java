import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, tree[];
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        tree = new int[N+1];
        Arrays.fill(tree, -1);
        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{c,u,v});
        }
        Collections.sort(list, (a,b)->(a[0]-b[0])); // 비용 오름차순 정렬
        int ans = 0; // 출력할 최소비용
        int edge = 0; // 선택한 간선 수 : N-1개이면 반복문 종료
        // 간선 수만큼 반복
        for(int i=0; i<M; i++){
            int[] current = list.get(i);
            int curCost = current[0];
            int curU = current[1];
            int curV = current[2];
            if(!check(curU, curV)) continue;
            ans += curCost;
            edge++;
            if(edge==N-1) break;
        }
        System.out.println(ans);
    }

    public static boolean check(int u, int v){
        int a = find(u);
        int b = find(v);
        if(a==b) return false; // 이미 같은 그룹일 때
        if(tree[b] < tree[a]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(tree[a]==tree[b]) tree[a]--;
        tree[b] = a;
        return true; // 같은 그룹으로 묶었으면 true 반환
    }

    public static int find(int x){
        if(tree[x]<0) return x;
        return tree[x] = find(tree[x]); // 경로압축
    }
}