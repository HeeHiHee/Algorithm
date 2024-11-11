import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x,y,d,g,nx,ny;
        boolean[][] map = new boolean[101][101];
        int[] dx={0,-1,0,1}, dy={1,0,-1,0};
        ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

//        // 방향 출력
//        for(int i=0; i<list.size(); i++){
//            System.out.print(list.get(i));
//        }

        for(int t=0; t<T; t++){
            x=sc.nextInt(); y=sc.nextInt(); d=sc.nextInt(); g=sc.nextInt();
            list.clear();
            list.add(d);
            if (g > 0) {
                for(int i=1; i<=g; i++){
                    for(int j=list.size()-1; j>=0; j--){
                        list.add((list.get(j)+1)%4);
                    }
                }

            }
            // 방문 처리
            map[y][x] = true;
            nx=x; ny=y;
            for (int l : list) {
                nx += dy[l];
                ny += dx[l];
                map[ny][nx] = true;
            }
        }//T

        // 사각형 개수 세기
        int cnt = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) cnt++;
            }
        }
        System.out.println(cnt);

    }


}