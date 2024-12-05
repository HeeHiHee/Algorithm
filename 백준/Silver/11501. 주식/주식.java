import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int T, N, num[];
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            num = new int[N+1];
            list.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            // 뒤에서 부터 최고가 저장
            int max = 0;
            for(int i=N-1; i>0; i--){
                if(num[i]>=num[i-1] && num[i]>max){
                    list.add(i);
                    max = num[i];
                }
            }
            long ans = 0;
            int size = list.size();
            int idx = 0;
            for(int i=0, j=size-1; i<N; i++){
                if(j<0) break;
                idx = list.get(j);
                if(i==idx){j--; continue;}
                ans += Math.max((num[idx] - num[i]), 0);
            }
            sb.append(ans).append("\n");
        }// while
        System.out.println(sb);
    }
}