import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }


        cut(0,0,N);
        System.out.println(sb);


    }//main

    static void cut(int r, int c, int size) {
        // 모두 0이나 1로 되어있으면 리턴
        if(cheak(r,c,size)) {
            if(map[r][c]==0) {
                sb.append(0);
            }else {
                sb.append(1);
            }
            return;
        }

        // 4등분
        int s = size/2;
        sb.append("(");
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                cut(r+s*i, c+s*j, s);
            }
        }
        sb.append(")");

    }//cut

    static boolean cheak(int r, int c, int size) {
        int z = 0;
        int o = 0;
        for(int i=r; i<r+size; i++) {
            for(int j=c; j<c+size; j++) {
                if(map[i][j]==0) {
                    z++;
                } else {
                    o++;
                }
            }
        }

        if(z==0 || o==0) {
            return true;
        }else {
            return false;
        }

    }// 잘라야하는지 확인



}