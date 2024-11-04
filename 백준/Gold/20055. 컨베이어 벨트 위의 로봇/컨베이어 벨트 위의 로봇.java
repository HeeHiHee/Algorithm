import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, K, Bstart, Bend, Rstart, Rend;
    static int[] robot, belt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        robot = new int[2*N];
        belt = new int[2*N];

        for(int i=0; i<2*N; i++){
            belt[i] = sc.nextInt();
        }

        Bstart=0; Bend=2*N-1; // 밸트 시작점, 끝 점
        Rstart=0; Rend=2*N-1; // 로봇 시작점, 끝 점

        int cnt=0;
        int n=0;
        while(true){
            cnt++;
            n = Rotation();

            if(n >= K) break;
        }

        System.out.println(cnt);
    }

    public static int Rotation(){
        // 1단계 : 벨트 회전
        Bstart--; Bend--; Rstart--; Rend--;

        if(Bstart<0) Bstart = 2*N-1;
        if(Bend<0) Bend = 2*N-1;
        if(Rstart<0) Rstart = 2*N-1;
        if(Rend<0) Rend = 2*N-1;

        // 회전 후 로봇 내려
        Out();

        // 2단계 : 로봇 이동
        int ridx = (Rstart+N-2)%(2*N);
        int bidx = (Bstart+N-1)%(2*N);
        for(int i=0; i<N-1; i++){
            if(robot[ridx]==1 && belt[bidx]>0 && robot[(ridx+1)%(2*N)]==0){
                robot[ridx] = 0;
                robot[(ridx+1)%(2*N)] = 1;
                belt[bidx]--;
            }

            ridx--; bidx--;
            if(ridx<0) ridx = 2*N-1;
            if(bidx<0) bidx = 2*N-1;
        }

        // 이동 후 로봇 내려
        Out();

        // 3단계 : 로봇 올리기
        if (belt[Bstart] > 0 && robot[Rstart] == 0) {
            belt[Bstart]--;
            robot[Rstart] = 1;
        }

        // 4단계 : 내구도 0인 칸 개수
        int p = 0;
        for(int i=0; i<2*N; i++) {
            if (belt[i] == 0) p++;
        }

        return p;

    }

    public static void Out(){
        if(robot[(Rstart+N-1)%(2*N)]==1){
            robot[(Rstart+N-1)%(2*N)] = 0;
        }
    }

}