import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        long[][] map = new long[100001][3];
        map[1][0]=1; map[2][1]=1; map[3][0]=1; map[3][1]=1;
        map[3][2]=1; map[4][0]=2; map[4][2]=1;
        for(int i=4; i<map.length; i++){
            map[i][0] = (map[i-1][1] + map[i-1][2])%1000000009;
            map[i][1] = (map[i-2][0] + map[i-2][2])%1000000009;
            map[i][2] = (map[i-3][0] + map[i-3][1])%1000000009;
        }
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            sb.append((map[N][0] + map[N][1] + map[N][2])%1000000009).append("\n");
        }//T
        System.out.println(sb);
    }
}