import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 범위가 long을 안넘어가는데 왜 long을 써야함??
        // 자바에서는 정수형(int)끼리의 계산 결과가 정수형으로 처리됨
        // tmp를 계산하는 부분에서 오버플로우가 발생하기때문에
        // tmp를 계산할 때 사용되는 변수들을 long 형으로 선언하여 보다 큰 범위의 값을 다룰 수 있도록 해야함
        long X = sc.nextInt();
        long Y = sc.nextInt();
        long Z = (Y * 100) / X; // 100

        long lo = 0;
        long hi = 1000000000;
        long mid = 0;
        long tmp = 0;

        while(lo<=hi){
            mid = (lo + hi) / 2;
//            System.out.println(mid);
            tmp = (Y + mid) * 100 / (X + mid);
//            System.out.println("tmp : " + tmp);

            if(tmp == Z){
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }

        }//while

        // 끝까지 구한 확률(승률)이 Z랑 같다면
        // 경우1. mid == 1000000000이라면 애초에 확률이 1이였거나, 최대 게임 횟수만큼 게임을 진행해도 확률이 안바뀐 경우
        // 경우2. mid != 1000000000이라면 hi값이 Z가 처음 변한 자리일때, Z보다 크니까 -1을 해버려서 값을 못찾은 경우
        if(tmp==Z){
            if(mid == 1000000000){
                System.out.println(-1);
            }else {
                System.out.println(mid+1);
            }
        }else{
            System.out.println(mid);
        }



    }//main
}