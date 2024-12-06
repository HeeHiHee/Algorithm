import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, u, v, start, end;
    static StringTokenizer st;
    static PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
        if(a[0]==b[0]) return a[1]-b[1];
        return a[0]-b[0];
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            q.add(new int[]{u,v});
        }
        long ans = 0;
        int[] fi = q.poll();
        start = fi[0]; end = fi[1];
        while(!q.isEmpty()){
            int[] current = q.poll();
            if(current[0]>=start && current[0]<=end){
                end = Math.max(end, current[1]);
            }
            else{
                ans += end-start;
                start = current[0]; end = current[1];
            }
        }
        ans += end-start;
        System.out.println(ans);
    }
}