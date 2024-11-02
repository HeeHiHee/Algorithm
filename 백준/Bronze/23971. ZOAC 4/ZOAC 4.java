import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt(); // 행 개수
        int W = sc.nextInt(); // 열 개수
        int N = sc.nextInt(); // 행 차이
        int M = sc.nextInt(); // 열 차이

        int rowCnt = 0;
        int n = 0;
        while((N+1)*n <= H-1){
            rowCnt++;
            n++;
//            System.out.println(rowCnt);
        }

        int colCnt = 0;
        int m = 0;
        while((M+1)*m <= W-1) {
            colCnt++;
            m++;
//            System.out.println(colCnt);
        }

        System.out.println(rowCnt * colCnt);
    }
}