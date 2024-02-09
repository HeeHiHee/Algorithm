import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, r,c;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        M = (int) Math.pow(2,N);

        visit(r,c,M);

        System.out.println(cnt);

    }//main


    static void visit(int r, int c, int s) {
        if(s==1) {
            return;
        }

        if(r<s/2 && c<s/2) {
            visit(r,c,s/2);
        }else if(r<s/2 && c>=s/2) {
            cnt += s*s/4;
            visit(r,c-s/2, s/2);
        }else if(r>=s/2 && c<s/2) {
            cnt += s*s/4 * 2;
            visit(r-s/2, c, s/2);
        }else {
            cnt += s*s/4 * 3;
            visit(r-s/2, c-s/2, s/2);
        }





    }//visit



}