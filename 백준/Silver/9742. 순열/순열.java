import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,num,cnt;
    static String[] arr;
    static String[] ans;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line=br.readLine())!=null){
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(line);
            String str = st.nextToken();
            N = str.length(); // 문자열의 길이
            num = Integer.parseInt(st.nextToken()); // 출력할 배열 번호

            sb.append(str).append(" ").append(num).append(" = ");

            int fac = 1;
            for(int i=1; i<=N; i++){
                fac *= i;
            }

            if(num>fac){
                sb.append("No permutation");
                System.out.println(sb);
                continue;
            }
            cnt=1;

            arr = new String[N];
            ans = new String[N];
            visited = new boolean[N];

            for(int i=0; i<str.length(); i++){
                arr[i] = String.valueOf(str.charAt(i));
            }

            back(0);
            System.out.println(sb);

        }

    }

    static void back(int idx){

        if(idx==N){
            cnt += 1;
            if(cnt==num+1){
                for(int i=0; i<N; i++){
                    sb.append(ans[i]);
                }
                return;
            }
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                ans[idx] = arr[i];
                visited[i] = true;
                back(idx+1);
                visited[i] = false;
            }
        }

    }



}