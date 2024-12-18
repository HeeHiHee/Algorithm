import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] x = new double[N], y = new double[N];
        for(int i=0; i<N; i++){x[i]=sc.nextDouble(); y[i]=sc.nextDouble();}
        double res = 0.0;
        for(int i=0; i<N; i++){
            int t = (i+1)%N; // 마지막 점은 처음 점과 연결
            res += x[i]*y[t] - y[i]*x[t];
        }
        res = Math.abs(res)/2.0;
        System.out.printf("%.1f", res);
    }
}