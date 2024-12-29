import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String s, sen, a;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            if(s.equals("#")) break;
            sb.append(s + " "); cnt=0;
            while (st.hasMoreElements()){
                sen = st.nextToken().toLowerCase();
                for(int i=0; i<sen.length(); i++){
                    if(s.equals(String.valueOf(sen.charAt(i)))){
                        cnt++;
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}