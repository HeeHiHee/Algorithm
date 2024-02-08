import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, zero, one, maone;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        // 1. 종이에 같은 숫자들로만 이루어져 있는지 확인
        // 2. 같은 숫자들로만 이루어져 있다면 종이 개수 +1
        // 3. 같은 숫자들로 안이루어져 있다면 9등분으로 나누기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        // 출력
//        for(int i=0; i<3; i++){
//            for(int j=0; j<3; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        zero = 0;
        one = 0;
        maone = 0;

        cut(0,0,N);

        System.out.println(maone);
        System.out.println(zero);
        System.out.println(one);


    }//main

    static void cut(int r, int c, int size) {
        // 해당 맵의 숫자가 다 같을 때
        if (size==1 || isTrue(r,c,size)){
            int color = map[r][c];

            if(color==0){
                zero++;
            }else if(color==1){
                one++;
            }else {
                maone++;
            }
        }else {
            // 숫자가 안같다면 9등분으로 자르기
            int s = size/3;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    cut(r+i*s, c+j*s, s);
                }
            }

        }



    }//cut


    static boolean isTrue(int r, int c, int size){
        boolean ans = true;
        int z = 0;
        int o = 0;
        int m = 0;

        // 해당 맵에 같은 숫자만 있는지 확인
        out :
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(map[i][j]==0) {
                    z++;
                    // 0의 개수가 증가했을때, 1과 -1의 개수가 0보다 크면 같은 숫자만 있는게 아니게됨
                    if(o>0 || m>0){
                        ans = false;
                        break out;
                    }
                }else if(map[i][j]==1) {
                    o++;
                    if(z>0 || m>0){
                        ans = false;
                        break out;
                    }
                }else {
                    m++;
                    if(o>0 || z>0){
                        ans = false;
                        break out;
                    }
                }
            }
        }

        return ans;

    }// isTrue

}