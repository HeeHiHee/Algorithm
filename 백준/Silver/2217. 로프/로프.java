import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, num[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        for(int i=0; i<N; i++)num[i]=Integer.parseInt(br.readLine());
        Arrays.sort(num);
        int ans = 0;
        for(int i=1; i<=N; i++){
            ans = Math.max(ans, num[N-i]*i);
        }
        System.out.println(ans);
    }
}