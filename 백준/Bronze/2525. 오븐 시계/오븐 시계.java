import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        int time = sc.nextInt();
        int hour = 0;

        // 분이 59분을 초과할때
        if(M+time>59){
            hour = (M+time)/60;
            M = (M+time)%60;
            H += hour;
        }else{
            M += time;
        }

        // 시간이 23시를 초과할때
        if(H>23){
            H = H%24;
        }

        System.out.println(H + " " + M);
    }
}