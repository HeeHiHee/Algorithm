import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);
        int lo = 0;
        int hi = tree[N-1];

        int ans = 0;

        while (lo<=hi) {
            int mid = (lo+hi)/2 ;

            // 1. 나무 자르기
            long sum = 0;
            for(int i=0; i<N; i++){
                if(tree[i]>mid){
                    sum += tree[i]-mid;
                }
            }
            // 2. 자른 길이 > 원하는 길이
            // 3. 자른 길이 < 원하는 길이
            // 4. 자른 길이 == 원하는 길이
            if(sum>M){
                lo = mid + 1;
                ans = Math.max(ans, mid);
            }else if(sum<M){
                hi = mid - 1;
            }else{
                ans = mid;
                break;
            }

        }//while

        System.out.println(ans);

    }
}